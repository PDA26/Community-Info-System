package ui.SuperMarket.viewMenu;

import model.Product;
import model.SuperMarket.wareHouse.Warehouse;
import ui.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewItemMenu {

    /**
     * components
     */
    private JPanel viewItemMenuJPanel;
    private JButton addItemJButton;
    private JButton modifyItemJButton;
    private JButton deleteItemJButton;
    private JButton backToMarketJButton;
    private JLabel titleJLabel;
    private JTable itemTable;

    private Warehouse currentWarehouse;


    public ViewItemMenu() {
        addItemJButton.addActionListener(e -> {
            Product product = EditItem.showEditItem(viewItemMenuJPanel, null);
            currentWarehouse.add(product);
        });
        backToMarketJButton.addActionListener(actionEvent -> Main.gotoPanel("Market"));
        modifyItemJButton.addActionListener(actionEvent -> {
            int row = itemTable.getSelectedRow();
            if (row != -1) {
                Product product = currentWarehouse.get(row);
                product = EditItem.showEditItem(viewItemMenuJPanel, product);
                if (product != null) {
                    currentWarehouse.fireTableRowsUpdated(row, row);
                }
            }
        });
    }

    public JPanel getPanel() {
        return viewItemMenuJPanel;
    }
    public void setCurrentWarehouse(Warehouse currentWarehouse) {
        this.currentWarehouse = currentWarehouse;
        itemTable.setModel(currentWarehouse);
    }
}
