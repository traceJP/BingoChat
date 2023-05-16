package src.main.java.com.tracejp.bingochart.client;

import src.main.java.com.tracejp.bingochart.client.gui.ChatGUI;
import src.main.java.com.tracejp.bingochart.client.gui.LaunchGUI;
import src.main.java.com.tracejp.bingochart.client.gui.listener.ChatGUIListener;
import src.main.java.com.tracejp.bingochart.client.gui.listener.LaunchGUIListener;

import javax.swing.*;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/7 21:08
 */
public class ClientGUI implements Runnable {

    public static final String TITLE = "BingoChat（Client α1.0）";

    public static JFrame clientGUI;

    @Override
    public void run() {
        clientGUI = new JFrame(TITLE);
        clientGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientGUI.setResizable(false);
        clientGUI.setLocationRelativeTo(null);
        clientGUI.setVisible(true);
        openLaunchPage();
    }

    public static void openChatPage() {
        // 初始化聊天页面 & 监听器
        ChatGUI chatGUI = new ChatGUI();
        chatGUI.initChatGUI();
        ChatGUIListener chatGUIListener = new ChatGUIListener(chatGUI);
        chatGUIListener.initAllListener();
        chatGUIListener.initAllResource();
        clientGUI.setContentPane(chatGUI);
        clientGUI.setSize(1000, 600);
        ClientRope.chatGUI = chatGUI;
    }

    public static void openLaunchPage() {
        // 初始化启动页面 & 监听器
        LaunchGUI launchGUI = new LaunchGUI();
        launchGUI.initLaunchGUI();
        LaunchGUIListener launchGUIListener = new LaunchGUIListener(launchGUI);
        launchGUIListener.initAllListener();
        clientGUI.setContentPane(launchGUI);
        clientGUI.setSize(500, 300);
        ClientRope.launchGUI = launchGUI;

    }

}
