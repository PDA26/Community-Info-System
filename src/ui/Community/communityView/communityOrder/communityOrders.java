package ui.Community.communityView.communityOrder;

import javax.swing.*;
import ui.Community.communityView.communityManagement.communityManagement;
import ui.Community.mainJPanel.communityMain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class communityOrders {


    private JPanel panelCommunityOrders;
    private JButton btnBack;
    private JTable tableOrders;
    private JLabel labelName;

    JFrame jFrame = new JFrame();

    public communityOrders() {

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelCommunityOrders.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelCommunityOrders);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component communityManagement = panelCommunityOrders.add("communityManagement", new communityManagement().getFrame());
                ((CardLayout) panelCommunityOrders.getLayout()).show(panelCommunityOrders, "communityManagement");
            }
        });

    }

    public Frame getFrame() {
        return jFrame;
    }



    public static void main(String[] args) {
        new communityOrders();
    }




}
