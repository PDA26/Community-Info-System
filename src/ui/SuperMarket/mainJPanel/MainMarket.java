package ui.SuperMarket.mainJPanel;

import model.SuperMarket.SuperMarket;
import ui.Main;
import ui.SuperMarket.viewMenu.ViewItemMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMarket {

    private final ViewItemMenu viewItemMenu;
    /**
     * components
     */
    //logo of supermarket
    private JLabel logoOfSuperMarket;
//    ImageIcon imagePath = new ImageIcon("src/resources/logoOfMarket/logo of Walmart.jpg");
    ImageIcon imagePath = new ImageIcon("src/resources/logoOfMarket/logo of Walmart.jpg");

    private JPanel mainMarketJPanel;
    private JButton viewItemMenuButton;
    private JButton viewOrderButton;
    private JButton backToMainButton;

    private SuperMarket currentSuperMarket;

    public MainMarket() {

        setLogo();

        viewItemMenu = new ViewItemMenu();
        Main.addPanel(viewItemMenu.getPanel(), "ViewItemMenu");
        viewItemMenuButton.addActionListener(e -> {
            viewItemMenu.setCurrentWarehouse(currentSuperMarket.getWh());
            Main.gotoPanel("ViewItemMenu");
        });

        viewOrderButton.addActionListener(e -> {

        });

        backToMainButton.addActionListener(e -> Main.gotoPanel("Login"));

    }

    public JPanel getPanel() {
        return mainMarketJPanel;
    }

    public void setLogo() {

        imagePath.setImage(imagePath.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        logoOfSuperMarket.setIcon(imagePath);
        logoOfSuperMarket.setSize(100, 100);

    }

    public void setCurrentSuperMarket(SuperMarket currentSuperMarket) {
        this.currentSuperMarket = currentSuperMarket;
    }
}
