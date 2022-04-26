package ui.Community;

import model.CommunityInfo;
import ui.Main;
import ui.ResidentEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class communityMain extends JPanel{

    private JComboBox comboCommunity;
    private JButton btnAdd;
    private JButton btnToRes;
    private JButton btnToCom;
    private JButton btnBack;
    private JPanel panelCommunityMain;

    JLabel imgJLabel = new JLabel();
    private JPanel panelContent;

    private CommunityInfo communityInfo;

//    ImageIcon logoIcon = new ImageIcon(new ImageIcon("src/ui/Community/img/ad.png").getImage().getScaledInstance(400, 300, Image.SCALE_AREA_AVERAGING));
//    imgJLabel.setIcon(logoIcon);



    public communityMain() {
//        panelCommunityMain.add("addCommunity", new ui.Community.addCommunity().getPanel());

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelCommunityMain.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelCommunityMain);

        btnAdd.addActionListener(new ActionEvent -> {
            model.CommunityInfo p = addCommunity.showCommunityAdd(, null);
        });
//
//        addButton.addActionListener(actionEvent -> {
//            model.Resident p = ResidentEditor.showResidentEditor(tableResident, null);
//            if (p != null) {
//                residentDir.add(p);
//            }
//        });

//        btnBack.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                panelCommunityMain.add("main", new ui.Main().getPanel());
//                ((CardLayout) panelCommunityMain.getLayout()).show(panelCommunityMain, "main");
//            }
//        });

        btnToCom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCommunityMain.add("communityManagement", new ui.Community.communityManagement().getPanel());
                ((CardLayout) panelCommunityMain.getLayout()).show(panelCommunityMain, "communityManagement");
            }
        });

    }



//        ImageIcon logoIcon = new ImageIcon(new ImageIcon("src/ui/Community/img/ad.png").getImage().getScaledInstance(400, 300, Image.SCALE_AREA_AVERAGING));
//        imgJLabel.setIcon(logoIcon);



    public static void main(String[] args) {
        new communityMain();

    }

}
