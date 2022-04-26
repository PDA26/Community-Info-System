package ui.SuperMarket.viewItemMenu;

import model.SuperMarket.orderCenter.ProductCatalog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ViewItemMenuForm extends JPanel{

    /**
     * data
     */
    ProductCatalog productModel = ProductCatalog.getInstance();

    /**
     * table
     */
    Vector<String> titles;
    Vector<Vector<Object>> data;
    DefaultTableModel tableModel;

    /**
     * components
     */
    private JPanel viewItemMenuJPanel;
    private JPanel contentJPanel;
    private JTable jTable;
    private JButton addItemJButton;
    private JButton modifyItemJButton;
    private JButton deleteItemJButton;
    private JButton backToMarketJButton;
    private JLabel titleJLabel;
    private JTable table1;

    private void InitTable() {

        titles = new Vector<>();
        titles.add("Item Name");
        titles.add("Price");
        titles.add("Modified Date");
        titles.add("Quantity");
        titles.add("Item Status");

        data = new Vector<>();
        data.addAll(productModel.getData());

        tableModel = new DefaultTableModel(data, titles);

        jTable = new JTable(tableModel);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        JScrollPane scrollPane = new JScrollPane(jTable);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        tableJPanel.add(scrollPane);

    }

    public ViewItemMenuForm() {

        //InitTable();

        addItemJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //MainProcess.getInstance().changeFrame(new AddItemForm().getPanel());

            }
        });
    }

    public JPanel getPanel() {
        return viewItemMenuJPanel;
    }

}
