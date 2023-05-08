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

    public static final Integer WINDOW_WIDTH = 1200;

    public static final Integer WINDOW_HEIGHT = 600;


    @Override
    public void run() {
        JFrame frame = new JFrame(TITLE);
        frame.setContentPane(new ChatGUI().chatPage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
