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

public class ViewOrder {

    private OrderDetails orderDetails;

    /**
     * table
     */
    Vector<Vector<Object>> data;
    static DefaultTableModel tableModel;
    static {
        tableModel = new DefaultTableModel();
    }

    /**
     * components
     */
    private JButton viewOrderDetailsButton;
    private JTable orderJTable;
    private JButton backToMarketInterfaceButton;
    private JPanel viewOrderPanel;
    private JButton updateOrderStatusButton;

    private int IDForUpdateStatus;

//    private OrderCenter currentOrderCenter;
//    private SuperMarket superMarket = SuperMarket.getInstance();



    private void InitTable() {

//        data = new Vector<>();
//        data.addAll(productModel.getData());
        orderJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        orderJTable.setModel(tableModel);
//        tableModel.addColumn("ID");
//        tableModel.addColumn("Community");
//        tableModel.addColumn("Order Time");
//        tableModel.addColumn("Apartment Number");
//        tableModel.addColumn("Order Status");

    }

    static {

//        orderJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        orderJTable.setModel(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Community");
        tableModel.addColumn("Order Time");
        tableModel.addColumn("Apartment Number");
        tableModel.addColumn("Order Status");

    }

    public ViewOrder() {

        SuperMarket superMarket = SuperMarket.getInstance();
        InitTable();

        populateOrderTable();

//        currentOrderCenter = new OrderCenter();

        backToMarketInterfaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.gotoPanel("Market");
            }
        });

        orderDetails = new OrderDetails();
        Main.addPanel(orderDetails.getPanel(), "ViewOrderDetails");
//        Test test = new Test();
//        Main.addPanel(test.getJPanel(), "test");
        viewOrderDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO - retrieve order details from selected row

//                CommunityModel communityModel = CommunityModel.getInstance();
//                CommunityInfo currentCommunity = communityModel.getCurrentCommunity();
//                String communityName1 = currentCommunity.getCommunityName();

                int row = orderJTable.getSelectedRow();
                if (row >= 0 ) {

                    String communityName = (String) tableModel.getValueAt(row, 1);
                    orderDetails.setCommunityName(communityName);
//                    orderDetails.getNameLabel().setText(communityName);

                    int orderId = (int) tableModel.getValueAt(row, 0);
                    orderDetails.setOrderID(orderId);

//                    test.setjLabel("12312");
                    Main.gotoPanel("ViewOrderDetails");
                    orderDetails.populateTable();
//                    Main.gotoPanel("test");


                }else {
                    JOptionPane.showMessageDialog(null, "please select the row to operate on", "hint",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        updateOrderStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = orderJTable.getSelectedRow();
                if (row >= 0 ) {

                    IDForUpdateStatus = (int) tableModel.getValueAt(row, 0);

                    int i = JOptionPane.showConfirmDialog(viewOrderPanel, "Do you want to change order status?",
                            "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(i == 0 && ((String)tableModel.getValueAt(row, 4)).equals("ACCEPTED")){
                        //yes
                        setStatusForOrder();
                        populateOrderTable();

                    }else{
                        JOptionPane.showMessageDialog(viewOrderPanel, "Only ACCEPTED order can be shipped!");
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "please select the row to operate on", "hint",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    public void setStatusForOrder() {

        SuperMarket superMarket = SuperMarket.getInstance();
        OrderCenter oc = superMarket.getOc();

        Map<String, CommunityOrderCatalog> map01 = oc.getMap();

        Set<Map.Entry<String, CommunityOrderCatalog>> entries = map01.entrySet();
        for (Map.Entry<String, CommunityOrderCatalog> entry : entries) {

            String key = entry.getKey();
            CommunityOrderCatalog value = entry.getValue();

            Set<Map.Entry<String, AptOrderCatalog>> entries1 = value.getMap().entrySet();
            for (Map.Entry<String, AptOrderCatalog> stringAptOrderCatalogEntry : entries1) {
                AptOrderCatalog aptOrderCatalog = stringAptOrderCatalogEntry.getValue();

                if (aptOrderCatalog != null) {

                    List<Order> list = aptOrderCatalog.getList();
                    for (Order order : list) {

                        if (order.getStatus() == Order.OrderStatus.ACCEPTED){

                        System.out.println(order);

                            order.setStatus(Order.OrderStatus.SHIPPED);

                        }

                    }

                }


            }

        }

    }

    public void populateOrderTable() {

        DefaultTableModel model = (DefaultTableModel) orderJTable.getModel();
        model.setRowCount(0);

        int ID = 1;
        SuperMarket instance = SuperMarket.getInstance();
        Map<String, CommunityOrderCatalog> communityOrderMap = instance.getOc().getMap();

        Set<Map.Entry<String, CommunityOrderCatalog>> entries = communityOrderMap.entrySet();

        for (Map.Entry<String, CommunityOrderCatalog> entry : entries) {
            String key = entry.getKey();
            CommunityOrderCatalog value = entry.getValue();
//            System.out.println(key + "  " + value);
            Object[ ] row = new Object[5];
            Set<Map.Entry<String, AptOrderCatalog>> entries1 = value.getMap().entrySet();
            for (Map.Entry<String, AptOrderCatalog> stringAptOrderCatalogEntry : entries1) {
                String key1 = stringAptOrderCatalogEntry.getKey();
                AptOrderCatalog value1 = stringAptOrderCatalogEntry.getValue();
//                System.out.println(key + "  " + value1);

                List<Order> list = value1.getList();
                for (Order order : list) {

                    row[0] = ID;
                    row[1] = key1;
                    String date = value1.getMostRecentOrderDate().toString();
                    row[2] = date;
                    row[3] = value1.getAptNo();
                    row[4] = order.getStatus().toString();
                    ID++;
                    model.addRow(row);

//                    System.out.println(order);
                }

            }

        }

    }

    public JPanel getPanel() {
        return viewOrderPanel;
    }
}
