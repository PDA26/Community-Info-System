package ui.Community;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import model.*;

public class communityManagement extends JPanel {

    /**
     * Define Components
     */

    private JPanel topJPanel;
    private JPanel middleJPanel;
    private JPanel bottomJPanel;
    private JPanel JPanelContent;
    JFrame jFrame = new JFrame();

    JLabel titleJLabel = new JLabel("Residents` Unconfirmed Order in My Community");
    JLabel comName = new JLabel("Community Name:");
    JLabel showComName = new JLabel();
    JButton btnBack = new JButton("Back to Community");
    JButton btnConfirm = new JButton("Confirm");
    JButton btnViewDetail = new JButton("View Order Details");
    JButton btnViewOrders = new JButton("View All Orders");

    String[] columnNames = { "Apt No.", "Order Time" };
    Object[][] rowData = {};

    Vector<String> titlesOrder;
    Vector<Object> dataOrder;
    DefaultTableModel tableModelOrder;

    JTable tableOrder;

//    JTable orderTable1 = new JTable(rowData, columnNames);
//    JScrollPane orderTablePane = new JScrollPane(orderTable1);

    CommunityInfo currentCommunity;
    CommunityModel communityModel = CommunityModel.getInstance();


    
    public communityManagement() {
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

        btnViewDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                JPanelContent.add("CommunityOrder", new ui.Community.communityOrder().getFrame());
                ((CardLayout) JPanelContent.getLayout()).show(JPanelContent, "CommunityOrder");
            }
        });

        btnViewOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                JPanelContent.add("CommunityAllOrder", new ui.Community.communityAllOrders().getFrame());
                ((CardLayout) JPanelContent.getLayout()).show(JPanelContent, "CommunityAllOrder");
            }
        });

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshData();
                AptOrderCatalog aptOrderCatalog = new AptOrderCatalog();
                OrderCatalog orderCatalog = new OrderCatalog();
                String Apt = apartment.getAptNo();
                OrderCatalog.addOrder(Apt, OrderCatalog.getInstance().getCurrentOrder());
                JOptionPane.showMessageDialog(communityManagement.this, "Successfully confirmed!");
            }
        });
    }

    private void refreshData() {
        dataOrder.clear();
    }

    Apartment apartment = new Apartment();

    private void InitData() {
        currentCommunity = communityModel.getCurrentCommunity();
        titlesOrder.add("Apt No.");
        titlesOrder.add("Order Time");
        String[] columnNames = { "Apt No.", "Order Time" };
        List list = (List) AptOrderCatalog.getInstance().getApts();
//        Vector<Object> dataOrder = new Vector<>();
        dataOrder = new Vector<>();
        String apt = apartment.getAptNo();
        String time = apartment.getOrderTime();
        Object[][] rowData = { {apt}, {time} };
        tableModelOrder = new DefaultTableModel(rowData, columnNames);


//        String[] columnNames = { "Apt No.", "Order Time" };
//        Object[][] rowData = {};
//
//        Vector<String> titlesOrder;
//        Vector<Object> dataOrder;
//        DefaultTableModel tableModelOrder;
//
//        tableModelOrder = new DefaultTableModel(rowData, titlesOrder);


    }

    private void InitView() {
        String currentName = communityModel.getCurrentCommunity().getCommunityName();
        showComName.setText(currentName);

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

//        JFrame jFrame = new JFrame();
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
        middleJPanel.setLayout(new BoxLayout(middleJPanel, BoxLayout.X_AXIS));

        JPanel blankJPanel = new JPanel();
        blankJPanel.add(Box.createVerticalStrut(20));

        JPanel leftCumNameJPanel = new JPanel();
        leftCumNameJPanel.setLayout(new BoxLayout(leftCumNameJPanel, BoxLayout.X_AXIS));
        leftCumNameJPanel.add(comName);
        leftCumNameJPanel.add(Box.createHorizontalStrut(10));
        leftCumNameJPanel.add(showComName);
        leftCumNameJPanel.add(Box.createHorizontalStrut(10));

        JPanel leftBottom = new JPanel();
        JPanel contentJPanel = new JPanel();
        contentJPanel.setLayout(new BoxLayout(contentJPanel, BoxLayout.X_AXIS));
        contentJPanel.add(Box.createHorizontalGlue());
        contentJPanel.add(btnConfirm);
        contentJPanel.add(Box.createHorizontalStrut(30));
        leftBottom.add(blankJPanel);
        leftBottom.add(contentJPanel);

        tableOrder = new JTable(tableModelOrder);
        tableOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tableOrder);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel leftJPanel = new JPanel();
        leftJPanel.setLayout(new BoxLayout(leftJPanel, BoxLayout.Y_AXIS));
        leftJPanel.add(Box.createVerticalStrut(10));
        leftJPanel.add(leftCumNameJPanel);
        leftJPanel.add(Box.createVerticalStrut(10));
//        leftJPanel.add(orderTablePane);
        leftJPanel.add(scrollPane);
        leftJPanel.add(Box.createVerticalStrut(10));
        leftJPanel.add(leftBottom);
        leftJPanel.add(Box.createVerticalStrut(10));

        JPanel rightJPanel = new JPanel();
        rightJPanel.setLayout(new BoxLayout(rightJPanel, BoxLayout.Y_AXIS));
        rightJPanel.add(Box.createVerticalGlue());
        rightJPanel.add(btnViewDetail);
        rightJPanel.add(Box.createVerticalStrut(10));
        rightJPanel.add(btnViewOrders);
        rightJPanel.add(Box.createVerticalStrut(10));

        middleJPanel.add(leftJPanel);
        middleJPanel.add(rightJPanel);
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
        new communityManagement();
    }
}
