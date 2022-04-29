package ui.Community.communityView.communityOrder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.CommunityData.CommunityInfo;
import model.CommunityData.CommunityModel;
import ui.Main;

import java.util.Vector;


public class CommunityOrders {


    private JPanel panelCommunityOrders;
    private JButton btnBack;
    private JTable tableOrders;
    private JLabel labelName;

    CommunityModel communityModel;
    public CommunityOrders() {
//        // panelCommunityOrders.setOpaque(true);
//
//        Vector<String> titleOrders;
//        Vector<Vector<CommunityOrderCatalog>> dataOrders;
//        DefaultTableModel tableModelOrders;
//
//        CommunityOrderCatalog communityOrderCatalog = new CommunityOrderCatalog();
//        // AptOrderCatalog aptOrderCatalog = new AptOrderCatalog();
//        OrderCatalog orderCatalog = new OrderCatalog();
        communityModel = CommunityModel.getInstance();
        CommunityInfo curr_community = communityModel.getCurrentCommunity();
        String[] titleOrders = {"AptNo", "ID", "Date", "Name", "Quantity", "Unit Price", "Total Price", "Status"};
        String[][] dataOrders = curr_community.getOrders().getFull();
        tableOrders = new JTable(dataOrders, titleOrders);

        String currentName = communityModel.getCurrentCommunity().getCommunityName();
        labelName.setText(currentName);

        btnBack.addActionListener(e -> Main.gotoPanel("CommunityManagement"));

    }

    public JPanel getPanel() {
        return panelCommunityOrders;
    }

}
