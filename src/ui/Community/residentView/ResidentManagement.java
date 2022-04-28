package ui.Community.residentView;

import javax.swing.*;
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


    Warehouse warehouse = new Warehouse();
    Order orders;
    AptOrderCatalog aptOrderCatalog;
    CommunityModel communityModel;
    CommunityInfo communityInfo;
    Order curr_order;
    int id = 0;

    public ResidentManagement() {

        this.curr_order = new Order();
        this.communityModel = CommunityModel.getInstance();
        this.communityInfo = communityModel.getCurrentCommunity();
        String[] titleCart = {"Item Name", "Price", "Manufacture Date", "Quantity", "Item Status"};
        String[][] dataCart = new String[5][];
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

                //TODO ADD ITEMS TO CART
                String curr_aptNo = txtAptNo.getText();
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

                //TODO update tableCart
                curr_order.addProduct(curr_product);

                JOptionPane.showMessageDialog(panelResidentManagement, "Successfully add to cart!");
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableCart.getSelectedRow();
                int len_col = tableCart.getColumnCount();
                int len_row = tableCart.getRowCount();

                if (row > 0) {
                    for (int i=0; i<len_row; i++) {

                        if (i==row) { i += 1; }
                        for (int j=0; j<len_col; j++) {
                            dataCart[i][j] = (String) tableItem.getValueAt(i, j);
                        }
                    }
                    dataCart[-1] = new String[]{};
                    tableCart = new JTable(dataCart, titleCart);
                    JOptionPane.showMessageDialog(panelResidentManagement, "Successfully deleted!");
                } else {
                    JOptionPane.showMessageDialog(panelResidentManagement,
                                                  "Please select an item!");
                }
            }
        });

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Apartment apartment = new Apartment();
                String Apt = txtAptNo.getText();

                while (true) {
                    if (Apt.isBlank()) {
                        JOptionPane.showMessageDialog(panelResidentManagement,
                                                      "Please enter Apt No!");
                        break;
                    } else {
                        id += 1;
//                        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                        apartment.setAptNo(Apt);
//                        apartment.setOrderTime(String.valueOf(time));
//                        apartment.setOrderId(id);
//                        OrderCatalog.addOrder(Apt, order);
//                        AptOrderCatalog.getInstance().addNewOrderItem(order);

                        //TODO CONFIRM APT ORDERS
                        int len = tableCart.getRowCount();
                        List<Order> curr_order = null;

                        for (int i=0; i<len; i++) {
                            Product curr_product = warehouse.get(i);
                            orders.addProduct(curr_product);
                            curr_order.add(orders);
                        }

                        aptOrderCatalog.setList(curr_order);
                        aptOrderCatalog.setAptNo(Apt);


                        JOptionPane.showMessageDialog(panelResidentManagement,
                                                      "Successfully confirmed!");
                        Main.gotoPanel("Community");
                    }
                }
            }
        });

    }

    public JPanel getPanel() {
        return panelResidentManagement;
    }

//    public static void updateTableItem(JTable tableItem){
//        SuperMarket market = SuperMarket.getInstance();
//        tableItem = new JTable(market.getWh());
//    }
    private void createUIComponents() {
        SuperMarket market = SuperMarket.getInstance();
        tableItem = new JTable(market.getWh());
    }
}
