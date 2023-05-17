package src.main.java.com.tracejp.bingochart.client.gui.listener;

import src.main.java.com.tracejp.bingochart.client.ClientConnector;
import src.main.java.com.tracejp.bingochart.client.ClientGUI;
import src.main.java.com.tracejp.bingochart.client.ClientRope;
import src.main.java.com.tracejp.bingochart.client.gui.LaunchGUI;
import src.main.java.com.tracejp.bingochart.common.constant.AddressConstant;
import src.main.java.com.tracejp.bingochart.common.utils.StringUtils;

import javax.swing.*;

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
    }

    private Runnable launchButtonAction() {
        return () -> {
            // check host
            String host = launchGUI.hostTextField.getText();
            if (StringUtils.isEmpty(host)) {
                host = AddressConstant.SERVER_ADDRESS_DEFAULT;
            }

            // check port
            int port = AddressConstant.SERVER_PORT_DEFAULT;
            try {
                String portText = launchGUI.portTextField.getText();
                if (!StringUtils.isEmpty(portText)) {
                    port = Integer.parseInt(portText);
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(launchGUI, "端口号必须为数字", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // check username
            final String username = launchGUI.usernameTextField.getText();
            if (StringUtils.isEmpty(username)) {
                JOptionPane.showMessageDialog(launchGUI, "用户名不能为空", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 与服务器建立连接
            try {
                ClientRope.serverConnector = new ClientConnector(host, port);
            } catch (Exception exception) {  // 连接建立失败
                JOptionPane.showMessageDialog(launchGUI, "连接服务器失败", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 连接成功 初始化用户名
            ClientRope.username = username;

            // 打开聊天页面
            ClientGUI.openChatPage();
        };
    }

}
