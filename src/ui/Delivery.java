package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delivery {
    private JButton goBackButton;
    private JTable tableOrders;
    private JButton chooseGroceryStoreButton;
    private JButton updateOrderStatusButton;

    public Delivery() {
        updateOrderStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tag = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure to complete this order",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION
                        );
                if(tag == 1){
                    int selected = tableOrders.getSelectedRow();
                    if(selected != -1){
                        //deal with order
                    }
                }else{
                    //none
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
