package ui.SuperMarket;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    JLabel titleJLabel = new JLabel("Order Details");
    JLabel communityNameJLabel = new JLabel("Community Name: ");
    JLabel communityName = new JLabel();
    JLabel orderTimeJLabel = new JLabel("Order Time: ");
    JLabel orderTime = new JLabel();
    JTable jTable;

    public ViewOrderDetailsJPanel() {

    }

    private void InitData() {

    }

    private void InitViews() {



    }

}
