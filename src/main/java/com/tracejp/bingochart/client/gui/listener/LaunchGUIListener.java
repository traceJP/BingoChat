package src.main.java.com.tracejp.bingochart.client.gui.listener;

import src.main.java.com.tracejp.bingochart.client.ClientConnector;
import src.main.java.com.tracejp.bingochart.client.ClientGUI;
import src.main.java.com.tracejp.bingochart.client.ClientRope;
import src.main.java.com.tracejp.bingochart.client.gui.LaunchGUI;
import src.main.java.com.tracejp.bingochart.common.constant.AddressConstant;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/16 11:14
 */
public class LaunchGUIListener {

    private final LaunchGUI launchGUI;

    public LaunchGUIListener(LaunchGUI launchGUI) {
        this.launchGUI = launchGUI;
    }


    public void initAllListener() {
        launchGUI.launchButton.addActionListener(e -> new Thread(launchButtonAction()).start());

        // TODO 监听三个文本框的变化，为 Rope username 赋值
        launchGUI.usernameTextField.getDocument().addDocumentListener(usernameTextFieldAction());
    }


    private Runnable launchButtonAction() {
        return () -> {
            // 与服务器建立连接
            String host = "";
            String port = "";
            // TODO 查看是否使用默认地址
            try {
                ClientRope.serverConnector = new ClientConnector(
                        AddressConstant.SERVER_ADDRESS_DEFAULT,
                        AddressConstant.SERVER_PORT_DEFAULT
                );
            } catch (Exception exception) {  // 连接建立失败
                // TODO 弹出窗口提示连接失败
            }

            // 打开聊天页面
            ClientGUI.openChatPage();
        };
    }

    private DocumentListener usernameTextFieldAction() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println(launchGUI.usernameTextField.getText());
            }
        };
    }


}
