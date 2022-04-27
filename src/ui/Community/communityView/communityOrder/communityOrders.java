package ui.Community.communityView.communityOrder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.CommunityData.CommunityModel;
import model.CommunityData.CommunityOrderCatalog;
import model.SuperMarket.orderCenter.OrderCatalog;
import model.OrderData.AptOrderCatalog;
import ui.Community.communityView.communityManagement.communityManagement;
import ui.Community.mainJPanel.communityMain;
import ui.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class communityOrders {


    private JPanel panelCommunityOrders;
    private JButton btnBack;
    private JTable tableOrders;
    private JLabel labelName;


    public communityOrders() {

        // panelCommunityOrders.setOpaque(true);

        Vector<String> titleOrders;
        Vector<Vector<CommunityOrderCatalog>> dataOrders;
        DefaultTableModel tableModelOrders;

        CommunityOrderCatalog communityOrderCatalog = new CommunityOrderCatalog();
        // AptOrderCatalog aptOrderCatalog = new AptOrderCatalog();
        OrderCatalog orderCatalog = new OrderCatalog();

        titleOrders = new Vector<>();
        titleOrders.add("Order ID");
        titleOrders.add("Order Date");
        titleOrders.add("Order Status");

        dataOrders = new Vector<>();
        //dataOrders.addElement(communityOrderCatalog.getCommunityOrderCatalogMap().values());  //这一块的数据类型我实在是太搞不定了....需要帮助

        tableModelOrders = new DefaultTableModel(dataOrders, titleOrders);
        tableOrders = new JTable(dataOrders, titleOrders);

        CommunityModel communityModel = new CommunityModel();
        String currentName = communityModel.getCurrentCommunity().getCommunityName();
        labelName.setText(currentName);

        btnBack.addActionListener(e -> Main.gotoPanel("communityManagement"));

    }

    public JPanel getPanel() {
        return panelCommunityOrders;
    }

}
