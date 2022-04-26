package ui.SuperMarket.codeVersionUI_ignore_it.viewOrder_Code;

import ui.SuperMarket.codeVersionUI_ignore_it.MainProcess;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class ViewOrderDetailsJPanel extends JPanel{

    /**
     * data
     */

    /**
     * table
     */
    Vector<Object> titles;
    Vector<Vector<Object>> data;
    DefaultTableModel tableModel;

    /**
     * components
     */
    private static JPanel topJPanel;
    private static JPanel middleJPanel;
    private static JPanel bottomJPanel;

    JLabel titleJLabel = new JLabel("Order Details");
    JLabel communityNameJLabel = new JLabel("Community Name: ");
    JLabel communityName = new JLabel();
    JLabel orderTimeJLabel = new JLabel("Order Time: ");
    JLabel orderTime = new JLabel();
    JButton backToOrders = new JButton("<< Back to Orders Interface");
    JTable jTable;

    public ViewOrderDetailsJPanel() {

        InitData();
        InitViews();

    }

    private void InitData() {

        titles = new Vector<>();
        titles.add("Item Name");
        titles.add("Unit Price");
        titles.add("Quantity");
        titles.add("Price");

        data = new Vector<>();//目前还没有数据，之后还要改

        tableModel = new DefaultTableModel(data, titles);

    }

    private void InitViews() {

        CreateTopJPanel();
        CreateMiddleJPanel();
        CreateBottomJPanel();

        setLayout(new GridBagLayout());

        GridBagConstraints constraintsForTop = new GridBagConstraints();
        constraintsForTop.gridx = 0;
        constraintsForTop.gridy = 0;
        constraintsForTop.weightx = 0;
        constraintsForTop.weighty = 0;
        constraintsForTop.fill = GridBagConstraints.BOTH;
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

        backToOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainProcess.getInstance().changeFrame(new ViewOrdersJPanel());
            }
        });

    }

    private void CreateTopJPanel() {

        topJPanel = new JPanel();
        topJPanel.setLayout(new BoxLayout(topJPanel, BoxLayout.Y_AXIS));

        topJPanel.add(Box.createVerticalStrut(10));
        topJPanel.add(backToOrders);
        topJPanel.add(Box.createVerticalStrut(10));

    }

    private void CreateMiddleJPanel() {

        middleJPanel = new JPanel();
        middleJPanel.setLayout(new BoxLayout(middleJPanel, BoxLayout.Y_AXIS));

        JPanel upJPanel = new JPanel();
        upJPanel.setLayout(new BoxLayout(upJPanel, BoxLayout.X_AXIS));
        upJPanel.add(titleJLabel);

        JPanel downJPanel = new JPanel();
        downJPanel.setLayout(new BoxLayout(downJPanel, BoxLayout.X_AXIS));
        downJPanel.add(Box.createHorizontalStrut(10));
        downJPanel.add(communityNameJLabel);
        downJPanel.add(Box.createHorizontalStrut(5));
        downJPanel.add(communityName);
        downJPanel.add(Box.createHorizontalGlue());
        downJPanel.add(orderTimeJLabel);
        downJPanel.add(Box.createHorizontalStrut(5));
        downJPanel.add(orderTime);
        downJPanel.add(Box.createHorizontalStrut(10));

        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(upJPanel);
        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(downJPanel);
        middleJPanel.add(Box.createVerticalStrut(10));

    }

    private void CreateBottomJPanel() {

        bottomJPanel = new JPanel();
        bottomJPanel.setLayout(new BoxLayout(bottomJPanel, BoxLayout.Y_AXIS));

        JPanel contentJPanel = new JPanel();
        contentJPanel.setLayout(new BoxLayout(contentJPanel, BoxLayout.X_AXIS));
        jTable = new JTable(tableModel);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        contentJPanel.add(scrollPane);

        bottomJPanel.add(Box.createVerticalStrut(10));
        bottomJPanel.add(contentJPanel);
        bottomJPanel.add(Box.createVerticalStrut(10));

    }

    public static void main(String[] args) {
        //new ViewOrderDetailsJPanel();
    }

}
