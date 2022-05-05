package ui.Community.communityView.communityOrder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.CommunityData.CommunityModel;
import ui.Main;

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

        btnBack.addActionListener(e -> Main.gotoPanel("CommunityManagement"));

    }

    public JPanel getPanel() {
        return panelCommunityOrders;
    }

}
