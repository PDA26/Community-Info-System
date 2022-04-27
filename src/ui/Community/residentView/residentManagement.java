package ui.Community.residentView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.Community.mainJPanel.communityMain;

public class residentManagement {


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

    public residentManagement() {

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelResidentManagement.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelResidentManagement);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component communityMain = panelResidentManagement.add("communityMain", new communityMain().getFrame());
                ((CardLayout) panelResidentManagement.getLayout()).show(panelResidentManagement, "communityMain");
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
