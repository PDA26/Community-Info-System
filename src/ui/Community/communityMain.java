package ui.Community;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class communityMain extends JPanel{

    /**
     * Define Components
     */

    private JPanel topJPanel;
    private JPanel middleJPanel;
    private JPanel bottomJPanel;
    private JPanel JPanelContent;
    JFrame jFrame = new JFrame();

    JLabel titleJLabel = new JLabel("Welcome to Community Manage Interface!");
    JLabel imgJLabel = new JLabel();
    JLabel chooseLabel = new JLabel("Choose a community:");
    JButton btnAdd = new JButton("Add a Community");
    JButton btnChoose = new JButton("160 Pleasant");
    JButton btnToCom = new JButton("Manager");
    JButton btnToRes = new JButton("Resident");
    JButton btnBack = new JButton("Back to Main");



    public communityMain() {
        setStyle();
        InitData();
        InitView();

        btnToCom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                JPanelContent.add("CommunityManagement", new ui.Community.communityManagement().getFrame());
                ((CardLayout) JPanelContent.getLayout()).show(JPanelContent, "communityManagement");
//                jFrame.setVisible(false);
            }
        });

        btnToRes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                JPanelContent.add("ResidentManagement", new ui.Community.residentManagement().getFrame());
                ((CardLayout) JPanelContent.getLayout()).show(JPanelContent, "ResidentManagement");
//                jFrame.setVisible(false);
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                JPanelContent.add("AddCommunity", new ui.Community.addCommunity().getFrame());
                ((CardLayout) JPanelContent.getLayout()).show(JPanelContent, "AddCommunity");
//                jFrame.setVisible(false);
            }
        });
    }

    private void setStyle() {
        ImageIcon logoIcon = new ImageIcon(new ImageIcon("src/ui/Community/img/ad.png").getImage().getScaledInstance(400, 300, Image.SCALE_AREA_AVERAGING));
        imgJLabel.setIcon(logoIcon);

        Font font_title = new Font(Font.SERIF, Font.PLAIN, 24);
        titleJLabel.setFont(font_title);

        Font font_choose = new Font(Font.SERIF, Font.PLAIN, 16);
        chooseLabel.setFont(font_choose);

        Font font_button = new Font(Font.SERIF, Font.PLAIN, 14);
        btnAdd.setFont(font_button);
        btnChoose.setFont(font_button);
        btnToCom.setFont(font_button);
        btnToRes.setFont(font_button);
        btnBack.setFont(font_button);

        btnToCom.setSize(new Dimension(10,5));

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
        constraintsForBottom.fill = GridBagConstraints.HORIZONTAL;
        panelContainer.add(bottomJPanel, constraintsForBottom);


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        panelContainer.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelContainer);

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
        middleJPanel.setLayout(new BoxLayout(middleJPanel, BoxLayout.X_AXIS));

        JPanel leftJPanel = new JPanel();
        leftJPanel.setLayout(new BoxLayout(leftJPanel, BoxLayout.X_AXIS));
        leftJPanel.add(imgJLabel);
        leftJPanel.add(Box.createHorizontalStrut(30));

        JPanel rightChooseJPanel = new JPanel();
        rightChooseJPanel.setLayout(new BoxLayout(rightChooseJPanel, BoxLayout.X_AXIS));
        rightChooseJPanel.add(chooseLabel);
        rightChooseJPanel.add(Box.createHorizontalStrut(10));
        rightChooseJPanel.add(btnChoose);
        rightChooseJPanel.add(Box.createHorizontalStrut(10));

        JPanel rightAddJPanel = new JPanel(new GridLayout(3, 1, 25, 50));
        rightAddJPanel.add(btnAdd);
        rightAddJPanel.add(btnToCom);
        rightAddJPanel.add(btnToRes);

        JPanel rightJPanel = new JPanel();
        rightJPanel.setLayout(new BoxLayout(rightJPanel, BoxLayout.Y_AXIS));
        rightJPanel.add(Box.createVerticalStrut(10));
        rightJPanel.add(rightChooseJPanel);
        rightJPanel.add(Box.createRigidArea(new Dimension(10, 60)));
        rightJPanel.add(rightAddJPanel);
        rightJPanel.add(Box.createHorizontalStrut(10));

        middleJPanel.add(leftJPanel);
        middleJPanel.add(rightJPanel);
    }

    private void CreateBottomJPanel() {
        bottomJPanel = new JPanel();
        bottomJPanel.setLayout(new BoxLayout(bottomJPanel, BoxLayout.Y_AXIS));

        JPanel blankJPanel = new JPanel();
        blankJPanel.add(Box.createVerticalStrut(20));

        JPanel contentJPanel = new JPanel();
        contentJPanel.setLayout(new BoxLayout(contentJPanel, BoxLayout.X_AXIS));
        contentJPanel.add(Box.createHorizontalGlue());
        contentJPanel.add(btnBack);
        contentJPanel.add(Box.createHorizontalStrut(50));

        bottomJPanel.add(blankJPanel);
        bottomJPanel.add(contentJPanel);
    }

    public Frame getFrame() {
        return jFrame;
    }

    public static void main(String[] args) {
        new communityMain();
    }

}
