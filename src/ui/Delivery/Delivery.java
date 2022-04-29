package ui.Delivery;

import model.CommunityData.CommunityModel;
import model.OrderData.Order;
import model.SuperMarket.SuperMarket;
import ui.Main;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class Delivery {
    private final DeliveryTableModel deliveryTableModel = new DeliveryTableModel();
    private JButton goBackButton;
    private JTable tableOrders;
    private JButton chooseGroceryStoreButton;
    private JButton updateOrderStatusButton;
    private JPanel panel;

    public Delivery() {
        chooseGroceryStoreButton.addActionListener(actionEvent -> {
            int row = tableOrders.getSelectedRow();
            if (row != -1) {
                String address = LocationChooser.show(tableOrders);
                deliveryTableModel.setAddress(row, address);
            }
        });
        updateOrderStatusButton.addActionListener(e -> {
            int selected = tableOrders.getSelectedRow();
            if (selected != -1) {
                int tag = JOptionPane.showConfirmDialog(
                        tableOrders,
                        "Are you sure to complete this order",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION
                );
                if (tag == JOptionPane.YES_OPTION) {
                    //deal with order
                    deliveryTableModel.setStatus(selected, Order.OrderStatus.FINISHED);
                }
            }
        });
        goBackButton.addActionListener(actionEvent -> Main.gotoPanel("SignIn"));

        tableOrders.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent ancestorEvent) {
                List<Order> orders =
                        SuperMarket.getInstance()
                                   .getOc()
                                   .getAllOrders()
                                   .stream()
                                   .filter(order -> order.getStatus() == Order.OrderStatus.ACCEPTED)
                                   .collect(Collectors.toList());

                deliveryTableModel.setOrders(orders);
            }

            @Override
            public void ancestorRemoved(AncestorEvent ancestorEvent) {
            }

            @Override
            public void ancestorMoved(AncestorEvent ancestorEvent) {
            }
        });

        tableOrders.setModel(deliveryTableModel);
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
