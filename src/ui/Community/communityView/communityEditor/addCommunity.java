package ui.Community.communityView.communityEditor;

import model.CommunityInfo;
import model.CommunityData.CommunityModel;

import javax.swing.*;
import java.awt.*;

public class addCommunity extends JPanel {

    private JTextField txtCommunityName;
    private JTextField txtCommunityAddress;
    private JTextField txtCommunityZipcode;
    private JTextField txtCommunityPhone;
    private JPanel panelAddCommunity;
    private JPanel panelContent;
//    private JButton btnBack;
//    private JButton btnConfirm;

    public JPanel getPanel() {
        return panelAddCommunity;
    }

    public addCommunity() {
//        JFrame jFrame = new JFrame();
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.setVisible(true);
//        panelAddCommunity.setOpaque(true);
//        jFrame.setSize(new Dimension(800, 800));
//        jFrame.setContentPane(panelAddCommunity);
    }

    public static CommunityInfo showCommunityAdd(Component parent, CommunityInfo communityInfo) {
        addCommunity addCommunity = new addCommunity();
        CommunityModel communityModel = CommunityModel.getInstance();
        String title = "Please Add New Community!!";

        int selection = JOptionPane.showConfirmDialog(parent,
                                    addCommunity.panelAddCommunity,
                                    title,
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.PLAIN_MESSAGE);

        if (selection == JOptionPane.OK_OPTION) {

            if (communityInfo==null) {
                communityInfo = new CommunityInfo();
            }

            String communityName = addCommunity.txtCommunityName.getText();
            String communityAddress = addCommunity.txtCommunityAddress.getText();
            String communityZipcode = addCommunity.txtCommunityZipcode.getText();
            String communityPhone = addCommunity.txtCommunityPhone.getText();

            if (communityName.isBlank()) {
                JOptionPane.showMessageDialog(addCommunity.panelAddCommunity, "Miss Community Name! Community not saved!");
                return null;
            }

            if (communityAddress.isBlank()) {
                JOptionPane.showMessageDialog(addCommunity.panelAddCommunity, "Miss Community Address! Community not saved!");
                return null;
            }

            if (communityZipcode.isBlank()) {
                JOptionPane.showMessageDialog(addCommunity.panelAddCommunity, "Miss Community Zipcode! Community not saved!");
                return null;
            }

            if (communityPhone.isBlank()) {
                JOptionPane.showMessageDialog(addCommunity.panelAddCommunity, "Miss Community Contact Phone! Community not saved!");
                return null;
            }

//            communityInfo.setCommunityName(communityName);
//            communityInfo.setCommunityAddress(communityAddress);
//            communityInfo.setCommunityZipcode(communityZipcode);
//            communityInfo.setCommunityPhone(communityPhone);

            communityInfo.communityName = communityName;
            communityInfo.communityAddress = communityAddress;
            communityInfo.communityZipcode = communityZipcode;
            communityInfo.communityPhone = communityPhone;
            communityModel.addNewCommunity(communityInfo);

            JOptionPane.showMessageDialog(addCommunity.panelAddCommunity, "Community Saved!");


        return communityInfo;
        }
        else {
            return null;
        }

    }

    public static void main(String[] args) {
        new addCommunity();
    }
}
