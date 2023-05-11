package src.main.java.com.tracejp.bingochart.client;

import src.main.java.com.tracejp.bingochart.client.gui.ChatGUI;

import javax.swing.*;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/7 21:08
 */
public class ClientGUI implements Runnable {

    public static final String TITLE = "BingoChat（Client α1.0）";

    public static final Integer WINDOW_WIDTH = 1000;

    public static final Integer WINDOW_HEIGHT = 600;

    public static JFrame clientGUI;

    @Override
    public void run() {
        clientGUI = new JFrame(TITLE);
        clientGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientGUI.setResizable(false);
        clientGUI.setLocationRelativeTo(null);
        clientGUI.setVisible(true);
        openChatPage();
    }

    private void openChatPage() {
        ChatGUI chatGUI = ChatGUI.getInstance(ChatGUI.class);
        chatGUI.initChatGUI();
        clientGUI.setContentPane(chatGUI.chatPage);
        clientGUI.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }

}
