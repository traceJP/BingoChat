package src.main.java.com.tracejp.bingochart.client;

import src.main.java.com.tracejp.bingochart.client.gui.ChatGUI;
import src.main.java.com.tracejp.bingochart.client.gui.listener.ChatGUIListener;
import src.main.java.com.tracejp.bingochart.common.constant.AddressConstant;

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
        // 与服务器建立连接
        ClientRope.serverConnector = new ClientConnector(
                AddressConstant.SERVER_ADDRESS_DEFAULT,
                AddressConstant.SERVER_PORT_DEFAULT
        );

        // 初始化聊天页面
        ChatGUI chatGUI = new ChatGUI();
        chatGUI.initChatGUI();
        clientGUI.setContentPane(chatGUI.chatPage);
        clientGUI.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        ClientRope.chatGUI = chatGUI;
        ChatGUIListener chatGUIListener = new ChatGUIListener();
        chatGUIListener.initAllListener();
        chatGUIListener.initAllResource();
    }

}
