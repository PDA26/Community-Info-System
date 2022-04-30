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
//        String[] titleOrders = {"AptNo", "ID", "Date", "Name", "Quantity", "Unit Price", "Total Price", "Status"};
//        String[][] dataOrders = curr_community.getOrders().getFull();
//        tableOrders = new JTable(dataOrders, titleOrders);

        String currentName = communityModel.getCurrentAptNo();
        labelName.setText(currentName);

        btnBack.addActionListener(e -> Main.gotoPanel("CommunityManagement"));

    }

    public JPanel getPanel() {
        return panelCommunityOrders;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        CommunityModel communityModel = CommunityModel.getInstance();

        String currCommunityName = communityModel.getCurrentCommunity().getCommunityName();
        CommunityInfo communityInfo = communityModel.getCommunityInfoHashMap().get(currCommunityName);
        CommunityOrderCatalog coc = communityInfo.getOrders();

//        SuperMarket market = SuperMarket.getInstance();
//        OrderCenter oc = market.getOc();
//        CommunityOrderCatalog coc = oc.getMap().get(currCommunityName);

        String[] titleOrders = {"AptNo", "ID", "Date", "Name", "Quantity", "Unit Price", "Status"};
//        String[][] dataOrders = new String[10][];

//        AptOrderCatalog aptOrderCatalog = coc.getMap().get(currCommunityName);

        if (coc!=null) {
//            List<Order> list = aptOrderCatalog.getList();
//            String[][] dataOrders = new String[list.size()][];
//            int i = 0;
//            for (Order order : list) {
//                dataOrders[i][0] = String.valueOf(order.getId());
//                dataOrders[i][1] = String.valueOf(order.getDate());
//                dataOrders[i][2] = String.valueOf(order.getStatus());
//                i += 1;
//            }
            String[][] dataOrders = coc.getFull();

            tableOrders = new JTable(dataOrders, titleOrders);
        } else {
            JOptionPane.showMessageDialog(this.panelCommunityOrders, "null!");
        }


    }
}
