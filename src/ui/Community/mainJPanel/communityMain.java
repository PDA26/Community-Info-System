package ui.Community.mainJPanel;

import model.CommunityData.CommunityInfo;
import ui.Community.communityView.communityManagement.CommunityManagement;
import ui.Community.residentView.ResidentManagement;
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
    private JLabel imgJLabel;


    //CommunityModel communitiesDir;
    //CommunityInfo communityInfo;

    ImageIcon logoIcon = new ImageIcon(new ImageIcon("src/ui/Community/img/ad.png").getImage().getScaledInstance(400, 300, Image.SCALE_AREA_AVERAGING));


    CommunityModel communityModel = CommunityModel.getInstance();
    //Vector<String> communityName = new Vector<>();

    public communityMain() {

        imgJLabel.setIcon(logoIcon);
        imgJLabel.setSize(100, 100);

        btnBack.setSize(10, 5);
        btnToRes.setSize(10, 5);
        btnToCom.setSize(10, 5);
        btnAdd.setSize(10, 5);

        btnAdd.addActionListener(actionEvent -> {
            CommunityInfo c = AddCommunity.showCommunityAdd(panelCommunityMain, null);
            if(c != null){
                ArrayList<String> names = new ArrayList<String>();

                for (CommunityInfo communityInfo: communityModel.getCommunities()) {
                    names.add(communityInfo.getCommunityName());
                }
                comboCommunity.addItem(names.get(names.size()-1));
            }
        });

        CommunityManagement communityManagement = new CommunityManagement();
        Main.addPanel(communityManagement.getPanel(), "CommunityManagement");
        btnToCom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String index = (String) comboCommunity.getSelectedItem();

                if (index!=null) {
//                  String name = communityName.get(index);
                    communityModel.setCurrentCommunity(index);

                    Main.gotoPanel("CommunityManagement");
                }
                else {
                    JOptionPane.showMessageDialog(panelCommunityMain, "Please select a community!");
                }
            }
        });
        ResidentManagement residentManagement = new ResidentManagement();
        Main.addPanel(residentManagement.getPanel(), "ResidentManagement");
        btnToRes.addActionListener(e -> Main.gotoPanel("ResidentManagement"));

        btnBack.addActionListener(e -> Main.gotoPanel("SignIn"));

    }

    public JPanel getPanel() {
        return panelCommunityMain;
    }

    public static void main(String[] args) {
        new communityMain();
    }
}
