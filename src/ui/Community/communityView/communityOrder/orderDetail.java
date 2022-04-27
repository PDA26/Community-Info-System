package ui.Community.communityView.communityOrder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Apartment;
import model.OrderData.AptOrderCatalog;
import ui.Community.communityView.communityManagement.communityManagement;
import ui.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class orderDetail {


    private JPanel panelOrderDetails;
    private JButton btnBack;
    private JTable tableOrder;
    private JLabel labelName;


    Vector<String> titleOrder;
    Vector<Vector<Apartment>> dataOrder;
    DefaultTableModel tableModelOrder;

    public orderDetail() {

        // panelOrderDetails.setOpaque(true);

        // AptOrderCatalog aptOrderCatalog = new AptOrderCatalog();

        titleOrder = new Vector<>();
        titleOrder.add("title");
        titleOrder.add("Price");
        titleOrder.add("Item Status");
        titleOrder.add("Quantity");

        //dataOrder = new Vector<>();
        // dataOrder.addElement(aptOrderCatalog.getCurrentApt());

        tableModelOrder = new DefaultTableModel(dataOrder, titleOrder);
        tableOrder = new JTable(dataOrder, titleOrder);

        Apartment apartment = new Apartment();
        String apt = apartment.getAptNo();
        labelName.setText(apt);

        btnBack.addActionListener(e -> Main.gotoPanel("communityManagement"));

    }

    public JPanel getPanel() {
        return panelOrderDetails;
    }


}
