package ui;

import model.CommunityData.CommunityInfo;
import model.CommunityData.CommunityModel;
import model.Product;
import model.SuperMarket.SuperMarket;
import model.SuperMarket.wareHouse.Warehouse;
import sun.awt.OSInfo;

import javax.swing.*;
import java.awt.*;
import java.security.AccessController;
import java.util.List;

public class Main {

    private static final JFrame frame = new JFrame("Main");

    public static void main(String[] args) {
        try {
            OSInfo.OSType osType = AccessController.doPrivileged(OSInfo.getOSTypeAction());
            if (osType == OSInfo.OSType.WINDOWS) {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } else {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        frame.setLayout(new CardLayout());

        SuperMarket market = SuperMarket.getInstance();
        Warehouse wh = market.getWh();
        //String name, double price, String modifiedDate, int quantity, boolean isInStock
        Product p1 = new Product("Yoohoo", 2.1, "05/01/2019", 500, true);
        Product p2 = new Product("Oreo", 3.5, "04/13/2022", 234, true);
        Product p3 = new Product("Feoyo", 3, "03/31/2012", 34, true);
        Product p4 = new Product("Mug", 11, "05/01/2019", 56, true);
        Product p5 = new Product("iPhone", 500, "12/13/2016", 7, true);
        Product p6 = new Product("Huamei", 6.6, "11/01/2019", 65, true);
        Product p7 = new Product("Lighter", 7, "01/13/2022", 234, true);
        Product p8 = new Product("Towel", 12, "03/31/2012", 34, true);
        Product p9 = new Product("Coke", 4, "05/30/2021", 56, true);
        Product p10 = new Product("Noodle", 5, "09/14/2021", 7, true);
        Product p11 = new Product("Fires", 7, "08/16/2019", 65, true);
        wh.add(p1);
        wh.add(p2);
        wh.add(p3);
        wh.add(p4);
        wh.add(p5);
        wh.add(p6);
        wh.add(p7);
        wh.add(p8);
        wh.add(p9);
        wh.add(p10);
        wh.add(p11);
        //String communityName, String communityAddress, String communityZipcode, String communityPhone
        CommunityModel cm = CommunityModel.getInstance();
        CommunityInfo ci1 = new CommunityInfo("Community1", "30 Main St, Melrose, MA", "02176", "123456789");
        CommunityInfo ci2 = new CommunityInfo("Community2", "34 Palm St, Chelsea, MA", "02140", "765812234");
        CommunityInfo ci3 = new CommunityInfo("Community3", "71 Concord Road, malden, MA", "02155", "456729109");
        cm.addNewCommunity(ci1);
        cm.addNewCommunity(ci2);
        cm.addNewCommunity(ci3);
        ci1.addApt("101");
        ci1.addApt("102");
        ci1.addApt("103");
        ci2.addApt("101");
        ci2.addApt("102");
        ci2.addApt("103");
        ci3.addApt("101");
        ci3.addApt("102");
        ci3.addApt("103");
        //market.getOc().addSingleCommunity(cm)
        market.getOc().addAll(cm);

        SignIn signIn = new SignIn();
        frame.add(signIn.getPanel(), "SignIn");
        gotoPanel("SignIn");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void gotoPanel(String name) {
        ((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), name);
    }

    public static void addPanel(JComponent jComponent, String name) {
        frame.add(jComponent, name);
    }

    public static void setTitle(String title) {
        frame.setTitle(title);
    }
}
