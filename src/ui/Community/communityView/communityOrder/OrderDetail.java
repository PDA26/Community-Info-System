package ui.Community.communityView.communityOrder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Apartment;
import model.CommunityData.CommunityModel;
import model.CurrentApt;
import model.OrderData.AptOrderCatalog;
import model.OrderData.CommunityOrderCatalog;
import model.OrderData.OrderCenter;
import model.SuperMarket.SuperMarket;
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
//    private CommunityModel communityModel = CommunityModel.getInstance();
//    CommunityModel communityModel;

//    private AptOrderCatalog curr_aptOrderCatalog = new AptOrderCatalog();

    public OrderDetail() {

        //generate Table
        CommunityModel communityModel = CommunityModel.getInstance();

        String currCommunity = communityModel.getCurrentCommunity().getCommunityName();
        String currApt = CurrentApt.getInstance().getCurrentApt();

        SuperMarket market = SuperMarket.getInstance();
        OrderCenter oc = market.getOc();
        CommunityOrderCatalog coc = oc.getMap().get(currCommunity);
        AptOrderCatalog aoc = coc.getByAptNo(currApt);

        labelName.setText(currApt);

        btnBack.addActionListener(e -> Main.gotoPanel("CommunityManagement"));

    }

    public JPanel getPanel() {
        return panelOrderDetails;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        CommunityModel communityModel = CommunityModel.getInstance();

        String currCommunity = communityModel.getCurrentCommunity().getCommunityName();
        String currApt = CurrentApt.getInstance().getCurrentApt();

        SuperMarket market = SuperMarket.getInstance();
        OrderCenter oc = market.getOc();
        CommunityOrderCatalog coc = oc.getMap().get(currCommunity);
        AptOrderCatalog aoc = coc.getByAptNo(currApt);

        String[] titleOrder = {"ID", "Date", "Name", "Quantity", "Unit Price", "Status"};
        String[][] curr_list = aoc.getAllOrderDetails();

        //tableModelOrder = new DefaultTableModel(curr_list, titleOrder);
        tableOrder = new JTable(curr_list, titleOrder);
    }
}
