package ui.Community.residentView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Vector;

import model.Apartment;
import model.SuperMarket.orderCenter.OrderCatalog;
import model.SuperMarket.orderCenter.OrderItem;
import model.SuperMarket.orderCenter.Product;
import model.SuperMarket.orderCenter.ProductCatalog;
import model.communityAndMarketDataTest.AptOrderCatalog;
import ui.Community.mainJPanel.communityMain;

public class residentManagement extends Component {


    private JPanel panelResidentManagement;
    private JButton btnBack;
    private JTable tableItem;
    private JTable tableCart;
    private JButton btnConfirm;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JTextField txtAptNo;
    private JButton btnAdd;

    JFrame jFrame = new JFrame();

    Vector<String> titlesMenu;
    Vector<Vector<Product>> dataMenu;
    DefaultTableModel tableModelMenu;

    Vector<String> titlesCart;
    Vector<Vector<Product>> dataCart;
    DefaultTableModel tableModelCart;

    ProductCatalog productCatalog = ProductCatalog.getInstance();
    OrderItem order = new OrderItem();

    int id = 0;

    public residentManagement() {

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelResidentManagement.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelResidentManagement);

        titlesMenu = new Vector<>();
        titlesMenu.add("Item Name");
        titlesMenu.add("Price");
        titlesMenu.add("Item Status");
        titlesMenu.add("Quantity");

        dataMenu.addElement((Vector<Product>) productCatalog.getProducts());
        tableModelMenu = new DefaultTableModel(dataMenu, titlesMenu);
//        tableItem = new JTable(tableModelMenu);
        tableItem = new JTable(dataMenu, titlesMenu);
//        tableItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        JScrollPane scrollPaneMenu = new JScrollPane(tableItem);
//        scrollPaneMenu.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component communityMain = panelResidentManagement.add("communityMain", new communityMain().getFrame());
                ((CardLayout) panelResidentManagement.getLayout()).show(panelResidentManagement, "communityMain");
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = tableItem.getSelectedRow();
                int len = tableItem.getColumnCount();
                for (int i=0; i<len; i++) {
                    dataCart.addElement((Vector<Product>) tableItem.getValueAt(row, i));
                }
                order.setName(String.valueOf(tableItem.getValueAt(row, 0)));
                order.setUnitPrice((Double)tableItem.getValueAt(row, 1));
                order.setPrice((Integer)tableItem.getValueAt(row, 2));
                order.setQuantityForOrder((Integer)tableItem.getValueAt(row, 3));
                OrderCatalog.getInstance().setCurrentOrder(order);
                tableCart = new JTable(dataCart, titlesCart);

                JOptionPane.showMessageDialog(residentManagement.this, "Successfully add to cart!");
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableCart.getSelectedRow();

                if (row>0) {
                    String item = String.valueOf(tableCart.getValueAt(row, 0));
                    OrderCatalog.deleteOrder(OrderCatalog.getInstance().getCurrentOrder(), item);
                    JOptionPane.showMessageDialog(residentManagement.this, "Successfully deleted!");
                }
                else {
                    JOptionPane.showMessageDialog(residentManagement.this, "Please select an item!");
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
                        JOptionPane.showMessageDialog(residentManagement.this, "Please enter Apt No!");
                        break;
                    }
                    else {
                        id += 1;
                        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        apartment.setAptNo(Apt);
                        apartment.setOrderTime(String.valueOf(time));
                        apartment.setOrderId(id);
                        OrderCatalog.addOrder(Apt, order);
                        AptOrderCatalog.getInstance().addNewOrderItem(order);
                        JOptionPane.showMessageDialog(residentManagement.this, "Successfully confirmed!");
                        jFrame.setVisible(false);
                        panelResidentManagement.add("CommunityMain", new ui.Community.mainJPanel.communityMain().getFrame());
                        ((CardLayout) panelResidentManagement.getLayout()).show(panelResidentManagement, "CommunityMain");
                    }
                }
            }
        });

    }

    public JPanel getPanel() {
        return panelResidentManagement;
    }



    public static void main(String[] args) {
        new residentManagement();
    }

    public Frame getFrame() {
        return jFrame;
    }
}
