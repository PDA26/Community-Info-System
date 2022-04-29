package ui.Delivery;

import model.CommunityData.CommunityModel;
import model.OrderData.Order;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class DeliveryTableModel extends AbstractTableModel {
    private List<Order> orders = new ArrayList<>();
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setStatus(int idx, Order.OrderStatus status) {
        orders.get(idx).setStatus(status);
        fireTableCellUpdated(idx, 3);
    }

    public void setAddress(int idx, String address) {
        orders.get(idx).setGroceryAddress(address);
        fireTableCellUpdated(idx, 4);
    }

    @Override
    public int getRowCount() {
        return orders.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Order order = orders.get(row);
        switch (col) {
            case 0:
                return order.getId();
            case 1:
                return order.getCommunityName();
            case 2:
                return CommunityModel.getInstance()
                                     .getCommunityByKey(order.getCommunityName())
                                     .getCommunityAddress();
            case 3:
                return order.getStatus();
            case 4:
                return order.getGroceryAddress();
        }
        return null;
    }
}
