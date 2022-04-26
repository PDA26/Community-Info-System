package ui;

import sun.awt.OSInfo;

import javax.swing.*;
import java.awt.*;
import java.security.AccessController;

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

        Login login = new Login();
        frame.add(login.getPanel(), "Login");
        gotoPanel("Login");

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
