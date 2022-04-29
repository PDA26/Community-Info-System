package ui.SuperMarket.viewOrder;

import model.OrderData.AptOrderCatalog;
import model.OrderData.CommunityOrderCatalog;
import model.OrderData.Order;
import model.OrderData.OrderCenter;
import ui.Community.communityView.communityOrder.OrderDetail;
import ui.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

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

    private OrderCenter currentOrderCenter = new OrderCenter();


    private void InitTable() {

        data = new Vector<>();
//        data.addAll(productModel.getData());
        orderJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        orderJTable.setModel(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Community");
        tableModel.addColumn("Order Time");
        tableModel.addColumn("Order Status");

    }

    public ViewOrder() {

        populateOrderTable();
        currentOrderCenter = new OrderCenter();

        backToMarketInterfaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.gotoPanel("Market");
            }
        });

        orderDetails = new OrderDetails();
        Main.addPanel(orderDetails.getPanel(), "ViewOrderDetails");
        viewOrderDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO - retrieve order details from selected row

                int row = orderJTable.getSelectedRow();
                if (row >= 0 ) {

                    String communityName = (String) tableModel.getValueAt(row, 1);
                    Set<Map.Entry<String, CommunityOrderCatalog>> entries = currentOrderCenter.getMap().entrySet();
                    for (Map.Entry<String, CommunityOrderCatalog> entry : entries) {
                        CommunityOrderCatalog value = entry.getValue();

                        orderDetails.setCurrentAptOrderCatalog(value, communityName);

                    }

                    orderDetails.setCommunityName(communityName);
//                    orderDetails.setTime();
                    Main.gotoPanel("ViewOrderDetails");


                }else {
                    JOptionPane.showMessageDialog(null, "please select the row to operate on", "hint",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });

//        updateOrderStatusButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //TODO - yes or no to change status from 'PENDING' TO 'ACCEPTED'
//                int i = JOptionPane.showConfirmDialog(viewOrderPanel, "Do you want to change order status?",
//                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//                if(i == 0){
//                    //yes
//
//                }else{
//
//                }
//            }
//        });
    }

    public void populateOrderTable() {

        DefaultTableModel model = (DefaultTableModel) orderJTable.getModel();
        model.setRowCount(0);

        Map<String, CommunityOrderCatalog> communityOrderMap = currentOrderCenter.getMap();
        Set<Map.Entry<String, CommunityOrderCatalog>> communityEntries = communityOrderMap.entrySet();
        int ID = 1;
        for (Map.Entry<String, CommunityOrderCatalog> communityEntry : communityEntries) {

            CommunityOrderCatalog communityMap = communityEntry.getValue();

            Map<String, AptOrderCatalog> aptOrders = communityMap.getMap();
            Set<Map.Entry<String, AptOrderCatalog>> aptEntries = aptOrders.entrySet();
            for (Map.Entry<String, AptOrderCatalog> aptEntry : aptEntries) {

                String communityName = aptEntry.getKey();
                AptOrderCatalog apt = aptEntry.getValue();

                Object[ ] row = new Object[4];
                row[0] = ID;
                row[1] = communityName;
                row[2] = apt.getMostRecentOrderDate().toString();

                ID ++;
                model.addRow(row);

            }

        }

//        HashMap<String, Product> map = productModel.getProductCatalogMap();
//        Set<Map.Entry<String, Product>> entries = map.entrySet();
//        for (Map.Entry<String, Product> entry : entries) {
//
//            Product product = entry.getValue();
//            Object[ ] row = new Object[5];
//            row[0] = product.getName();
//            row[1] = product.getPrice();
//            row[2] = product.getModifiedDate();
//            row[3] = product.getQuantity();
//            //row[4] = product.getItemStatus();
//            model.addRow(row);

    }

    public void setCurrentOrderCenter(OrderCenter oc){
        this.currentOrderCenter = oc;
    }
    public JPanel getPanel() {
        return viewOrderPanel;
    }
}
