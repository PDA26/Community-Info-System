package ui.Community;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class communityOrder {

    /**
     * Define Components
     */

    private JPanel topJPanel;
    private JPanel middleJPanel;
    private JPanel bottomJPanel;
    private JPanel JPanelContent;
    JFrame jFrame = new JFrame();

    JLabel titleJLabel = new JLabel("View Order Details");
    JLabel titleAptNo = new JLabel("Apt No. :");
    JLabel showAptNo = new JLabel("160 Pleasant");
    JButton btnBack = new JButton("Back To Community Management");

    String[] columnNames = { "title", "Price", "Item Status", "Quantity" };
    Object[][] rowData = { {"t1", "p1", "in stock", "20"},
                           {"t2", "p2", "out of stock", "40"},
                           {"t3", "p3", "in stock", "120"} };

    JTable orderTable = new JTable(rowData, columnNames);
    JScrollPane orderTablePane = new JScrollPane(orderTable);

    public communityOrder() {
        setStyle();
        InitData();
        InitView();

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                JPanelContent.add("CommunityManagement", new ui.Community.communityManagement().getFrame());
                ((CardLayout) JPanelContent.getLayout()).show(JPanelContent, "CommunityManagement");
//                jFrame.setVisible(false);
            }
        });
    }

    private void InitData() {
    }

    private void InitView() {
        CreateTopJPanel();
        CreateMiddleJPanel();
        CreateBottomJPanel();

        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new GridBagLayout());

        GridBagConstraints constraintsForTop = new GridBagConstraints();
        constraintsForTop.gridx = 0;
        constraintsForTop.gridy = 0;
        constraintsForTop.weightx = 1;
        constraintsForTop.weighty = 0;
        constraintsForTop.fill = GridBagConstraints.CENTER;
        panelContainer.add(topJPanel, constraintsForTop);

        GridBagConstraints constraintsForMiddle = new GridBagConstraints();
        constraintsForMiddle.gridx = 0;
        constraintsForMiddle.gridy = 1;
        constraintsForMiddle.weightx = 0;
        constraintsForMiddle.weighty = 0;
        constraintsForMiddle.fill = GridBagConstraints.CENTER;
        panelContainer.add(middleJPanel, constraintsForMiddle);

        GridBagConstraints constraintsForBottom = new GridBagConstraints();
        constraintsForBottom.gridx = 0;
        constraintsForBottom.gridy = 2;
        constraintsForBottom.weightx = 1;
        constraintsForBottom.weighty = 0;
        constraintsForBottom.fill = GridBagConstraints.HORIZONTAL;
        panelContainer.add(bottomJPanel, constraintsForBottom);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelContainer.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelContainer);
    }

    private void setStyle() {
        Font font_title = new Font(Font.SERIF, Font.PLAIN, 24);
        titleJLabel.setFont(font_title);
    }

    private void CreateTopJPanel() {
        topJPanel = new JPanel();
        topJPanel.setLayout(new BoxLayout(topJPanel, BoxLayout.Y_AXIS));

        topJPanel.add(Box.createVerticalStrut(10));
        topJPanel.add(titleJLabel);
        topJPanel.add(Box.createVerticalStrut(30));
    }

    private void CreateMiddleJPanel() {
        middleJPanel = new JPanel();
        middleJPanel.setLayout(new BoxLayout(middleJPanel, BoxLayout.Y_AXIS));

        JPanel aptNoJPanel = new JPanel();
        aptNoJPanel.setLayout(new BoxLayout(aptNoJPanel, BoxLayout.X_AXIS));
        aptNoJPanel.add(titleAptNo);
        aptNoJPanel.add(Box.createHorizontalStrut(5));
        aptNoJPanel.add(showAptNo);
        aptNoJPanel.add(Box.createHorizontalGlue());

        middleJPanel.add(Box.createHorizontalStrut(10));
        middleJPanel.add(aptNoJPanel);
        middleJPanel.add(Box.createHorizontalStrut(10));
        middleJPanel.add(orderTablePane);

    }

    private void CreateBottomJPanel() {
        bottomJPanel = new JPanel();
        bottomJPanel.setLayout(new BoxLayout(bottomJPanel, BoxLayout.Y_AXIS));

        JPanel blankJPanel = new JPanel();
        blankJPanel.add(Box.createVerticalStrut(20));

        JPanel contentJPanel = new JPanel();
        contentJPanel.setLayout(new BoxLayout(contentJPanel, BoxLayout.X_AXIS));
        contentJPanel.add(Box.createHorizontalGlue());
        contentJPanel.add(btnBack);
        contentJPanel.add(Box.createHorizontalStrut(50));

        bottomJPanel.add(blankJPanel);
        bottomJPanel.add(contentJPanel);
    }

    public JFrame getFrame() {
        return jFrame;
    }

    public static void main(String[] args) {
        new communityOrder();
    }




}
