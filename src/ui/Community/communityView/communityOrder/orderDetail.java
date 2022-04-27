package ui.Community.communityView.communityOrder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Apartment;
import model.communityAndMarketDataTest.AptOrderCatalog;
import ui.Community.communityView.communityManagement.communityManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class orderDetail {


    private JPanel panelOrderDetails;
    private JButton btnBack;
    private JTable tableOrder;
    private JLabel labelName;

    JFrame jFrame = new JFrame();

    Vector<String> titleOrder;
    Vector<Vector<Apartment>> dataOrder;
    DefaultTableModel tableModelOrder;

    public orderDetail() {

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelOrderDetails.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelOrderDetails);

        AptOrderCatalog aptOrderCatalog = new AptOrderCatalog();

        titleOrder = new Vector<>();
        titleOrder.add("title");
        titleOrder.add("Price");
        titleOrder.add("Item Status");
        titleOrder.add("Quantity");

        dataOrder = new Vector<>();
        dataOrder.addElement(aptOrderCatalog.getCurrentApt());

        tableModelOrder = new DefaultTableModel(dataOrder, titleOrder);
        tableOrder = new JTable(dataOrder, titleOrder);

        Apartment apartment = new Apartment();
        String apt = apartment.getAptNo();
        labelName.setText(apt);

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
