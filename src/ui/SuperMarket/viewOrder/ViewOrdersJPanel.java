package ui.SuperMarket.viewOrder;

import ui.SuperMarket.MainProcess;
import ui.SuperMarket.mainJPanel.MarketMainJPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ViewOrdersJPanel extends JPanel{

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

    JLabel titleJLabel = new JLabel("All Orders From Different Communities");
    JButton viewOrderDetailsJButton = new JButton("View Order Details");
    JButton updateOrderStatusJButton = new JButton("Update Order Status");
    JButton backToMarketJButton = new JButton("<< Back to Market Interface");
    JTable jTable;

    public ViewOrdersJPanel() {

        InitData();
        InitViews();

    }

    private void InitData() {

        titles = new Vector<>();
        titles.add("ID");
        titles.add("Community Name");
        titles.add("Order Time");
        titles.add("Order Status");

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

        viewOrderDetailsJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainProcess.getInstance().changeFrame(new ViewOrderDetailsJPanel());
            }
        });

        updateOrderStatusJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainProcess.getInstance().changeFrame(new UpdateOrderStatusJPanel());
            }
        });

        backToMarketJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainProcess.getInstance().changeFrame(new MarketMainJPanel());
            }
        });

    }

    private void CreateTopJPanel() {

        topJPanel = new JPanel();
        topJPanel.setLayout(new BoxLayout(topJPanel, BoxLayout.Y_AXIS));

        topJPanel.add(Box.createVerticalStrut(10));
        topJPanel.add(backToMarketJButton);
        topJPanel.add(Box.createVerticalStrut(10));

    }

    private void CreateMiddleJPanel() {

        middleJPanel = new JPanel();
        middleJPanel.setLayout(new BoxLayout(middleJPanel, BoxLayout.Y_AXIS));

        JPanel upJPanel = new JPanel();
        upJPanel.setLayout(new BoxLayout(upJPanel, BoxLayout.X_AXIS));
        upJPanel.add(titleJLabel);

        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(upJPanel);
        middleJPanel.add(Box.createVerticalStrut(10));

        JPanel downJPanel = new JPanel();
        downJPanel.setLayout(new BoxLayout(downJPanel, BoxLayout.Y_AXIS));
        jTable = new JTable(tableModel);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        downJPanel.add(scrollPane);

        middleJPanel.add(Box.createVerticalStrut(10));
        middleJPanel.add(downJPanel);
        middleJPanel.add(Box.createVerticalStrut(10));

    }

    private void CreateBottomJPanel() {

        bottomJPanel = new JPanel();
        bottomJPanel.setLayout(new BoxLayout(bottomJPanel, BoxLayout.Y_AXIS));

        JPanel contentJPanel = new JPanel();
        contentJPanel.setLayout(new BoxLayout(contentJPanel, BoxLayout.X_AXIS));
        contentJPanel.add(Box.createHorizontalStrut(10));
        contentJPanel.add(viewOrderDetailsJButton);
        contentJPanel.add(Box.createHorizontalGlue());
        contentJPanel.add(updateOrderStatusJButton);
        contentJPanel.add(Box.createHorizontalStrut(10));

        bottomJPanel.add(Box.createVerticalStrut(10));
        bottomJPanel.add(contentJPanel);
        bottomJPanel.add(Box.createVerticalStrut(10));

    }

    public static void main(String[] args) {
        //new ViewOrdersJPanel();
    }

}
