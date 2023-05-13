package src.main.java.com.tracejp.bingochart.client.gui;

import src.main.java.com.tracejp.bingochart.common.utils.Singleton;

import javax.swing.*;
import java.awt.*;

/**
 * <p>  <p/>
 *
 * @author traceJP
 * @since 2023/5/9 8:55
 */
public class ChatGUI extends Singleton<ChatGUI> {

    /**
     * root
     */
    public JPanel chatPage;

    public JButton sendButton;
    public JButton refreshButton;
    public JButton exitButton;
    public JCheckBox saveFontConfigCheckBox;
    public JComboBox<String> fontSizeComboBox;
    public JComboBox<String> fontStyleComboBox;
    public JComboBox<String> fontColorComboBox;
    public JComboBox<String> logRowsComboBox;
    public JLabel onlineUserNumberLabel;
    public JTextPane chatLogTextArea;
    public JTextField chatInputTextField;


    public void initChatGUI() {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(initControllerPanel());
        main.add(initChatPanel());
        chatPage = main;
    }

    private JPanel initControllerPanel() {
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createEmptyBorder(10, 200, 0, 200));
        main.add(initTopControllerPanel());
        main.add(Box.createVerticalStrut(5));
        main.add(initBottomControllerPanel());
        return main;
    }

    private JPanel initChatPanel() {
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        main.add(initTopChatPanel(), BorderLayout.NORTH);
        main.add(initCenterChatPanel(), BorderLayout.CENTER);
        main.add(initBottomChatPanel(), BorderLayout.SOUTH);
        return main;
    }

    private JPanel initTopChatPanel() {
        JPanel main = new JPanel();
        main.setLayout(new FlowLayout(FlowLayout.LEFT));
        main.setBorder(BorderFactory.createEmptyBorder(10, 150, 10, 0));

        onlineUserNumberLabel = new JLabel("在线人数：0");
        main.add(onlineUserNumberLabel);

        return main;
    }

    private JPanel initCenterChatPanel() {
        // ======================================= 布局初始化 =======================================
        JPanel main = new JPanel(new GridLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // 左右边距
        final int marginSide = 30;

        chatLogTextArea = new JTextPane();
        chatLogTextArea.setFont(new Font("SimSun", Font.PLAIN, 28));
        chatLogTextArea.setMargin(new Insets(0, marginSide, 0, marginSide));
        chatLogTextArea.setEditable(false);
        chatLogTextArea.setContentType("text/html");

        JScrollPane scrollPane = new JScrollPane(chatLogTextArea);
        main.add(scrollPane, gbc);

        return main;
    }

    private JPanel initBottomChatPanel() {
        JPanel main = new JPanel(new GridLayout());
        main.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 50));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        chatInputTextField = new JTextField();
        chatInputTextField.setMargin(new Insets(5, 10, 5, 10));
        main.add(chatInputTextField, gbc);

        return main;
    }


    private JPanel initTopControllerPanel() {
        // ======================================= 布局初始化 =======================================
        JPanel main = new JPanel();
        JPanel firstLine = new JPanel();
        JPanel secondLine = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(10, 30, 10, 30)
        ));
        firstLine.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        secondLine.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        secondLine.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        // ======================================= 组件初始化 =======================================
        sendButton = new JButton("发言 · 刷新");
        refreshButton = new JButton("重置");
        exitButton = new JButton("返回");
        saveFontConfigCheckBox = new JCheckBox("保存文字设定");

        JLabel fontSizeLabel = new JLabel("文字大小");
        fontSizeComboBox = new JComboBox<>();
        fontSizeComboBox.addItem("大");
        fontSizeComboBox.addItem("中");
        fontSizeComboBox.addItem("小");

        JLabel fontStyleLabel = new JLabel("文字效果");
        fontStyleComboBox = new JComboBox<>();
        fontStyleComboBox.addItem("普通");
        fontStyleComboBox.addItem("倾斜");
        fontStyleComboBox.addItem("加粗");

        // ====================================== firstLine ======================================
        firstLine.add(sendButton);
        firstLine.add(refreshButton);
        firstLine.add(exitButton);
        firstLine.add(saveFontConfigCheckBox);
        main.add(firstLine);

        // ====================================== secondLine ======================================
        secondLine.add(fontSizeLabel);
        secondLine.add(fontSizeComboBox);
        secondLine.add(fontStyleLabel);
        secondLine.add(fontStyleComboBox);
        main.add(secondLine);

        return main;
    }

    private JPanel initBottomControllerPanel() {
        // ======================================= 布局初始化 =======================================
        JPanel main = new JPanel();
        main.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
        main.setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 30));

        // ======================================= 组件初始化 =======================================
        JLabel fontColorLabel = new JLabel("COLOR");
        fontColorComboBox = new JComboBox<>();
        fontColorComboBox.addItem("黑色");
        fontColorComboBox.addItem("红色");
        fontColorComboBox.addItem("蓝色");
        fontColorComboBox.addItem("绿色");

        JLabel logRowsLabel = new JLabel("LOG");
        logRowsComboBox = new JComboBox<>();
        logRowsComboBox.addItem("10");
        logRowsComboBox.addItem("50");
        logRowsComboBox.addItem("100");

        // ====================================== main ======================================
        main.add(fontColorLabel);
        main.add(fontColorComboBox);
        main.add(logRowsLabel);
        main.add(logRowsComboBox);

        return main;
    }

}
