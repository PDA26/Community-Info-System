package ui.Community.mainJPanel;

import model.CommunityData.Communities;
import model.CommunityInfo;
import ui.Community.communityView.communityEditor.addCommunity;
import ui.Community.communityView.communityManagement.communityManagement;
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
    Communities communitiesDir;

    JLabel imgJLabel = new JLabel();
    private JPanel panelContent;

    CommunityInfo communityInfo;

//    ImageIcon logoIcon = new ImageIcon(new ImageIcon("src/ui/Community/img/ad.png").getImage().getScaledInstance(400, 300, Image.SCALE_AREA_AVERAGING));
//    imgJLabel.setIcon(logoIcon);

    CommunityModel communityModel = CommunityModel.getInstance();
    Vector<String> communityName = new Vector<>();

    public communityMain() {

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelCommunityMain.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelCommunityMain);

        btnAdd.addActionListener(actionEvent -> {
            CommunityInfo c = addCommunity.showCommunityAdd(null, communityInfo);
            ArrayList<String> names = new ArrayList<String>();

            for (CommunityInfo communityInfo: communityModel.getCommunities()) {
                names.add(communityInfo.getCommunityName());
            }

            comboCommunity.addItem(names.get(names.size()-1));
        });

        btnToCom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCommunityMain.add("communityManagement", new communityManagement().getPanel());
                ((CardLayout) panelCommunityMain.getLayout()).show(panelCommunityMain, "communityManagement");
            }
        });
    }

    public static void main(String[] args) {
        new communityMain();

    }

}
