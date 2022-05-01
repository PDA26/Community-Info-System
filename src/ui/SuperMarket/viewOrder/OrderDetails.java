package ui.SuperMarket.viewOrder;

import model.OrderData.AptOrderCatalog;
import model.OrderData.CommunityOrderCatalog;
import model.OrderData.Order;
import model.OrderData.OrderCenter;
import model.Product;
import model.SuperMarket.SuperMarket;
import ui.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class OrderDetails {


    /**
     * table
     */
    Vector<Vector<Object>> data;
    static DefaultTableModel tableModel;
    static {
        tableModel = new DefaultTableModel();
    }

    String[][] allOrderDetails;

    /**
     * components
     */
    private JTable orderDetailsJTable;
    private JLabel nameLabel;
    private JPanel ViewOrderDetailsJPanel;
    private JButton backToOrderInterfaceButton;


    private String communityName;
    private String time;
    private int orderID;

    private AptOrderCatalog currentApt;

//    private SuperMarket superMarket = SuperMarket.getInstance();

    private void InitTable() {

        data = new Vector<>();
//        data.addAll(productModel.getData());
        orderDetailsJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        orderDetailsJTable.setModel(tableModel);
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Price");
        tableModel.addColumn("Modified Date");
        tableModel.addColumn("Quantity");
//        tableModel.addColumn("Unit Price");
        tableModel.addColumn("Status");

    }

    public OrderDetails() {


        InitTable();

        populateTable();

        backToOrderInterfaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.gotoPanel("ViewOrder");
            }
        });

    }

    public void populateTable() {


//        System.out.println("community selected is  " + this.communityName);

        DefaultTableModel model = (DefaultTableModel) orderDetailsJTable.getModel();
        model.setRowCount(0);

//        AptOrderCatalog currentAptOrderCatalog = new AptOrderCatalog();


        //allOrderDetails = currentAptOrderCatalog.getAllOrderDetails();
        SuperMarket superMarket = SuperMarket.getInstance();
        OrderCenter oc = superMarket.getOc();

        Map<String, CommunityOrderCatalog> map01 = oc.getMap();

        Set<Map.Entry<String, CommunityOrderCatalog>> entries = map01.entrySet();
        for (Map.Entry<String, CommunityOrderCatalog> entry : entries) {

            String key = entry.getKey();
            CommunityOrderCatalog value = entry.getValue();

//            System.out.println(key + "  " + value);

//            Set<Map.Entry<String, AptOrderCatalog>> entries1 = value.getMap().entrySet();

            AptOrderCatalog aptOrderCatalog = value.getMap().get(communityName);
            if (aptOrderCatalog != null) {

                List<Order> list = aptOrderCatalog.getList();
                for (Order order : list) {

                    if (order.getId() == orderID){

//                        System.out.println(order);
                        List<Product> itemList = order.getItemList();
                        for (Product product : itemList) {
//                            System.out.println(product);
                            Object[ ] row = new Object[5];
                            row[0] = product.getName();
                            row[1] = product.getPrice();
                            row[2] = product.getModifiedDate();
                            row[3] = product.getQuantity();
                            row[4] = product.getInStock();

                            model.addRow(row);

                        }

                    }

                }

            }

        }

    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        nameLabel.setText(communityName);
        this.communityName = communityName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public JPanel getPanel() {
        return ViewOrderDetailsJPanel;
    }

}
