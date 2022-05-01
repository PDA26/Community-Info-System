package ui.SuperMarket.codeVersionUI_ignore_it.mainJPanel_Code;

import ui.SuperMarket.codeVersionUI_ignore_it.MainProcess;
import ui.SuperMarket.codeVersionUI_ignore_it.viewItemMenu_Code.ViewItemMenuJPanel;
import ui.SuperMarket.codeVersionUI_ignore_it.viewOrder_Code.ViewOrdersJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarketMainJPanel extends JPanel{

    /**
     * components
     */
    private static JPanel topJPanel;
    private static JPanel middleJPanel;
    private static JPanel bottomJPanel;

    private JLabel titleJLabel = new JLabel("Welcome to Market Manage Interface!");
    JLabel logoOfSupermarket = new JLabel();
    ImageIcon imagePath = new ImageIcon("src/resources/logoOfMarket/logo of Walmart.jpg");

    JButton viewMenuJButton = new JButton("View Menu");
    JButton viewOrdersJButton = new JButton("View Orders");
    JButton backToMainJButton = new JButton("Back to Main >>");

    public MarketMainJPanel() {

        InitData();
        InitViews();

    }

    private void InitData() {

    }

    private void InitViews() {

        createTopPanel();
        createMiddleJPanel();
        createBottomJPanel();

        setLayout(new GridBagLayout());

        GridBagConstraints constraintsForTop = new GridBagConstraints();
        constraintsForTop.gridx = 0;
        constraintsForTop.gridy = 0;
        constraintsForTop.weightx = 0;
        constraintsForTop.weighty = 0;
        constraintsForTop.fill = GridBagConstraints.CENTER;
        add(topJPanel, constraintsForTop);

        GridBagConstraints constraintsForMiddle = new GridBagConstraints();
        constraintsForMiddle.gridx = 0;
        constraintsForMiddle.gridy = 1;
        constraintsForMiddle.weightx = 1.0;
        constraintsForMiddle.weighty = 0;
        constraintsForMiddle.fill = GridBagConstraints.CENTER;
        add(middleJPanel, constraintsForMiddle);

        GridBagConstraints constraintsForBottom = new GridBagConstraints();
        constraintsForBottom.gridx = 0;
        constraintsForBottom.gridy = 2;
        constraintsForBottom.weightx = 1.0;
        constraintsForBottom.weighty = 0;
        constraintsForBottom.fill = GridBagConstraints.HORIZONTAL;
        add(bottomJPanel, constraintsForBottom);

        viewMenuJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainProcess.getInstance().changeFrame(new ViewItemMenuJPanel());
            }
        });

        viewOrdersJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainProcess.getInstance().changeFrame(new ViewOrdersJPanel());
            }
        });

    }

    private void createTopPanel() {

        topJPanel = new JPanel();
        topJPanel.setLayout(new BoxLayout(topJPanel, BoxLayout.Y_AXIS));

        topJPanel.add(Box.createVerticalStrut(10));
        topJPanel.add(titleJLabel);
        topJPanel.add(Box.createVerticalStrut(10));

    }

    private void createMiddleJPanel() {

        imagePath.setImage(imagePath.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        logoOfSupermarket.setIcon(imagePath);
        logoOfSupermarket.setSize(100, 100);

        middleJPanel = new JPanel();
        middleJPanel.setLayout(new BoxLayout(middleJPanel, BoxLayout.X_AXIS));

        JPanel leftJPanel = new JPanel();
        leftJPanel.setLayout(new BoxLayout(leftJPanel, BoxLayout.X_AXIS));
        leftJPanel.add(logoOfSupermarket);

        JPanel rightJPanel = new JPanel();
        rightJPanel.setLayout(new BoxLayout(rightJPanel, BoxLayout.Y_AXIS));
        rightJPanel.add(viewMenuJButton);
        rightJPanel.add(Box.createRigidArea(new Dimension(15, 60)));
        rightJPanel.add(viewOrdersJButton);

        middleJPanel.add(leftJPanel);
        middleJPanel.add(Box.createHorizontalStrut(60));
        middleJPanel.add(rightJPanel);

    }

    private void createBottomJPanel() {

        bottomJPanel = new JPanel();
        bottomJPanel.setLayout(new BoxLayout(bottomJPanel, BoxLayout.Y_AXIS));

        JPanel contentJPanel = new JPanel();
        contentJPanel.setLayout(new BoxLayout(contentJPanel, BoxLayout.X_AXIS));

        contentJPanel.add(Box.createHorizontalGlue());
        contentJPanel.add(backToMainJButton);

        bottomJPanel.add(Box.createVerticalStrut(10));
        bottomJPanel.add(contentJPanel);
        bottomJPanel.add(Box.createVerticalStrut(10));

    }

    public static void main(String[] args) {
       //new MarketMainJPanel();
    }

}
