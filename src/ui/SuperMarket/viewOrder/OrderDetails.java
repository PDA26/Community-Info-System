package ui.SuperMarket.viewOrder;

import model.OrderData.AptOrderCatalog;
import model.OrderData.CommunityOrderCatalog;
import model.OrderData.Order;
import model.Product;
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
    private JButton updateOrderStatusButton;
    private String communityName;
    private String time;

    private AptOrderCatalog currentAptOrderCatalog = new AptOrderCatalog();

    private void InitTable() {

        data = new Vector<>();
//        data.addAll(productModel.getData());
        orderDetailsJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        orderDetailsJTable.setModel(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Date");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Unit Price");
//        tableModel.addColumn("Status");

    }

    public OrderDetails() {

        InitTable();
        nameLabel.setText(communityName);

        populateTable();

        backToOrderInterfaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.gotoPanel("ViewOrder");
            }
        });

        updateOrderStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO - yes or no to change status from 'PENDING' TO 'ACCEPTED'
                int i = JOptionPane.showConfirmDialog(ViewOrderDetailsJPanel, "Do you want to change order status?",
                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(i == 0){
                    //yes
                    int row = orderDetailsJTable.getSelectedRow();
                    allOrderDetails[row][5] = Order.OrderStatus.ACCEPTED.toString();

                    populateTable();

                }else{

                    return;

                }
            }
        });

    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) orderDetailsJTable.getModel();
        model.setRowCount(0);
        Object[ ] row = new Object[5];
        allOrderDetails = currentAptOrderCatalog.getAllOrderDetails();
        for (int a = 0; a < allOrderDetails.length; a ++) {
            for (int i = 0; i < allOrderDetails[a].length; i ++) {

                row[i] = allOrderDetails[a][i];

            }
            model.addRow(row);
        }

    }


    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCurrentAptOrderCatalog(CommunityOrderCatalog communityOrderCatalog, String name) {

        this.currentAptOrderCatalog = communityOrderCatalog.getMap().get(name);

    }

    public JPanel getPanel() {
        return ViewOrderDetailsJPanel;
    }

}
