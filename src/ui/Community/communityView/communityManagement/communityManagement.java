package ui.Community;

import javax.swing.*;
import java.awt.*;

public class communityManagement {


    private JButton btnBack;
    private JTable tableApt;
    private JButton btnViewDetails;
    private JButton btnConfirm;
    private JButton btnViewOrders;
    private JLabel labelName;
    private JPanel panelCommunityManagement;

    public communityManagement() {

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelCommunityManagement.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelCommunityManagement);

    }

    public JPanel getPanel() {
        return panelCommunityManagement;
    }



    public static void main(String[] args) {
        new communityManagement();
    }
}
