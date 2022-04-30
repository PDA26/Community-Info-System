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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
            int[] rows = tableOrders.getSelectedRows();
            if (rows.length > 0) {
                String address = LocationChooser.show(tableOrders);
                for (int row: rows) {
                    deliveryTableModel.setAddress(row, address);
                }
            } else {
                JOptionPane.showMessageDialog(panel, "None of orders selected!");
            }
        });
        updateOrderStatusButton.addActionListener(e -> {
            int[] rows = tableOrders.getSelectedRows();
            if (rows.length > 0) {
                int tag = JOptionPane.showConfirmDialog(
                        tableOrders,
                        "Are you sure to complete selected order(s)?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION
                );
                if (tag == JOptionPane.YES_OPTION) {
                    for (int row : rows) {
                        deliveryTableModel.setStatus(row, Order.OrderStatus.FINISHED);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(panel, "None of orders selected!");
            }
        });
        goBackButton.addActionListener(actionEvent -> Main.gotoPanel("SignIn"));

        tableOrders.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent ancestorEvent) {
                List<Order> orders = SuperMarket.getInstance()
                                                .getOc()
                                                .getAllOrders()
                                                .stream()
                                                .filter(order -> order.getStatus() ==
                                                                 Order.OrderStatus.SHIPPED)
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
}
