package ui.SuperMarket.viewMenu;

import model.Product;
// import model.SuperMarket.orderCenter.ProductCatalog;

import javax.swing.*;

public class EditItem {

    /**
     * data
     */

    /**
     * components
     */
    private JPanel addItemJPanel;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField updateTimeField;
    private JTextField quantityField;
    private JComboBox<String> itemStatusComboBox;
    private JLabel nameJLabel;
    private JLabel priceJLabel;
    private JLabel modifiedDateJLabel;
    private JLabel quantityJLabel;
    private JLabel itemStatusJLabel;

    public static Product showEditItem(JComponent parent, Product originalProduct) {
        EditItem editItem = new EditItem(originalProduct);
        int option = JOptionPane.showConfirmDialog(parent,
                                                   editItem.getPanel(),
                                                   "Add Item",
                                                   JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            return editItem.checkValidAndCreate(originalProduct);
        }
        return null;
    }

    private Product checkValidAndCreate(Product product) {
        if (nameField.getText().isEmpty()
            || priceField.getText().isEmpty()
            || updateTimeField.getText().isEmpty()
            || quantityField.getText().isEmpty()
            || itemStatusComboBox.getSelectedIndex() == -1) {

            JOptionPane.showMessageDialog(addItemJPanel,
                                          "Information cannot be empty",
                                          "Invalid Input",
                                          JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            if (product == null) product = new Product();
            product.setName(nameField.getText());
            product.setPrice(Double.parseDouble(priceField.getText()));
            product.setModifiedDate(updateTimeField.getText());
            product.setQuantity(Integer.parseInt(quantityField.getText()));
            product.setInStock(itemStatusComboBox.getSelectedIndex() != 0);

            return product;
        }
    }

    public EditItem(Product product) {

        itemStatusComboBox.addItem("Not In Stock");
        itemStatusComboBox.addItem("In Stock");
        itemStatusComboBox.setSelectedIndex(-1);

        if (product != null) {
            nameField.setText(product.getName());
            priceField.setText(Double.toString(product.getPrice()));
            updateTimeField.setText(product.getModifiedDate());
            quantityField.setText(Integer.toString(product.getQuantity()));
            itemStatusComboBox.setSelectedIndex(product.getInStock() ? 1 : 0);
        }
    }

    public JPanel getPanel() {

        return addItemJPanel;

    }

}
