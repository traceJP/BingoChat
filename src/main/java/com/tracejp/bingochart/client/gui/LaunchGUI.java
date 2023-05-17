package src.main.java.com.tracejp.bingochart.client.gui;

import src.main.java.com.tracejp.bingochart.common.utils.UUIDUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/16 9:30
 */
public class LaunchGUI extends JPanel {

    private final static String DEFAULT_USERNAME = "冰菓#";

    public JTextField usernameTextField;
    public JButton launchButton;
    public JTextField hostTextField;
    public JTextField portTextField;


    public void initLaunchGUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(initTitlePanel());
        add(initConfirmPanel());
        add(initProxyPanel());
    }
    private JPanel initTitlePanel() {
        JPanel main = new JPanel();
        main.setLayout(new FlowLayout(FlowLayout.CENTER));

        // title
        JLabel label = new JLabel("Bingo Chat") {
            @Override
            protected void paintComponent(Graphics g) {  // 随机颜色
                String text = getText();
                Random random = new Random();
                int x = 0;  // 字符间距
                for (int i = 0; i < text.length(); i++) {
                    char c = text.charAt(i);
                    Color color = new Color(
                            random.nextInt(256),
                            random.nextInt(256),
                            random.nextInt(256)
                    );
                    g.setColor(color);
                    g.drawString(String.valueOf(c), x, 50);  // y = font size
                    x += 30;
                }
            }
        };
        label.setFont(new Font("宋体", Font.BOLD, 50));
        label.setPreferredSize(new Dimension(300, 60));
        main.add(label);
        return main;
    }

    private JPanel initConfirmPanel() {
        JPanel main = new JPanel();
        main.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel usernameLabel = new JLabel("用户名");
        usernameLabel.setFont(new Font("宋体", Font.PLAIN, 20));

        usernameTextField = new JTextField(DEFAULT_USERNAME + UUIDUtils.generateRandomNumber(4));
        usernameTextField.setPreferredSize(new Dimension(200, 28));
        usernameTextField.setHorizontalAlignment(JTextField.CENTER);
        launchButton = new JButton("加入聊天室");

        main.add(usernameLabel);
        main.add(usernameTextField);
        main.add(launchButton);

        return main;
    }

    private JPanel initProxyPanel() {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        JLabel proxyLabel = new JLabel("代理设置（host-port）：");
        proxyLabel.setFont(new Font("宋体", Font.PLAIN, 15));
        main.add(proxyLabel);

        JPanel inputPanel = new JPanel();

        hostTextField = new JTextField();
        hostTextField.setPreferredSize(new Dimension(150, 25));
        hostTextField.setHorizontalAlignment(JTextField.CENTER);

        portTextField = new JTextField();
        portTextField.setPreferredSize(new Dimension(60, 25));
        portTextField.setHorizontalAlignment(JTextField.CENTER);

        inputPanel.add(hostTextField);
        inputPanel.add(portTextField);
        inputPanel.setPreferredSize(new Dimension(0, 50));
        main.add(inputPanel);

        return main;
    }

}
