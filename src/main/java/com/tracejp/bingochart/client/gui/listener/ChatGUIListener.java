package src.main.java.com.tracejp.bingochart.client.gui.listener;

import src.main.java.com.tracejp.bingochart.client.ClientRope;
import src.main.java.com.tracejp.bingochart.client.gui.ChatGUI;
import src.main.java.com.tracejp.bingochart.common.domain.Message;
import src.main.java.com.tracejp.bingochart.common.domain.RequestMapping;
import src.main.java.com.tracejp.bingochart.common.utils.UUIDUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/11 23:33
 */
public class ChatGUIListener {

    private final ChatGUI chatGUI;

    public ChatGUIListener(ChatGUI chatGUI) {
        this.chatGUI = chatGUI;
    }

    public void initAllListener() {
        chatGUI.sendButton.addActionListener(e -> new Thread(sendButtonAction()).start());
//        chatGUI.refreshButton.addActionListener(e -> new Thread(refreshButtonAction()).start());
//        chatGUI.exitButton.addActionListener(e -> new Thread(exitButtonAction()).start());
//        chatGUI.saveFontConfigCheckBox.addActionListener(e -> new Thread(saveFontConfigCheckBoxAction()).start());
//        chatGUI.fontSizeComboBox.addActionListener(e -> new Thread(fontSizeComboBoxAction()).start());
//        chatGUI.fontStyleComboBox.addActionListener(e -> new Thread(fontStyleComboBoxAction()).start());
//        chatGUI.fontColorComboBox.addActionListener(e -> new Thread(fontColorComboBoxAction()).start());
//        chatGUI.logRowsComboBox.addActionListener(e -> new Thread(logRowsComboBoxAction()).start());
//        chatGUI.reloadTimeComboBox.addActionListener(e -> new Thread(reloadTimeComboBoxAction()).start());
    }

    // =================================== Action ===================================

    private Runnable sendButtonAction() {
        return () -> {

            String rawText = chatGUI.chatInputTextField.getText();


            Map<String, Object> requestParams = new HashMap<>();
            requestParams.put("uuid", ClientRope.getUserUUID());
            requestParams.put("message", rawText);
            Message message = new Message(UUIDUtils.getUUID(), RequestMapping.SEND_MESSAGE, requestParams);
            ClientRope.serverConnector.sendMessage(message);
        };
    }

}
