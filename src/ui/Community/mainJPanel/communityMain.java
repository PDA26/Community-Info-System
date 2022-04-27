package ui.Community.mainJPanel;

import model.CommunityData.Communities;
import model.CommunityInfo;
import ui.Community.communityView.communityEditor.addCommunity;
import ui.Community.communityView.communityManagement.communityManagement;
import ui.Community.residentView.residentManagement;
import ui.Login;
import model.CommunityData.CommunityModel;
import ui.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;


public class communityMain {

    private JComboBox<String> comboCommunity;
    private JButton btnAdd;
    private JButton btnToRes;
    private JButton btnToCom;
    private JButton btnBack;
    private JPanel panelCommunityMain;
    JLabel imgJLabel;


    Communities communitiesDir;
    CommunityInfo communityInfo;

//    ImageIcon logoIcon = new ImageIcon(new ImageIcon("src/ui/Community/img/ad.png").getImage().getScaledInstance(400, 300, Image.SCALE_AREA_AVERAGING));
//    imgJLabel.setIcon(logoIcon);

    CommunityModel communityModel = CommunityModel.getInstance();
    Vector<String> communityName = new Vector<>();

    public communityMain() {

        // panelCommunityMain.setOpaque(true);

//        panelContent.add("communityManagement", new communityManagement().getPanel());

        btnAdd.addActionListener(actionEvent -> {
            CommunityInfo c = addCommunity.showCommunityAdd(panelCommunityMain, null);
            if(c != null){
                ArrayList<String> names = new ArrayList<String>();

                for (CommunityInfo communityInfo: communityModel.getCommunities()) {
                    names.add(communityInfo.getCommunityName());
                }
                comboCommunity.addItem(names.get(names.size()-1));
            }
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



        Main.addPanel(new communityManagement().getPanel(), "communityManagement");
        btnToCom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String index = (String) comboCommunity.getSelectedItem();

                if (index!=null) {
//                  String name = communityName.get(index);
                    communityModel.setCurrentCommunity(index);

                    Main.gotoPanel("communityManagement");
                }
                else {
                    JOptionPane.showMessageDialog(panelCommunityMain, "Please select a community!");
                }
            }
        });

        Main.addPanel(new residentManagement().getPanel(), "residentManagement");
        btnToRes.addActionListener(e -> Main.gotoPanel("residentManagement"));

        btnBack.addActionListener(e -> Main.gotoPanel("Login"));

    }

    public JPanel getPanel() {
        return panelCommunityMain;
    }
}
