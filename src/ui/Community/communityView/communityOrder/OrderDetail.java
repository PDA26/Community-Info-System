package ui.Community.communityView.communityOrder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Apartment;
import model.CommunityData.CommunityModel;
import model.OrderData.AptOrderCatalog;
import ui.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class OrderDetail {


    private JPanel panelOrderDetails;
    private JButton btnBack;
    private JTable tableOrder;
    private JLabel labelName;

//    private String key;
    private CommunityModel communityModel = CommunityModel.getInstance();

    private AptOrderCatalog curr_aptOrderCatalog = new AptOrderCatalog();

    public OrderDetail() {

        //generate Table
//        communityModel = CommunityModel.getInstance();
        String key = communityModel.getCurrentAptNo();
//        AptOrderCatalog curr_aptOrderCatalog = communityModel.getCommunityByKey(key).getOrders().getByAptNo(key);

        /**
         * 这里怎么获取当前的 curr_aptOrderCatalog 方法是有问题的
         */
//        curr_aptOrderCatalog = communityModel.getCommunityByKey(key).getOrders().getByAptNo(key);

        String[] titleOrder = {"ID", "Date", "Name", "Quantity", "Unit Price", "Total Price", "Status"};
        String[][] curr_list = curr_aptOrderCatalog.getAllOrderDetails();

        //tableModelOrder = new DefaultTableModel(curr_list, titleOrder);
        tableOrder = new JTable(curr_list, titleOrder);

        Apartment apartment = new Apartment();
        String apt = apartment.getAptNo();
        labelName.setText(apt);

        btnBack.addActionListener(e -> Main.gotoPanel("CommunityManagement"));

    }



    public JPanel getPanel() {
        return panelOrderDetails;
    }

}
