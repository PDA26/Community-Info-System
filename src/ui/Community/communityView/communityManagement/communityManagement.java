package ui.Community.communityView.communityManagement;

import model.Apartment;
import model.CommunityData.CommunityModel;
import model.CommunityInfo;
import model.SuperMarket.orderCenter.OrderCatalog;
import model.OrderData.AptOrderCatalog;
import ui.Community.mainJPanel.communityMain;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import ui.Community.communityView.communityOrder.communityOrders;
import ui.Community.communityView.communityOrder.orderDetail;

public class communityManagement extends JPanel {


    private JButton btnBack;
    private JTable tableApt;
    private JButton btnViewDetails;
    private JButton btnConfirm;
    private JButton btnViewOrders;
    private JPanel panelCommunityManagement;
    private JLabel labelShowName;

    JFrame jFrame = new JFrame();
    //TODO
    Apartment apartment = new Apartment();

    private List<String> titlesOrder;
    private List<Object> dataOrder;
    DefaultTableModel tableModelOrder;


    public communityManagement() {

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelCommunityManagement.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelCommunityManagement);

        CommunityModel communityModel = CommunityModel.getInstance();
        String currentName = "";
        if(communityModel.getCurrentCommunity() != null)
            currentName = communityModel.getCurrentCommunity().getCommunityName();
        labelShowName.setText(currentName);

        CommunityInfo currentCommunity;
        currentCommunity = communityModel.getCurrentCommunity();

        this.titlesOrder = new ArrayList<>();
        this.dataOrder = new ArrayList<>();

        titlesOrder.add("Apt No.");
        titlesOrder.add("Order Time");
        String[] columnNames = { "Apt No.", "Order Time" };
        //TODO
        String apt = apartment.getAptNo();
        String time = apartment.getOrderTime();
        Object[][] rowData = { {apt}, {time} };
        tableModelOrder = new DefaultTableModel(rowData, columnNames);
        tableApt = new JTable(rowData, columnNames);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                Component communityMain = panelCommunityManagement.add("communityMain", new communityMain().getFrame());
                ((CardLayout) panelCommunityManagement.getLayout()).show(panelCommunityManagement, "communityMain");
            }
        });

        btnViewDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                Component orderDetails = panelCommunityManagement.add("orderDetails", new orderDetail().getFrame());
                ((CardLayout) panelCommunityManagement.getLayout()).show(panelCommunityManagement, "orderDetails");
            }
        });

        btnViewOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                Component orders = panelCommunityManagement.add("orders", new communityOrders().getFrame());
                ((CardLayout) panelCommunityManagement.getLayout()).show(panelCommunityManagement, "orders");
            }
        });

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshData();
                AptOrderCatalog aptOrderCatalog = new AptOrderCatalog();
                OrderCatalog orderCatalog = new OrderCatalog();
                String Apt = apartment.getAptNo();
                OrderCatalog.addOrder(Apt, OrderCatalog.getInstance().getCurrentOrder());
                JOptionPane.showMessageDialog(communityManagement.this, "Successfully confirmed!");
            }
        });

    }

    private void refreshData() {
        dataOrder.clear();
    }

    public JPanel getPanel() {
        return panelCommunityManagement;
    }

    public JFrame getFrame() {
        return jFrame;
    }



    public static void main(String[] args) {
        new communityManagement();
    }
}
