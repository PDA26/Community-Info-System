package ui.Community;

import model.CommunityModel;
import model.CommunityOrderCatalog;
import model.OrderCatalog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class communityAllOrders {

    /**
     * Define Components
     */

    private JPanel topJPanel;
    private JPanel middleJPanel;
    private JPanel bottomJPanel;
    private JPanel JPanelContent;
    JFrame jFrame = new JFrame();

    JLabel titleJLabel = new JLabel("View All Past Orders");
    JLabel titleCumName = new JLabel("Community Name:");
    JLabel show = new JLabel();
    JButton btnBack = new JButton("Back To Community Management");

    Vector<String> titleOrders;
    Vector<Vector<CommunityOrderCatalog>> dataOrders;
    DefaultTableModel tableModelOrders;

    JTable tableOrders;

    public communityAllOrders() {
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

    CommunityOrderCatalog communityOrderCatalog = new CommunityOrderCatalog();
    OrderCatalog orderCatalog = new OrderCatalog();

    private void InitData() {
        titleOrders = new Vector<>();
        titleOrders.add("Order ID");
        titleOrders.add("Order Date");
        titleOrders.add("Order Status");

        dataOrders = new Vector<>();
        dataOrders.addElement(orderCatalog.getOrders());

        tableModelOrders = new DefaultTableModel(dataOrders, titleOrders);

    }

    CommunityModel communityModel = new CommunityModel();
    private void InitView() {

        String currentName = communityModel.getCurrentCommunity().getCommunityName();
        show.setText(currentName);

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
        aptNoJPanel.add(titleCumName);
        aptNoJPanel.add(Box.createHorizontalStrut(5));
        aptNoJPanel.add(show);
        aptNoJPanel.add(Box.createHorizontalGlue());

        tableOrders = new JTable(tableModelOrders);
        tableOrders.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPaneMenu = new JScrollPane(tableOrders);
        scrollPaneMenu.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        middleJPanel.add(Box.createHorizontalStrut(10));
        middleJPanel.add(aptNoJPanel);
        middleJPanel.add(Box.createHorizontalStrut(10));
        middleJPanel.add(scrollPaneMenu);
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

    public Frame getFrame() {
        return jFrame;
    }

    public static void main(String[] args) {
        new communityAllOrders();
    }




}
