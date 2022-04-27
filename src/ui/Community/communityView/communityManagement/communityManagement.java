package ui.Community.communityView.communityManagement;

import model.CommunityData.CommunityModel;
import ui.Community.mainJPanel.communityMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.Community.communityView.communityOrder.communityOrders;
import ui.Community.communityView.communityOrder.orderDetail;

public class communityManagement extends JPanel {


    private JButton btnBack;
    private JTable tableApt;
    private JButton btnViewDetails;
    private JButton btnConfirm;
    private JButton btnViewOrders;
    private JPanel panelCommunityManagement;
    private JLabel labelShowName;

    JFrame jFrame = new JFrame();


    public communityManagement() {

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelCommunityManagement.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelCommunityManagement);

        CommunityModel communityModel = CommunityModel.getInstance();
        String currentName = communityModel.getCurrentCommunity().getCommunityName();
        labelShowName.setText(currentName);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component communityMain = panelCommunityManagement.add("communityMain", new communityMain().getFrame());
                ((CardLayout) panelCommunityManagement.getLayout()).show(panelCommunityManagement, "communityMain");
            }
        });

        btnViewDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component orderDetails = panelCommunityManagement.add("orderDetails", new orderDetail().getFrame());
                ((CardLayout) panelCommunityManagement.getLayout()).show(panelCommunityManagement, "orderDetails");
            }
        });

        btnViewOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component orders = panelCommunityManagement.add("orders", new communityOrders().getFrame());
                ((CardLayout) panelCommunityManagement.getLayout()).show(panelCommunityManagement, "orders");
            }
        });

    }

    public JPanel getPanel() {
        return panelCommunityManagement;
    }

    public JFrame getFrame() {
        return jFrame;
    }



    public static void main(String[] args) {
        new communityManagement();
    }
}
