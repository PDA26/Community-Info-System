package ui.SuperMarket;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class ViewItemMenuJPanel extends JPanel{

    /**
     * data
     */

    /**
     * table
     */
    Vector<String> titles;
    Vector<Vector<Object>> data;
    DefaultTableModel tableModel;

    /**
     * components
     */
    private static JPanel topJPanel;
    private static JPanel middleJPanel;
    private static JPanel bottomJPanel;

    JLabel titleJLabel = new JLabel("Menu of all the items");
    JButton addItemJButton = new JButton("Add New Item");
    JButton modifyItemJButton = new JButton("Modify Item");
    JButton deleteItemJButton = new JButton("Delete New Item");
    JButton backToMarketJButton = new JButton("<< Back to Market Interface");
    JTable jTable;

    public ViewItemMenuJPanel() {

        InitData();
        InitViews();

    }

    private void InitData() {

        titles = new Vector<>();
        titles.add("Item Name");
        titles.add("Price");
        titles.add("Modified Date");
        titles.add("Quantity");
        titles.add("Item Status");

        data = new Vector<>();//目前还没有数据，之后还要改

        tableModel = new DefaultTableModel(data, titles);

    }

    private void InitViews() {

        CreateTopJPanel();
        CreateMiddleJPanel();
        CreateBottomJPanel();

        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new GridBagLayout());

        GridBagConstraints constraintsForTop = new GridBagConstraints();
        constraintsForTop.gridx = 0;
        constraintsForTop.gridy = 0;
        constraintsForTop.weightx = 0;
        constraintsForTop.weighty = 0;
        constraintsForTop.fill = GridBagConstraints.BOTH;
        panelContainer.add(topJPanel, constraintsForTop);

        GridBagConstraints constraintsForMiddle = new GridBagConstraints();
        constraintsForMiddle.gridx = 0;
        constraintsForMiddle.gridy = 1;
        constraintsForMiddle.weightx = 1.0;
        constraintsForMiddle.weighty = 0;
        constraintsForMiddle.fill = GridBagConstraints.CENTER;
        panelContainer.add(middleJPanel, constraintsForMiddle);

        GridBagConstraints constraintsForBottom = new GridBagConstraints();
        constraintsForBottom.gridx = 0;
        constraintsForBottom.gridy = 2;
        constraintsForBottom.weightx = 1.0;
        constraintsForBottom.weighty = 0;
        constraintsForBottom.fill = GridBagConstraints.HORIZONTAL;
        panelContainer.add(bottomJPanel, constraintsForBottom);

        JFrame jFrame = new JFrame("");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelContainer.setOpaque(true);
        jFrame.setSize(new Dimension(800, 800));
        jFrame.setContentPane(panelContainer);
        jFrame.setVisible(true);

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
        contentJPanel.add(addItemJButton);
        contentJPanel.add(Box.createHorizontalStrut(30));
        contentJPanel.add(modifyItemJButton);
        contentJPanel.add(Box.createHorizontalStrut(30));
        contentJPanel.add(deleteItemJButton);
        contentJPanel.add(Box.createHorizontalGlue());

        bottomJPanel.add(Box.createVerticalStrut(10));
        bottomJPanel.add(contentJPanel);
        bottomJPanel.add(Box.createVerticalStrut(10));

    }

    public static void main(String[] args) {
        //new ViewItemMenuJPanel();
    }

}
