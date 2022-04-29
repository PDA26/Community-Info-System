package ui.Community.communityView.communityManagement;

import model.Apartment;
import model.CommunityData.CommunityModel;
import model.CommunityData.CommunityInfo;
import model.OrderData.AptOrderCatalog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.OrderData.CommunityOrderCatalog;
import model.OrderData.Order;
import ui.Community.communityView.communityOrder.CommunityOrders;
import ui.Community.communityView.communityOrder.OrderDetail;
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

    CommunityModel communityModel;
    CommunityInfo currentCommunity;

    public CommunityManagement() {


        this.communityModel = CommunityModel.getInstance();

        String currentName = "";
        if (communityModel.getCurrentCommunity() != null)
            currentName = communityModel.getCurrentCommunity().getCommunityName();
        labelShowName.setText(currentName);

        currentCommunity = communityModel.getCurrentCommunity();

        //this.titlesOrder = new ArrayList<>();
        //this.dataOrder = new ArrayList<>();

        //titlesOrder.add("Apt No.");
        //titlesOrder.add("Order Time");
        String[] columnNames = {"Apt No.", "Order Time"};

        //String apt = apartment.getAptNo();
        //String time = apartment.getOrderTime();
        String[][] rowData = currentCommunity.getOrders().getDigest();
        //tableModelOrder = new DefaultTableModel(rowData, columnNames);
        tableApt = new JTable(rowData, columnNames);

        btnBack.addActionListener(e -> Main.gotoPanel("communityMain"));

        OrderDetail orderDetail = new OrderDetail();
        Main.addPanel(orderDetail.getPanel(), "orderDetail");
        btnViewDetails.addActionListener(e ->{
            //get AptNo
            int idx = tableApt.getSelectedRow();
            if(idx == -1){
                JOptionPane.showMessageDialog(panel, "You have to select a row!");
                return;
            }
            String key = (String)tableApt.getValueAt(idx, 0);
            communityModel.setCurrentAptNo(key);
            Main.gotoPanel("orderDetail");
        });
        CommunityOrders communityOrders = new CommunityOrders();
        Main.addPanel(communityOrders.getPanel(), "orders");
        btnViewOrders.addActionListener(e -> {

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
