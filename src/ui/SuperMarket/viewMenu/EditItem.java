package ui.SuperMarket.viewMenu;

import model.SuperMarket.orderCenter.Product;
import model.SuperMarket.orderCenter.ProductCatalog;
import sun.net.ext.ExtendedSocketOptions;
import ui.SuperMarket.mainJPanel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditItem {

    /**
     * data
     */
    ProductCatalog productModel = ProductCatalog.getInstance();

    /**
     * components
     */
    private JPanel addItemJPanel;
    private JPanel contentJPanel;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField updateTimeField;
    private JTextField quantityField;
    private JComboBox itemStatusComboBox;
    private JButton addJButton;
    private JButton backJButton;
    private JLabel titleJLabel;
    private JLabel nameJLabel;
    private JLabel priceJLabel;
    private JLabel modifiedDateJLabel;
    private JLabel quantityJLabel;
    private JLabel itemStatusJLabel;

    public EditItem() {

        InitComboBox();

        backJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ExtendedSocketOptions MainProcess;
                if (nameField.getText().isEmpty()
                        || priceField.getText().isEmpty()
                        || updateTimeField.getText().isEmpty()
                        || quantityField.getText().isEmpty()
                        || itemStatusComboBox.getSelectedIndex() == 0) {

                    MainProcess.getInstance().showDialog("information cannot be empty");

                }else {

                    Product product = new Product();
                    product.setName(nameField.getText());
                    product.setPrice(Double.parseDouble(priceField.getText()));
                    product.setModifiedDate(updateTimeField.getText());
                    product.setQuantity(Integer.parseInt(quantityField.getText()));
                    product.setItemStatus(itemStatusComboBox.getSelectedIndex());

                    productModel.addNewProduct(product);

                    MainProcess.getInstance().showDialog("New Item Profile Inserted Successfully!!");

                    //check the data
                    //productModel.printCatalog();

                    MainProcess.getInstance().changeFrame(new ViewItemMenu().getPanel());

                }

            }
        });
    }

    public void InitComboBox() {

        itemStatusComboBox.addItem("- please select -");
        itemStatusComboBox.addItem("In Stock");
        itemStatusComboBox.addItem("Not In Stock");

    }

    public JPanel getPanel() {

        return addItemJPanel;

    }

}
