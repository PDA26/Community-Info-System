package ui.Community.communityView.communityManagement;

import model.Apartment;
import model.CommunityData.CommunityModel;
import model.CommunityInfo;
import model.SuperMarket.orderCenter.OrderCatalog;
import model.OrderData.AptOrderCatalog;
import ui.Community.mainJPanel.communityMain;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import ui.Community.communityView.communityOrder.communityOrders;
import ui.Community.communityView.communityOrder.orderDetail;
import ui.Main;

public class communityManagement {


    private JButton btnBack;
    private JTable tableApt;
    private JButton btnViewDetails;
    private JButton btnConfirm;
    private JButton btnViewOrders;
    private JPanel panel;
    private JLabel labelShowName;

    Apartment apartment = new Apartment();

    private List<String> titlesOrder;
    private List<Object> dataOrder;
    DefaultTableModel tableModelOrder;


    public communityManagement() {

        // panel.setOpaque(true);

        CommunityModel communityModel = CommunityModel.getInstance();
        String currentName = "";
        if (communityModel.getCurrentCommunity() != null)
            currentName = communityModel.getCurrentCommunity().getCommunityName();
        labelShowName.setText(currentName);

        CommunityInfo currentCommunity;
        currentCommunity = communityModel.getCurrentCommunity();

        this.titlesOrder = new ArrayList<>();
        this.dataOrder = new ArrayList<>();

        titlesOrder.add("Apt No.");
        titlesOrder.add("Order Time");
        String[] columnNames = {"Apt No.", "Order Time"};
        //TODO
        String apt = apartment.getAptNo();
        String time = apartment.getOrderTime();
        Object[][] rowData = {{apt}, {time}};
        tableModelOrder = new DefaultTableModel(rowData, columnNames);
        tableApt = new JTable(rowData, columnNames);

        btnBack.addActionListener(e -> Main.gotoPanel("communityMain"));

        Main.addPanel(new orderDetail().getPanel(), "orderDetails");
        btnViewDetails.addActionListener(e -> Main.gotoPanel("orderDetails"));

        Main.addPanel(new communityOrders().getPanel(), "orders");
        btnViewOrders.addActionListener(e -> Main.gotoPanel("orders"));

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshData();
                AptOrderCatalog aptOrderCatalog = new AptOrderCatalog();
                OrderCatalog orderCatalog = new OrderCatalog();
                String Apt = apartment.getAptNo();
                OrderCatalog.addOrder(Apt, OrderCatalog.getInstance().getCurrentOrder());
                JOptionPane.showMessageDialog(panel, "Successfully confirmed!");
            }
        });

    }

    private void refreshData() {
        dataOrder.clear();
    }

    public JPanel getPanel() {
        return panel;
    }

}
