package ui.Community;

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

    JLabel imgJLabel = new JLabel();;

//    ImageIcon logoIcon = new ImageIcon(new ImageIcon("src/ui/Community/img/ad.png").getImage().getScaledInstance(400, 300, Image.SCALE_AREA_AVERAGING));
//    imgJLabel.setIcon(logoIcon);



    public communityMain() {


    }


//        ImageIcon logoIcon = new ImageIcon(new ImageIcon("src/ui/Community/img/ad.png").getImage().getScaledInstance(400, 300, Image.SCALE_AREA_AVERAGING));
//        imgJLabel.setIcon(logoIcon);



    public static void main(String[] args) {
        new communityMain();
    }

}
