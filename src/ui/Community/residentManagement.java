package ui.Community;

import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class residentManagement<dataCart> extends JPanel {

    /**
     * Define Components
     */

    private JPanel topJPanel;
    private JPanel middleJPanel;
    private JPanel bottomJPanel;
    private JPanel JPanelContent;
    JFrame jFrame = new JFrame();

    JLabel titleJLabel = new JLabel("Welcome Residents! Please add your items into cart!");
    JLabel titleCart = new JLabel("My Cart:");
    JLabel comName = new JLabel("Apt No. :");
    JTextField aptNo = new JTextField();
    JButton btnBack = new JButton("Back to Community");
    JButton btnCart = new JButton("Add to Cart");
//    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnConfirm = new JButton("Confirm");

    Vector<String> titlesMenu;
    Vector<Vector<Product>> dataMenu;
    DefaultTableModel tableModelMenu;

    Vector<String> titlesCart;
    Vector<Vector<Product>> dataCart;
    DefaultTableModel tableModelCart;

    JTable tableMenu;
    JTable tableCart;

    ProductCatalog productCatalog = ProductCatalog.getInstance();

    int id = 0;


    public residentManagement() {
        setStyle();
        InitData();
        InitView();

        OrderItem order = new OrderItem();
//        OrderCatalog.getInstance().setCurrentOrder()

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                JPanelContent.add("CommunityMain", new ui.Community.communityMain().getFrame());
                ((CardLayout) JPanelContent.getLayout()).show(JPanelContent, "CommunityMain");
//                jFrame.setVisible(false);
            }
        });

        btnCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = tableMenu.getSelectedRow();
                int len = tableMenu.getColumnCount();
                for (int i=0; i<len; i++) {
                    dataCart.addElement((Vector<Product>) tableMenu.getValueAt(row, i));
                }
                order.setName(String.valueOf(tableMenu.getValueAt(row, 0)));
                order.setUnitPrice((Double)tableMenu.getValueAt(row, 1));
                order.setPrice((Integer)tableMenu.getValueAt(row, 2));
                order.setQuantityForOrder((Integer)tableMenu.getValueAt(row, 3));
                OrderCatalog.getInstance().setCurrentOrder(order);
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
                String Apt = aptNo.getText();

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
                        JOptionPane.showMessageDialog(residentManagement.this, "Successfully confirmed!");
                        jFrame.setVisible(false);
                        JPanelContent.add("CommunityMain", new ui.Community.communityMain().getFrame());
                        ((CardLayout) JPanelContent.getLayout()).show(JPanelContent, "CommunityMain");
                    }
                }
            }
        });

    }

    private void InitData() {

        titlesMenu = new Vector<>();
        titlesMenu.add("Item Name");
        titlesMenu.add("Price");
        titlesMenu.add("Item Status");
        titlesMenu.add("Quantity");
        dataMenu = new Vector<>();
        dataMenu.addElement((Vector<Product>) productCatalog.getProducts());
        tableModelMenu = new DefaultTableModel(dataMenu, titlesMenu);
//        refreshTable();

        titlesCart = new Vector<>();
        titlesCart.add("Item Name");
        titlesCart.add("Price");
        titlesCart.add("Item Status");
        titlesCart.add("Quantity");
        dataCart = new Vector<>();
//        tableModelCart = new DefaultTableModel(dataCart, titlesCart);

//        int selected = tableMenu.getSelectedRow();
    }

//    private void refreshTable() {
//        ArrayList<ProductCatalog> list = productCatalog.getProducts();
//    }

    private void InitView() {
        CreateTopJPanel();
        CreateMiddleJPanel();
        CreateBottomJPanel();

        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new GridBagLayout());

        GridBagConstraints constraintsForTop = new GridBagConstraints();
        constraintsForTop.gridx = 0;
        constraintsForTop.gridy = 0;
        constraintsForTop.weightx = 1;
        constraintsForTop.weighty = 0;
        constraintsForTop.fill = GridBagConstraints.CENTER;
        panelContainer.add(topJPanel, constraintsForTop);

        GridBagConstraints constraintsForMiddle = new GridBagConstraints();
        constraintsForMiddle.gridx = 0;
        constraintsForMiddle.gridy = 1;
        constraintsForMiddle.weightx = 0;
        constraintsForMiddle.weighty = 0;
        constraintsForMiddle.fill = GridBagConstraints.CENTER;
        panelContainer.add(middleJPanel, constraintsForMiddle);

        GridBagConstraints constraintsForBottom = new GridBagConstraints();
        constraintsForBottom.gridx = 0;
        constraintsForBottom.gridy = 2;
        constraintsForBottom.weightx = 1;
        constraintsForBottom.weighty = 0;
        constraintsForBottom.fill = GridBagConstraints.CENTER;
        panelContainer.add(bottomJPanel, constraintsForBottom);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelContainer.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelContainer);
    }

    private void setStyle() {
        Font font_title = new Font(Font.SERIF, Font.PLAIN, 24);
        titleJLabel.setFont(font_title);

        aptNo.setSize(new Dimension(70,30));
    }

    private void CreateTopJPanel() {
        topJPanel = new JPanel();
        topJPanel.setLayout(new BoxLayout(topJPanel, BoxLayout.Y_AXIS));

        JPanel topBackJPanel = new JPanel();
        topBackJPanel.setLayout(new BoxLayout(topBackJPanel, BoxLayout.X_AXIS));
        topBackJPanel.add(btnBack);
        topBackJPanel.add(Box.createHorizontalGlue());

        topJPanel.add(topBackJPanel);
        topJPanel.add(Box.createVerticalStrut(10));
        topJPanel.add(titleJLabel);
    }

    private void CreateMiddleJPanel() {
        middleJPanel = new JPanel();
        middleJPanel.setLayout(new BoxLayout(middleJPanel, BoxLayout.Y_AXIS));

        JPanel barJPanel = new JPanel();
        barJPanel.setLayout(new BoxLayout(barJPanel, BoxLayout.X_AXIS));
        barJPanel.add(comName);
        barJPanel.add(aptNo);
        barJPanel.add(Box.createHorizontalStrut(80));

        JPanel btnJPanel = new JPanel();
        btnJPanel.setLayout(new BoxLayout(btnJPanel, BoxLayout.X_AXIS));
        btnJPanel.add(Box.createHorizontalStrut(180));
        btnJPanel.add(btnCart);

//        barJPanel.add(Box.createHorizontalStrut(80));
//        barJPanel.add(btnCart);

        tableMenu = new JTable(tableModelMenu);
        tableMenu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPaneMenu = new JScrollPane(tableMenu);
        scrollPaneMenu.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        tableCart = new JTable(tableModelCart);
        tableCart.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPaneCart = new JScrollPane(tableCart);
        scrollPaneCart.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel cartJPanel = new JPanel();
        cartJPanel.setLayout(new BoxLayout(cartJPanel, BoxLayout.X_AXIS));
        cartJPanel.add(titleCart);
        cartJPanel.add(Box.createHorizontalGlue());


        middleJPanel.add(Box.createVerticalStrut(20));
        middleJPanel.add(scrollPaneMenu);
        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(barJPanel);
        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(btnJPanel);
        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(cartJPanel);
        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(scrollPaneCart);
        middleJPanel.add(Box.createVerticalStrut(10));

    }

    private void CreateBottomJPanel() {
        bottomJPanel = new JPanel();
        bottomJPanel.setLayout(new BoxLayout(bottomJPanel, BoxLayout.Y_AXIS));

        JPanel btnJPanel = new JPanel(new GridLayout(1, 2, 25, 50));
//        btnJPanel.add(btnUpdate);
        btnJPanel.add(btnDelete);
        btnJPanel.add(btnConfirm);

        bottomJPanel.add(Box.createVerticalStrut(10));
        bottomJPanel.add(btnJPanel);
    }

    public Frame getFrame() {
        return jFrame;
    }

    public static void main(String[] args) {
        new residentManagement();
    }
}
