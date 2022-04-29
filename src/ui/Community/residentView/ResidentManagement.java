package ui.Community.residentView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import model.Apartment;
//import model.SuperMarket.orderCenter.OrderCatalog;
//import model.SuperMarket.orderCenter.OrderItem;
import model.CommunityData.CommunityInfo;
import model.CommunityData.CommunityModel;
import model.Product;
import model.SuperMarket.wareHouse.Warehouse;
import model.OrderData.Order;
import model.OrderData.AptOrderCatalog;
//import model.SuperMarket.orderCenter.ProductCatalog;
import model.OrderData.AptOrderCatalog;
import ui.Main;

public class ResidentManagement {


    private JPanel panelResidentManagement;
    private JButton btnBack;
    private JTable tableItem;
    private JTable tableCart;
    private JButton btnConfirm;
    private JButton btnDelete;
    private JTextField txtAptNo;
    private JButton btnAdd;


//    Vector<String> titlesMenu;
//    Vector<Vector<Product>> dataMenu;
//    DefaultTableModel tableModelMenu;
//
//    Vector<String> titlesCart;
//    Vector<Vector<Product>> dataCart;
//    DefaultTableModel tableModelCart;

//    ProductCatalog productCatalog = ProductCatalog.getInstance();
//    OrderItem order = new OrderItem();

    Warehouse warehouse = new Warehouse();
    Order orders;
    AptOrderCatalog aptOrderCatalog;
    CommunityModel communityModel;
    CommunityInfo communityInfo;

    int id = 0;

    public ResidentManagement() {

//        titlesMenu = new Vector<>();
//        titlesMenu.add("Item Name");
//        titlesMenu.add("Price");
//        titlesMenu.add("Item Status");
//        titlesMenu.add("Quantity");

        String[] titleProduct = {"Item Name", "Price", "Manufacture Date", "Quantity", "Item Status"};
        int len_row = warehouse.getRowCount();
        int len_col = warehouse.getColumnCount();
        String[][] dataProduct = new String[len_row][];

        for (int i=0; i<len_row; i++) {
            for (int j=0; j<len_col; j++) {
                dataProduct[i][j] = (String) warehouse.getValueAt(i, j);
            }
        }

        tableItem = new JTable(dataProduct, titleProduct);

        String[] titleCart = {"Item Name", "Price", "Manufacture Date", "Quantity", "Item Status"};
        String[][] dataCart = new String[5][];
        tableCart = new JTable(dataCart, titleCart);

//        dataMenu.addElement((Vector<Product>) productCatalog.getProducts());
//        tableModelMenu = new DefaultTableModel(dataMenu, titlesMenu);
////        tableItem = new JTable(tableModelMenu);
//        tableItem = new JTable(dataMenu, titlesMenu);
//        tableItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        JScrollPane scrollPaneMenu = new JScrollPane(tableItem);
//        scrollPaneMenu.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.gotoPanel("Community");
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //TODO ADD ITEMS TO CART
                int row = tableItem.getSelectedRow();
//                Product curr_product = warehouse.get(row);
                int len_col = tableItem.getColumnCount();

                for (int i=0; i<len_col; i++) {
                    dataCart[row][i] = (String) tableItem.getValueAt(row, i);
                }
//                order.setName(String.valueOf(tableItem.getValueAt(row, 0)));
//                order.setUnitPrice((Double) tableItem.getValueAt(row, 1));
//                order.setPrice((Integer) tableItem.getValueAt(row, 2));
//                order.setQuantityForOrder((Integer) tableItem.getValueAt(row, 3));
//                OrderCatalog.getInstance().setCurrentOrder(order);
//                warehouse.add(curr_product);
                tableCart = new JTable(dataCart, titleCart);

                JOptionPane.showMessageDialog(panelResidentManagement, "Successfully add to cart!");
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableCart.getSelectedRow();
                int len_col = tableCart.getColumnCount();
                int len_row = tableCart.getRowCount();

                if (row > 0) {
                    for (int i=0; i<len_row; i++) {

                        if (i==row) { i += 1; }
                        for (int j=0; j<len_col; j++) {
                            dataCart[i][j] = (String) tableItem.getValueAt(i, j);
                        }
                    }
                    dataCart[-1] = new String[]{};
                    tableCart = new JTable(dataCart, titleCart);
                    JOptionPane.showMessageDialog(panelResidentManagement, "Successfully deleted!");
                } else {
                    JOptionPane.showMessageDialog(panelResidentManagement,
                                                  "Please select an item!");
                }
            }
        });

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Apartment apartment = new Apartment();
                String Apt = txtAptNo.getText();

                while (true) {
                    if (Apt.isBlank()) {
                        JOptionPane.showMessageDialog(panelResidentManagement,
                                                      "Please enter Apt No!");
                        break;
                    } else {
                        id += 1;
//                        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                        apartment.setAptNo(Apt);
//                        apartment.setOrderTime(String.valueOf(time));
//                        apartment.setOrderId(id);
//                        OrderCatalog.addOrder(Apt, order);
//                        AptOrderCatalog.getInstance().addNewOrderItem(order);

                        //TODO COMFIRM APT ORDERS
                        int len = tableCart.getRowCount();
                        List<Order> curr_order = null;

                        for (int i=0; i<len; i++) {
                            Product curr_product = warehouse.get(i);
                            orders.addProduct(curr_product);
                            curr_order.add(orders);
                        }

                        aptOrderCatalog.setList(curr_order);
                        aptOrderCatalog.setAptNo(Apt);


                        JOptionPane.showMessageDialog(panelResidentManagement,
                                                      "Successfully confirmed!");
                        Main.gotoPanel("Community");
                    }
                }
            }
        });

    }

    public JPanel getPanel() {
        return panelResidentManagement;
    }


}
