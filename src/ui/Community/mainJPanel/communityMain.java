package ui.Community.mainJPanel;

import model.CommunityData.Communities;
import model.CommunityInfo;
import ui.Community.communityView.communityEditor.addCommunity;
import ui.Community.communityView.communityManagement.communityManagement;
import ui.Community.residentView.residentManagement;
import ui.Main;
import model.CommunityData.CommunityModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;


public class communityMain extends JPanel{

    private JComboBox<String> comboCommunity;
    private JButton btnAdd;
    private JButton btnToRes;
    private JButton btnToCom;
    private JButton btnBack;
    private JPanel panelCommunityMain;
    JLabel imgJLabel = new JLabel();
    private JPanel panelContent;

    JFrame jFrame = new JFrame("Community Main");

    Communities communitiesDir;
    CommunityInfo communityInfo;

//    ImageIcon logoIcon = new ImageIcon(new ImageIcon("src/ui/Community/img/ad.png").getImage().getScaledInstance(400, 300, Image.SCALE_AREA_AVERAGING));
//    imgJLabel.setIcon(logoIcon);

    CommunityModel communityModel = CommunityModel.getInstance();
    Vector<String> communityName = new Vector<>();

    public communityMain() {

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelCommunityMain.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelCommunityMain);

//        panelContent.add("communityManagement", new communityManagement().getPanel());

        btnAdd.addActionListener(actionEvent -> {
            CommunityInfo c = addCommunity.showCommunityAdd(null, communityInfo);
            ArrayList<String> names = new ArrayList<String>();

            for (CommunityInfo communityInfo: communityModel.getCommunities()) {
                names.add(communityInfo.getCommunityName());
            }
            comboCommunity.addItem(names.get(names.size()-1));
        });

//        System.out.println("test1");
//
//        ArrayList<String> names2 = new ArrayList<String>();
//        for (String i: names) {
//                names2.add(communityInfo.getCommunityName());
//                System.out.println("test2");
//        }
//
//        System.out.println("test3");



        btnToCom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String index = (String) comboCommunity.getSelectedItem();

                if (index!=null) {
//                    String name = communityName.get(index);
                    communityModel.setCurrentCommunity(index);

                    Component communityManagement = panelCommunityMain.add("communityManagement", new communityManagement().getFrame());
                    ((CardLayout) panelCommunityMain.getLayout()).show(panelCommunityMain, "communityManagement");
                }
                else {
                    JOptionPane.showMessageDialog(communityMain.this, "Please select a community!");
                }
            }
        });

        btnToRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component residentManagement = panelCommunityMain.add("residentManagement", new residentManagement().getFrame());
                ((CardLayout) panelCommunityMain.getLayout()).show(panelCommunityMain, "residentManagement");
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component main = panelCommunityMain.add("main", new Main().getFrame());
                ((CardLayout) panelCommunityMain.getLayout()).show(panelCommunityMain, "main");
            }
        });

    }

    public Frame getFrame() {
        return jFrame;
    }

    public static void main(String[] args) {
        new communityMain();

    }

}
