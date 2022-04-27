package ui.Community.communityView.communityOrder;

import javax.swing.*;
import ui.Community.communityView.communityManagement.communityManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class orderDetail {


    private JPanel panelOrderDetails;
    private JButton btnBack;
    private JTable tableOrder;
    private JLabel labelName;

    JFrame jFrame = new JFrame();

    public orderDetail() {

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelOrderDetails.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelOrderDetails);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component communityManagement = panelOrderDetails.add("communityManagement", new communityManagement().getFrame());
                ((CardLayout) panelOrderDetails.getLayout()).show(panelOrderDetails, "communityManagement");
            }
        });

    }

    public Frame getFrame() {
        return jFrame;
    }



    public static void main(String[] args) {
        new orderDetail();
    }




}
