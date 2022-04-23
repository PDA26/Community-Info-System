package ui.Community;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class residentManagement {

    /**
     * Define Components
     */

    private JPanel topJPanel;
    private JPanel middleJPanel;
    private JPanel bottomJPanel;
    private JPanel JPanelContent;
    JFrame jFrame = new JFrame();

    JLabel titleJLabel = new JLabel("Welcome Residents! Please add your items into cart!");
    JLabel titleCart = new JLabel("My Cart:");
    JLabel comName = new JLabel("Apt No. :");
    JTextField aptNo = new JTextField();
    JButton btnBack = new JButton("Back to Community");
    JButton btnCart = new JButton("Add to Cart");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnConfirm = new JButton("Confirm");

    String[] columnNamesTb1 = { "Title", "Price", "Item Status", "Quantity" };
    Object[][] rowDataTb1 = { {"t1", "p1", "in stock", "20"},
                              {"t2", "p2", "out of stock", "40"},
                              {"t3", "p3", "in stock", "120"} };

    JTable orderTable1 = new JTable(rowDataTb1, columnNamesTb1);
    JScrollPane orderTablePane1 = new JScrollPane(orderTable1);

    String[] columnNamesTb2 = { "Title2", "Price2", "Item Status2", "Quantity2" };
    Object[][] rowDataTb2 = { {"t1", "p1", "in stock", "20"},
                              {"t2", "p2", "out of stock", "40"},
                              {"t3", "p3", "in stock", "120"} };

    JTable orderTable2 = new JTable(rowDataTb2, columnNamesTb2);
    JScrollPane orderTablePane2 = new JScrollPane(orderTable2);


    public residentManagement() {
        setStyle();
        InitData();
        InitView();

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                JPanelContent.add("CommunityMain", new ui.Community.communityMain().getFrame());
                ((CardLayout) JPanelContent.getLayout()).show(JPanelContent, "CommunityMain");
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
        constraintsForBottom.fill = GridBagConstraints.CENTER;
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

        JPanel topBackJPanel = new JPanel();
        topBackJPanel.setLayout(new BoxLayout(topBackJPanel, BoxLayout.X_AXIS));
        topBackJPanel.add(btnBack);
        topBackJPanel.add(Box.createHorizontalGlue());

        topJPanel.add(topBackJPanel);
        topJPanel.add(Box.createVerticalStrut(10));
        topJPanel.add(titleJLabel);
    }

    private void CreateMiddleJPanel() {
        middleJPanel = new JPanel();
        middleJPanel.setLayout(new BoxLayout(middleJPanel, BoxLayout.Y_AXIS));

        JPanel barJPanel = new JPanel();
        barJPanel.setLayout(new BoxLayout(barJPanel, BoxLayout.X_AXIS));
        barJPanel.add(comName);
        barJPanel.add(aptNo);
        barJPanel.add(Box.createHorizontalStrut(20));
        barJPanel.add(btnCart);

        middleJPanel.add(Box.createVerticalStrut(20));
        middleJPanel.add(orderTable1.getTableHeader(), BorderLayout.NORTH);
        middleJPanel.add(orderTable1, BorderLayout.CENTER);
        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(barJPanel);

    }

    private void CreateBottomJPanel() {
        bottomJPanel = new JPanel();
        bottomJPanel.setLayout(new BoxLayout(bottomJPanel, BoxLayout.Y_AXIS));

        JPanel cartJPanel = new JPanel();
        cartJPanel.setLayout(new BoxLayout(cartJPanel, BoxLayout.X_AXIS));
        cartJPanel.add(titleCart);
        cartJPanel.add(Box.createHorizontalGlue());

        JPanel btnJPanel = new JPanel(new GridLayout(1, 3, 25, 50));
        btnJPanel.add(btnUpdate);
        btnJPanel.add(btnDelete);
        btnJPanel.add(btnConfirm);

        bottomJPanel.add(Box.createVerticalStrut(20));
        bottomJPanel.add(cartJPanel);
        bottomJPanel.add(orderTable2.getTableHeader(), BorderLayout.NORTH);
        bottomJPanel.add(orderTable2, BorderLayout.CENTER);
        bottomJPanel.add(Box.createVerticalStrut(10));
        bottomJPanel.add(btnJPanel);
    }

    public Frame getFrame() {
        return jFrame;
    }

    public static void main(String[] args) {
        new residentManagement();
    }
}
