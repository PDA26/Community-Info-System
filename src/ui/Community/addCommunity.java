package ui.Community;

import model.CommunityInfo;
import model.Resident;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addCommunity {

    private JTextField txtCommunityName;
    private JTextField txtCommunityAddress;
    private JTextField txtCommunityZipcode;
    private JTextField txtCommunityPhone;
    private JPanel panelAddCommunity;

    public static CommunityInfo showCommunityAdd(Component parent, CommunityInfo communityInfo) {
        addCommunity addCommunity = new addCommunity();
        String title = "Please Add New Community!!";

        addCommunity.txtCommunityName.setText(communityInfo.communityName);
        addCommunity.txtCommunityAddress.setText(communityInfo.communityAddress);
        addCommunity.txtCommunityZipcode.setText(communityInfo.communityZipcode);
        addCommunity.txtCommunityPhone.setText(communityInfo.communityPhone);

        int selection = JOptionPane.showConfirmDialog(parent,
                                    addCommunity.panelAddCommunity,
                                    title,
                                    JOptionPane.OK_CANCEL_OPTION,
                                    JOptionPane.PLAIN_MESSAGE);

        if (selection == JOptionPane.OK_OPTION) {

            String communityName = addCommunity.txtCommunityName.getText();
            String communityAddress = addCommunity.txtCommunityAddress.getText();
            String communityZipcode = addCommunity.txtCommunityZipcode.getText();
            String communityPhone = addCommunity.txtCommunityPhone.getText();

            if (communityName.isBlank()) {
                JOptionPane.showMessageDialog(addCommunity.panelAddCommunity, "Miss Community Name!");
                return null;
            }

            if (communityAddress.isBlank()) {
                JOptionPane.showMessageDialog(addCommunity.panelAddCommunity, "Miss Community Address!");
                return null;
            }

            if (communityZipcode.isBlank()) {
                JOptionPane.showMessageDialog(addCommunity.panelAddCommunity, "Miss Community Zipcode!");
                return null;
            }

            if (communityPhone.isBlank()) {
                JOptionPane.showMessageDialog(addCommunity.panelAddCommunity, "Miss Community Contact Phone!");
                return null;
            }

            communityInfo.communityName = communityName;
            communityInfo.communityAddress = communityAddress;
            communityInfo.communityZipcode = communityZipcode;
            communityInfo.communityPhone = communityPhone;

            return communityInfo;
        }
        else {
            return null;
        }

    }
}
