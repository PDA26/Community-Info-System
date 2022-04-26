package ui.Community;

import model.CommunityInfo;
import model.Resident;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addCommunity {

    CommunityInfo communityInfo;

    public CommunityInfo getCommunityInfo() {
        String name = txtName.getText();
        String address = txtAdd.getText();
        String zipcode = txtZip.getText();
        String phone = txtPhone.getText();

        communityInfo.setCommunityName(name);
        communityInfo.setCommunityAdd(address);
        communityInfo.setCommunityZip(zipcode);
        communityInfo.setCommunityPhone(phone);

        return communityInfo;
    }

    private JPanel topJPanel;
    private JPanel middleJPanel;
    private JPanel bottomJPanel;
    private JPanel JPanelContent;
    JFrame jFrame = new JFrame();

    JButton btnAdd = new JButton("Add");
    JLabel titleJLabel = new JLabel("Please Add New Community!");
    JTextField txtName = new JTextField();
    JTextField txtAdd = new JTextField();
    JTextField txtZip = new JTextField();
    JTextField txtPhone = new JTextField();
    JLabel lblName = new JLabel("Community Name:");
    JLabel lblAdd = new JLabel("Community Address:");
    JLabel lblZipcode= new JLabel("Community Zipcode:");
    JLabel lblPhone = new JLabel("Community Contact Phone:");

//    public static CommunityInfo showCommunityInfo(Component parent, CommunityInfo communityInfo) {
//        String name = txtName.getText();
//        String address = txtAdd.getText();
//        String zipcode = txtZip.getText();
//        String phone = txtPhone.getText();
//
//        communityInfo.setCommunityName(name);
//        communityInfo.setCommunityAdd(address);
//        communityInfo.setCommunityZip(zipcode);
//        communityInfo.setCommunityPhone(phone);
//    }


    public addCommunity() {
        setStyle();
        InitData();
        InitView();

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                String name = txtName.getText();
//                String address = txtAdd.getText();
//                String zipcode = txtZip.getText();
//                String phone = txtPhone.getText();

                getCommunityInfo();

                jFrame.setVisible(false);
                JPanelContent.add("CommunityMain", new ui.Community.communityMain().getFrame());
                ((CardLayout) JPanelContent.getLayout()).show(JPanelContent, "CommunityMain");
//                jFrame.setVisible(false);
            }
        });

    }

    private void InitData() {
    }

    private void InitView() {
        CreateTopJPanel();
        CreateMiddleJPanel();
        CreateBottomJPanel();

        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new GridBagLayout());

        GridBagConstraints constraintsForTop = new GridBagConstraints();
        constraintsForTop.gridx = 0;
        constraintsForTop.gridy = 0;
        constraintsForTop.weightx = 1;
        constraintsForTop.weighty = 0;
        constraintsForTop.fill = GridBagConstraints.CENTER;
        panelContainer.add(topJPanel, constraintsForTop);

        GridBagConstraints constraintsForMiddle = new GridBagConstraints();
        constraintsForMiddle.gridx = 0;
        constraintsForMiddle.gridy = 1;
        constraintsForMiddle.weightx = 0;
        constraintsForMiddle.weighty = 0;
        constraintsForMiddle.fill = GridBagConstraints.CENTER;
        panelContainer.add(middleJPanel, constraintsForMiddle);

        GridBagConstraints constraintsForBottom = new GridBagConstraints();
        constraintsForBottom.gridx = 0;
        constraintsForBottom.gridy = 2;
        constraintsForBottom.weightx = 1;
        constraintsForBottom.weighty = 0;
        constraintsForBottom.fill = GridBagConstraints.CENTER;
        panelContainer.add(bottomJPanel, constraintsForBottom);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelContainer.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelContainer);
    }

    private void setStyle() {
        Font font_title = new Font(Font.SERIF, Font.PLAIN, 24);
        titleJLabel.setFont(font_title);
    }

    private void CreateTopJPanel() {
        topJPanel = new JPanel();
        topJPanel.setLayout(new BoxLayout(topJPanel, BoxLayout.Y_AXIS));

        topJPanel.add(Box.createVerticalStrut(10));
        topJPanel.add(titleJLabel);
        topJPanel.add(Box.createVerticalStrut(30));
    }

    private void CreateMiddleJPanel() {
        middleJPanel = new JPanel();
        middleJPanel.setLayout(new BoxLayout(middleJPanel, BoxLayout.Y_AXIS));

        JPanel midJPanel = new JPanel(new GridLayout(4, 2, 25, 50));
        midJPanel.add(lblName);
        midJPanel.add(txtName);
        midJPanel.add(lblAdd);
        midJPanel.add(txtAdd);
        midJPanel.add(lblZipcode);
        midJPanel.add(txtZip);
        midJPanel.add(lblPhone);
        midJPanel.add(txtPhone);

        middleJPanel.add(midJPanel);
    }

    private void CreateBottomJPanel() {
        bottomJPanel = new JPanel();
        bottomJPanel.setLayout(new BoxLayout(bottomJPanel, BoxLayout.Y_AXIS));

        bottomJPanel.add(Box.createVerticalStrut(10));
        bottomJPanel.add(btnAdd);
        bottomJPanel.add(Box.createVerticalStrut(10));
    }

    public JFrame getFrame() {
        return jFrame;
    }

    public static void main(String[] args) {

        new addCommunity();
    }
}
