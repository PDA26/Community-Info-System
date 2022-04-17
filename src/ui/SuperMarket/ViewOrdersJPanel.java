package ui.SuperMarket;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    JLabel titleJLabel = new JLabel("All Orders From Different Communities");
    JButton viewOrderDetailsJButton = new JButton("View Order Details");
    JButton updateOrderStatusJButton = new JButton("Update Order Status");
    JButton backToMarketJButton = new JButton("<< Back to Market Interface");

    public ViewOrdersJPanel() {

    }

    private void InitData() {

    }

    private void InitViews() {



    }

}
