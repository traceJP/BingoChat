package src.main.java.com.tracejp.bingochart.client.gui.listener;

import src.main.java.com.tracejp.bingochart.client.ClientGUI;
import src.main.java.com.tracejp.bingochart.client.ClientRope;
import src.main.java.com.tracejp.bingochart.client.gui.ChatGUI;
import src.main.java.com.tracejp.bingochart.common.domain.Connector;
import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.RequestMapping;
import src.main.java.com.tracejp.bingochart.common.utils.StringUtils;
import src.main.java.com.tracejp.bingochart.common.utils.UUIDUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import java.awt.event.*;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/11 23:33
 */
public class ChatGUIListener {

    private static final int MAX_CHAT_INPUT = 50;

    private static final int MAX_QUERY_CHAT_LOG = 50;

    private static final int ROOM_INFO_PERIODIC_REFRESH_TIME = 10;

    private final ChatGUI chatGUI = ChatGUI.getInstance(ChatGUI.class);


    public void initAllListener() {
        chatGUI.sendButton.addActionListener(e -> new Thread(sendButtonAction()).start());
        chatGUI.chatInputTextField.addKeyListener(chatInputTextFieldSpaceKeyListener());
        chatGUI.refreshButton.addActionListener(e -> new Thread(refreshButtonAction()).start());
        chatGUI.fontSizeComboBox.addActionListener(e -> new Thread(this::saveFontConfig).start());
        chatGUI.fontStyleComboBox.addActionListener(e -> new Thread(this::saveFontConfig).start());
        chatGUI.fontColorComboBox.addActionListener(e -> new Thread(this::saveFontConfig).start());
        chatGUI.chatLogTextArea.getDocument().addDocumentListener(chatLogTextAreaListener());
        chatGUI.exitButton.addActionListener(e -> new Thread(exitButtonAction()).start());
        ClientGUI.clientGUI.addWindowListener(windowListener());
    }

    public void initAllResource() {
        Connector connector = ClientRope.serverConnector;
        String userUUID = ClientRope.getUserUUID();

        // 获取配置信息
        Message queryFontConfigMassage = new Message(
                UUIDUtils.getUUID(),
                RequestMapping.QUERY_FONT_CONFIG,
                Collections.singletonMap("uuid", userUUID)
        );
        connector.sendMessage(queryFontConfigMassage);

        // 获取聊天记录
        Message queryChatLogMassage = new Message(
                UUIDUtils.getUUID(),
                RequestMapping.QUERY_CHAT_LOG,
                Collections.singletonMap("number", MAX_QUERY_CHAT_LOG)
        );
        connector.sendMessage(queryChatLogMassage);

        // 心跳获取 房间信息
        Thread thread = new Thread(() -> {
            for (; ; ) {
                try {
                    TimeUnit.SECONDS.sleep(ROOM_INFO_PERIODIC_REFRESH_TIME);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Message queryRoomInfoMassage = new Message(
                        UUIDUtils.getUUID(),
                        RequestMapping.QUERY_ROOM_INFO,
                        null
                );
                connector.sendMessage(queryRoomInfoMassage);
            }
        });
        thread.setDaemon(true);  // 守护 ClientGUI 线程
        thread.start();
    }

    // =================================== Client ===================================

    private WindowListener windowListener() {
        return new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Connector connector = ClientRope.serverConnector;
                if (connector != null && connector.getSocket().isConnected()) {
                    new Thread(exitButtonAction()).start();
                }
            }
        };
    }

    // =================================== Action ===================================

    private Runnable sendButtonAction() {
        return () -> {
            String rawText = chatGUI.chatInputTextField.getText();
            if (StringUtils.isEmpty(rawText)) {
                return;
            }
            String htmlText = formatTextToHtml(rawText);

            // 追加到聊天框
            HTMLDocument document = (HTMLDocument) chatGUI.chatLogTextArea.getDocument();
            try {
                document.insertAfterEnd(document.getCharacterElement(document.getLength()), htmlText);
            } catch (BadLocationException | IOException e) {
                throw new RuntimeException(e);
            }

            // 发送
            Map<String, Object> requestParams = new HashMap<>();
            requestParams.put("uuid", ClientRope.getUserUUID());
            requestParams.put("message", rawText);
            Message message = new Message(UUIDUtils.getUUID(), RequestMapping.SEND_MESSAGE, requestParams);
            ClientRope.serverConnector.sendMessage(message);

            // 清空输入面板
            chatGUI.chatInputTextField.setText("");

        };
    }

    private KeyListener chatInputTextFieldSpaceKeyListener() {
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    new Thread(sendButtonAction()).start();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
    }

    private Runnable refreshButtonAction() {
        return () -> {
            // 清空输入面板
            chatGUI.chatLogTextArea.setText("");
        };
    }


    private DocumentListener chatLogTextAreaListener() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                JScrollBar scrollBar = chatGUI.chatLogScrollPane.getVerticalScrollBar();
                new Thread(() -> SwingUtilities.invokeLater(() -> {
                    scrollBar.setValue(scrollBar.getMaximum());
                    try {  // 防止文档插入过快导致滚动条无法滚动到最底部
                        TimeUnit.MILLISECONDS.sleep(100);
                        scrollBar.setValue(scrollBar.getMaximum());
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                })).start();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };
    }

    /**
     * 保存配置
     */
    private void saveFontConfig() {
        if (chatGUI.saveFontConfigCheckBox.isSelected()) {
            Map<String, Object> params = new HashMap<>();
            params.put("uuid", ClientRope.getUserUUID());
            params.put("font_size", chatGUI.fontSizeComboBox.getSelectedIndex());
            params.put("font_style", chatGUI.fontStyleComboBox.getSelectedIndex());
            params.put("font_color", chatGUI.fontColorComboBox.getSelectedIndex());
            Message message = new Message(UUIDUtils.getUUID(), RequestMapping.SAVE_FONT_CONFIG, params);
            ClientRope.serverConnector.sendMessage(message);
        }
    }

    private Runnable exitButtonAction() {
        return () -> {
            // 发送下线通知
            Map<String, Object> requestParams = new HashMap<>();
            requestParams.put("uuid", ClientRope.getUserUUID());
            final String offLineText = "用户 【 " + ClientRope.username + " 】 下线了...";
            requestParams.put("message", formatTextBySystemInformToHtml(offLineText));
            Message sendMessage = new Message(UUIDUtils.getUUID(), RequestMapping.SEND_MESSAGE, requestParams);
            ClientRope.serverConnector.sendMessage(sendMessage);

            // 服务器下线
            Message offlineMessage = new Message(
                    UUIDUtils.getUUID(),
                    RequestMapping.OFFLINE,
                    Collections.singletonMap("uuid", ClientRope.getUserUUID())
            );
            ClientRope.serverConnector.sendMessage(offlineMessage);

            // TODO 关闭窗口

        };
    }

    /**
     * 包装文本为 HTML 格式
     *
     * @param chatText 聊天文本
     * @return 包装后的 HTML 格式文本
     */
    private String formatTextToHtml(String chatText) {
        // 字符格式化
        if (chatText.length() > MAX_CHAT_INPUT) {
            chatText = chatText.substring(0, MAX_CHAT_INPUT) + "...";
        }

        // 获取样式
        String selectedStyle = (String) chatGUI.fontStyleComboBox.getSelectedItem();
        String selectedColor = (String) chatGUI.fontColorComboBox.getSelectedItem();
        String selectedSize = (String) chatGUI.fontSizeComboBox.getSelectedItem();

        // styleCss
        String styleCss = "";
        if (selectedStyle != null) {
            switch (selectedStyle) {
                case "普通":
                    styleCss = "font-style: normal;";
                    break;
                case "倾斜":
                    styleCss = "font-style: italic;";
                    break;
                case "加粗":
                    styleCss = "font-weight: bold;";
                    break;
            }
        }
        // colorCss
        String colorCss = "";
        if (selectedColor != null) {
            switch (selectedColor) {
                case "黑色":
                    colorCss = "color: black;";
                    break;
                case "红色":
                    colorCss = "color: red;";
                    break;
                case "蓝色":
                    colorCss = "color: blue;";
                    break;
                case "绿色":
                    colorCss = "color: green;";
                    break;
            }
        }
        // sizeCss
        String sizeCss = "";
        if (selectedSize != null) {
            switch (selectedSize) {
                case "大":
                    sizeCss = "font-size: 20px;";
                    break;
                case "中":
                    sizeCss = "font-size: 16px;";
                    break;
                case "小":
                    sizeCss = "font-size: 12px;";
                    break;
            }
        }

        // 获取用户名
        String username = ClientRope.username;

        // 拼接
        return "<font style=\"" + styleCss + colorCss + sizeCss + "\">" + username + "：" + chatText + "</font><br>";
    }

    private String formatTextBySystemInformToHtml(String rawText) {
        return "<font style=\"color: red; font-size: 18px;\">" + rawText + "</font><br>";
    }

}
