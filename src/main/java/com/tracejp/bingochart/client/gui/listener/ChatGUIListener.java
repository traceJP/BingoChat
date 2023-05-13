package src.main.java.com.tracejp.bingochart.client.gui.listener;

import src.main.java.com.tracejp.bingochart.client.ClientRope;
import src.main.java.com.tracejp.bingochart.client.gui.ChatGUI;
import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.RequestMapping;
import src.main.java.com.tracejp.bingochart.common.utils.StringUtils;
import src.main.java.com.tracejp.bingochart.common.utils.UUIDUtils;

import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.html.HTMLDocument;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/11 23:33
 */
public class ChatGUIListener {

    private static final Integer MAX_CHAT_INPUT = 50;

    private static Integer currentLogRows = 0;


    private final ChatGUI chatGUI;

    public ChatGUIListener(ChatGUI chatGUI) {
        this.chatGUI = chatGUI;
    }

    public void initAllListener() {
        chatGUI.sendButton.addActionListener(e -> new Thread(sendButtonAction()).start());
        chatGUI.chatInputTextField.addKeyListener(chatInputTextFieldSpaceKeyListener());
        chatGUI.refreshButton.addActionListener(e -> new Thread(refreshButtonAction()).start());

//        chatGUI.exitButton.addActionListener(e -> new Thread(exitButtonAction()).start());

//        chatGUI.fontSizeComboBox.addActionListener(e -> new Thread(fontSizeComboBoxAction()).start());
//        chatGUI.fontStyleComboBox.addActionListener(e -> new Thread(fontStyleComboBoxAction()).start());
//        chatGUI.fontColorComboBox.addActionListener(e -> new Thread(fontColorComboBoxAction()).start());

//        chatGUI.logRowsComboBox.addActionListener(e -> new Thread(logRowsComboBoxAction()).start());
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

            // 发送 TODO 暂时不发送
//            Map<String, Object> requestParams = new HashMap<>();
//            requestParams.put("uuid", ClientRope.getUserUUID());
//            requestParams.put("message", rawText);
//            Message message = new Message(UUIDUtils.getUUID(), RequestMapping.SEND_MESSAGE, requestParams);
//            ClientRope.serverConnector.sendMessage(message);

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
            public void keyPressed(KeyEvent e) { }
            @Override
            public void keyReleased(KeyEvent e) { }
        };
    }

    private Runnable refreshButtonAction() {
        return () -> {
            // 清空输入面板
            chatGUI.chatInputTextField.setText("");
        };
    }


    /**
     * 包装文本为 HTML 格式
     * @param chatText 聊天文本
     * @return 包装后的 HTML 格式文本
     */
    public String formatTextToHtml(String chatText) {
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

}
