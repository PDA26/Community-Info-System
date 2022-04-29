package ui.SuperMarket.viewOrder;

import model.OrderData.OrderCenter;
import ui.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewOrder {
    private JButton viewOrderDetailsButton;
    private JButton updateOrderStatusButton;
    private JTable table1;
    private JButton backToMarketInterfaceButton;
    private JPanel viewOrderPanel;
    private OrderCenter oc;

    public ViewOrder() {

        backToMarketInterfaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.gotoPanel("Market");
            }
        });


        viewOrderDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO - retrieve order details from selected row
            }
        });

        updateOrderStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO - yes or no to change status from 'PENDING' TO 'ACCEPTED'
                int i = JOptionPane.showConfirmDialog(viewOrderPanel, "Do you want to change order status?",
                        "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(i == 0){
                    //yes
                }else{

                }
            }
        });
    }
    public void setCurrentOrderCenter(OrderCenter oc){
        this.oc = oc;
    }
    public JPanel getPanel() {
        return viewOrderPanel;
    }
}
