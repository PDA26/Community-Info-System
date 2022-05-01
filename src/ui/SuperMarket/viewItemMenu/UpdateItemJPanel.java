package ui.SuperMarket.viewItemMenu;

import ui.SuperMarket.MainProcess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateItemJPanel extends JPanel{

    /**
     * data
     */

    /**
     * components
     */
    private JPanel topJPanel;
    private JPanel middleJPanel;
    private JPanel bottomJPanel;

    JButton backJButton = new JButton("<< Back");
    JLabel titleJLabel         = new JLabel("Update Item Profile");
    JLabel nameJLabel          = new JLabel("  Item Name: ");
    JLabel priceJLabel         = new JLabel("      Price: ");
    JLabel modifiedDateJLabel  = new JLabel("Update time: ");
    JLabel quantityJLabel      = new JLabel("   Quantity: ");
    JLabel itemStatusJLabel    = new JLabel("Item Status: ");
    JTextField nameField = new JTextField(20);
    JTextField priceField = new JTextField(20);
    JTextField updateTimeField = new JTextField(20);
    JTextField quantityField = new JTextField(20);
    JComboBox itemStatusComboBox = new JComboBox();
    JButton addJButton = new JButton("Update");

    public UpdateItemJPanel() {

        InitData();
        InitView();

    }

    private void InitData() {

    }

    private void InitView() {

        CreateTopJPanel();
        CreateMiddleJPanel();
        CreateBottomJPanel();

        setLayout(new GridBagLayout());

        GridBagConstraints constraintsForTop = new GridBagConstraints();
        constraintsForTop.gridx = 0;
        constraintsForTop.gridy = 0;
        constraintsForTop.weightx = 0;
        constraintsForTop.weighty = 0;
        constraintsForTop.fill = GridBagConstraints.HORIZONTAL;
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
        constraintsForBottom.fill = GridBagConstraints.CENTER;
        add(bottomJPanel, constraintsForBottom);

        backJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainProcess.getInstance().changeFrame(new ViewItemMenuJPanel());
            }
        });

    }

    private void CreateTopJPanel() {

        topJPanel = new JPanel();
        topJPanel.setLayout(new BoxLayout(topJPanel, BoxLayout.Y_AXIS));

        topJPanel.add(Box.createVerticalStrut(10));
        topJPanel.add(backJButton);
        topJPanel.add(Box.createVerticalStrut(10));

    }

    private void CreateMiddleJPanel() {

        middleJPanel = new JPanel();
        middleJPanel.setLayout(new BoxLayout(middleJPanel, BoxLayout.Y_AXIS));

        JPanel titleJPanel = new JPanel();
        titleJPanel.setLayout(new BoxLayout(titleJPanel, BoxLayout.X_AXIS));
        titleJPanel.add(titleJLabel);

        JPanel nameJPanel = new JPanel();
        nameJPanel.setLayout(new BoxLayout(nameJPanel, BoxLayout.X_AXIS));
        nameJPanel.add(nameJLabel);
        nameJPanel.add(Box.createHorizontalStrut(15));
        nameJPanel.add(nameField);

        JPanel priceJPanel = new JPanel();
        priceJPanel.setLayout(new BoxLayout(priceJPanel, BoxLayout.X_AXIS));
        priceJPanel.add(priceJLabel);
        priceJPanel.add(Box.createHorizontalStrut(15));
        priceJPanel.add(priceField);

        JPanel updateDateJPanel = new JPanel();
        updateDateJPanel.setLayout(new BoxLayout(updateDateJPanel, BoxLayout.X_AXIS));
        updateDateJPanel.add(modifiedDateJLabel);
        updateDateJPanel.add(Box.createHorizontalStrut(15));
        updateDateJPanel.add(updateTimeField);

        JPanel quantityJPanel = new JPanel();
        quantityJPanel.setLayout(new BoxLayout(quantityJPanel, BoxLayout.X_AXIS));
        quantityJPanel.add(quantityJLabel);
        quantityJPanel.add(Box.createHorizontalStrut(15));
        quantityJPanel.add(quantityField);

        JPanel statusJPanel = new JPanel();
        statusJPanel.setLayout(new BoxLayout(statusJPanel, BoxLayout.X_AXIS));
        itemStatusComboBox.addItem("- please select -");
        itemStatusComboBox.addItem("In Stock");
        itemStatusComboBox.addItem("Not In Stock");
        statusJPanel.add(itemStatusJLabel);
        statusJPanel.add(Box.createHorizontalStrut(15));
        statusJPanel.add(itemStatusComboBox);

        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(titleJPanel);
        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(nameJPanel);
        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(priceJPanel);
        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(updateDateJPanel);
        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(quantityJPanel);
        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(statusJPanel);

    }

    private void CreateBottomJPanel() {

        bottomJPanel = new JPanel();
        bottomJPanel.setLayout(new BoxLayout(bottomJPanel, BoxLayout.Y_AXIS));

        bottomJPanel.add(Box.createVerticalStrut(30));
        bottomJPanel.add(addJButton);

    }

    public static void main(String[] args) {
        new UpdateItemJPanel();
    }

}
