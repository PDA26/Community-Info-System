package ui.Community.communityView.communityOrder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.CommunityData.CommunityInfo;
import model.CommunityData.CommunityModel;
import model.CurrentApt;
import model.OrderData.AptOrderCatalog;
import model.OrderData.CommunityOrderCatalog;
import model.OrderData.Order;
import model.OrderData.OrderCenter;
import model.SuperMarket.SuperMarket;
import ui.Main;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;


public class CommunityOrders {


    private JPanel panelCommunityOrders;
    private JButton btnBack;
    private JTable tableOrders;
    private JLabel labelName;

    public CommunityOrders() {

        CommunityModel communityModel = CommunityModel.getInstance();
        CommunityInfo curr_community = communityModel.getCurrentCommunity();


        String currentName = communityModel.getCurrentAptNo();


        btnBack.addActionListener(e -> Main.gotoPanel("CommunityManagement"));

    }

    public JPanel getPanel() {
        return panelCommunityOrders;
    }

    private void createUIComponents() {

        CommunityModel communityModel = CommunityModel.getInstance();

        String currCommunityName = communityModel.getCurrentCommunity().getCommunityName();
        CommunityInfo communityInfo = communityModel.getCommunityInfoHashMap().get(currCommunityName);
        CommunityOrderCatalog coc = communityInfo.getOrders();



        String[] titleOrders = {"AptNo", "ID", "Date", "Name", "Quantity", "Unit Price", "Status"};


        if (coc!=null) {
            String[][] dataOrders = coc.getFull();

            tableOrders = new JTable(dataOrders, titleOrders);
        } else {
            JOptionPane.showMessageDialog(this.panelCommunityOrders, "null!");
        }


    }
}
