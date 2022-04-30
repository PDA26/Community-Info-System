package ui.Community.communityView.communityManagement;

import model.Apartment;
import model.CommunityData.CommunityModel;
import model.CommunityData.CommunityInfo;
import model.CurrentApt;
import model.OrderData.AptOrderCatalog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import model.OrderData.CommunityOrderCatalog;
import model.OrderData.Order;
import model.OrderData.OrderCenter;
import model.Product;
import model.SuperMarket.SuperMarket;
import ui.Community.communityView.communityOrder.CommunityOrders;
import ui.Community.communityView.communityOrder.OrderDetail;
import ui.Community.mainJPanel.communityMain;
import ui.Main;

public class CommunityManagement {


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

//    CommunityModel communityModel;
    CommunityInfo currentCommunity;
    CommunityInfo communityInfo;
//    List<String> apts;
    AptOrderCatalog aptOrderCatalog;
    CommunityOrderCatalog communityOrderCatalog;

    private String aptNo;
    private List<Order> list;

    public CommunityManagement() {

        CommunityModel communityModel = CommunityModel.getInstance();

        String currentName = "";
        if (communityModel.getCurrentCommunity() != null)
            currentName = communityModel.getCurrentCommunity().getCommunityName();
        labelShowName.setText(currentName);

        currentCommunity = communityModel.getCurrentCommunity();

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.gotoPanel("Community");
            }
        });


        String finalCurrentName = currentName;
        btnViewDetails.addActionListener(e ->{
            //get AptNo
            int idx = tableApt.getSelectedRow();
            if(idx == -1){
                JOptionPane.showMessageDialog(panel, "You have to select a row!");
                return;
            }
            String key = (String)tableApt.getValueAt(idx, 0);
//            SuperMarket market = SuperMarket.getInstance();
//            OrderCenter oc = market.getOc();
//            CommunityOrderCatalog coc = oc.getMap().get(finalCurrentName);
//            AptOrderCatalog aoc = coc.getByAptNo(key);
////            communityModel.setCurrentAptNo(key);
            CurrentApt currentApt = CurrentApt.getInstance();
            currentApt.setCurrentApt(key);

            OrderDetail orderDetail = new OrderDetail();
            Main.addPanel(orderDetail.getPanel(), "orderDetail");
            Main.gotoPanel("orderDetail");
        });


        btnViewOrders.addActionListener(e -> {
            CommunityOrders communityOrders = new CommunityOrders();
            Main.addPanel(communityOrders.getPanel(), "orders");
            Main.gotoPanel("orders");
        });

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                refreshData();
//                AptOrderCatalog aptOrderCatalog = new AptOrderCatalog();
//                OrderCatalog orderCatalog = new OrderCatalog();
//                String Apt = apartment.getAptNo();
//                OrderCatalog.addOrder(Apt, OrderCatalog.getInstance().getCurrentOrder());
                //TODO change all orders in this community to 'ACCEPTED'
                CommunityOrderCatalog coc = currentCommunity.getOrders();
                for(String aptNo : coc.getMap().keySet()){
                    AptOrderCatalog tmp = coc.getMap().get(aptNo);
                    for(Order o : tmp.getList()){
                        o.setStatus(Order.OrderStatus.ACCEPTED);
                    }
                }

//                AptOrderCatalog aptOrderCatalog = new AptOrderCatalog();

                JOptionPane.showMessageDialog(panel, "Successfully confirmed!");
            }
        });

    }

    private void refreshData() {
        dataOrder.clear();  //在createUIComponents里面定义的变量 在这里能引用/修改吗
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        CommunityModel communityModel = CommunityModel.getInstance();
        this.communityInfo = communityModel.getCurrentCommunity();
        currentCommunity = communityModel.getCurrentCommunity();


        String[] titleOrder = {"AptNo", "OrderDate"};
        String[][] rowData = currentCommunity.getOrders().getDigest();

        tableApt = new JTable(rowData, titleOrder);
    }
}
