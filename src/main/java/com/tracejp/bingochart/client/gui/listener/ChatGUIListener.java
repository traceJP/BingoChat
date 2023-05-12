package src.main.java.com.tracejp.bingochart.client.gui.listener;

import src.main.java.com.tracejp.bingochart.client.gui.ChatGUI;

import java.awt.event.ActionListener;
import java.util.function.Consumer;

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

    private Runnable sendButtonAction() {
        return () -> {

        };
    }

}
