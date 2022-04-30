package ui.Community.residentView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import model.Apartment;
//import model.SuperMarket.orderCenter.OrderCatalog;
//import model.SuperMarket.orderCenter.OrderItem;
import model.CommunityData.CommunityInfo;
import model.CommunityData.CommunityModel;
import model.Product;
import model.SuperMarket.SuperMarket;
import model.SuperMarket.wareHouse.Warehouse;
import model.OrderData.Order;
import model.OrderData.AptOrderCatalog;
//import model.SuperMarket.orderCenter.ProductCatalog;
import model.OrderData.AptOrderCatalog;
import ui.Main;

public class ResidentManagement {


    private JPanel panelResidentManagement;
    private JButton btnBack;
    private JTable tableItem;
    private JTable tableCart;
    private JButton btnConfirm;
    private JButton btnDelete;
    private JTextField txtAptNo;
    private JButton btnAdd;
    private JSpinner spinnerCount;


    Order orders;
    AptOrderCatalog aptOrderCatalog;
    CommunityModel communityModel;
    CommunityInfo communityInfo;
    Order curr_order;
    int id = 0;

    public ResidentManagement() {

        this.communityModel = CommunityModel.getInstance();
        this.communityInfo = communityModel.getCurrentCommunity();
        this.curr_order = new Order(communityInfo.communityName);

        tableCart.setModel(curr_order);
        SuperMarket market = SuperMarket.getInstance();

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.gotoPanel("Community");
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String curr_aptNo = txtAptNo.getText();
                communityInfo.addApt(curr_aptNo);
                boolean tag = false;
                for(String name : communityInfo.getAptList()){
                    if(curr_aptNo.equals(name)){
                        tag = true;
                    }
                }
                if(!tag){
                    JOptionPane.showMessageDialog(panelResidentManagement, "Wrong input of aptNo!");
                    return;
                }

                int row = tableItem.getSelectedRow();
                if(row == -1){
                    JOptionPane.showMessageDialog(panelResidentManagement, "Please select a row!");
                    return;
                }
                Product curr_product = market.getWh().getClone(market.getWh().get(row));

                curr_order.addProduct(curr_product);

                JOptionPane.showMessageDialog(panelResidentManagement, "Successfully add to cart!");
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableCart.getSelectedRow();
                if(row != -1){
                    //curr_order.getItemList().remove(row);
                    curr_order.removeItem(row);
                    JOptionPane.showMessageDialog(panelResidentManagement, "Successfully deleted!");
                }else {
                    JOptionPane.showMessageDialog(panelResidentManagement, "Please select an item!");
                }
            }
        });

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String curr_aptNo = txtAptNo.getText();
                communityInfo.addApt(curr_aptNo);
                //pull curr_order to aptOrderCatalog
                AptOrderCatalog curr_aoc = communityInfo.getOrders().getByAptNo(curr_aptNo);

                if (curr_aptNo.isBlank()) {
                    JOptionPane.showMessageDialog(panelResidentManagement, "Miss AptNo! Cart Not Saved!");
                    return;
                }

                curr_aoc.addOrder(curr_order);
                //curr_order stored
                curr_order = new Order(communityInfo.communityName);
                JOptionPane.showMessageDialog(panelResidentManagement, "Cart saved!!");
                tableCart.setModel(curr_order);
            }
        });


        spinnerCount.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int row = tableCart.getSelectedRow();
                if(row != -1){
                    int cnt = (int)spinnerCount.getValue();
                    Product cc = market.getWh().getByName(curr_order.getItemList().get(row).getName());
                    if(cc != null){
                        cnt = Math.min(cnt, cc.getQuantity());
                    }
                    curr_order.updateItemCnt(row, cnt);
                }else {
                    JOptionPane.showMessageDialog(panelResidentManagement, "Please select an item!");
                }

            }
        });
    }

    public JPanel getPanel() {
        return panelResidentManagement;
    }

    private void createUIComponents() {
        SuperMarket market = SuperMarket.getInstance();
        tableItem = new JTable(market.getWh());
    }
}
