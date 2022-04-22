package ui.SuperMarket;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    JLabel titleJLabel = new JLabel("Menu of all the items");
    JButton addItemJButton = new JButton("Add New Item");
    JButton modifyItemJButton = new JButton("Modify Item");
    JButton deleteItemJButton = new JButton("Delete New Item");
    JButton backToMarketJButton = new JButton("<< Back to Market Interface");
    JTable jTable;

    public ViewItemMenuJPanel() {

    }

    private void InitData() {

    }

    private void InitViews() {



    }

}
