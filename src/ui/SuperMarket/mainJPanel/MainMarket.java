package ui.SuperMarket.mainJPanel;

import model.CommunityData.CommunityModel;
import model.OrderData.CommunityOrderCatalog;
import model.OrderData.Order;
import model.SuperMarket.SuperMarket;
import ui.Main;
import ui.SuperMarket.viewMenu.ViewItemMenu;
import ui.SuperMarket.viewOrder.ViewOrder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainMarket {

    private ViewItemMenu viewItemMenu;
    private ViewOrder viewOrder;
    /**
     * components
     */
    //logo of supermarket
    private JLabel logoOfSuperMarket;
    ImageIcon imagePath = new ImageIcon("src/resources/logoOfMarket/logo of Walmart.jpg");

    private JPanel mainMarketJPanel;
    private JButton viewItemMenuButton;
    private JButton viewOrderButton;
    private JButton backToMainButton;

    private SuperMarket currentSuperMarket;

    public MainMarket() {

        setLogo();
        //TODO
        currentSuperMarket = SuperMarket.getInstance();

        viewItemMenu = new ViewItemMenu();
        Main.addPanel(viewItemMenu.getPanel(), "ViewItemMenu");
        viewItemMenuButton.addActionListener(e -> {
            viewItemMenu.setCurrentWarehouse(currentSuperMarket.getWh());
            Main.gotoPanel("ViewItemMenu");
        });


        viewOrderButton.addActionListener(e -> {
            //TODO view all orders in this market

//            CommunityModel communityModel = CommunityModel.getInstance();


            viewOrder = new ViewOrder();
            Main.addPanel(viewOrder.getPanel(), "ViewOrder");

            //viewOrder.setCurrentOrderCenter(currentSuperMarket.getOc());
            Main.gotoPanel("ViewOrder");
        });

        backToMainButton.addActionListener(e -> Main.gotoPanel("SignIn"));

    }

    public JPanel getPanel() {
        return mainMarketJPanel;
    }

    public void setLogo() {

        imagePath.setImage(imagePath.getImage().getScaledInstance(480, 270, Image.SCALE_DEFAULT));
        logoOfSuperMarket.setIcon(imagePath);
        // logoOfSuperMarket.setSize(100, 100);

    }

    public void setCurrentSuperMarket(SuperMarket currentSuperMarket) {
        this.currentSuperMarket = currentSuperMarket;
    }

}
