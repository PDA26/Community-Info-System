package model;

import java.util.HashMap;
import java.util.Vector;

public class OrderCatalog {

    public static Object addOrder;
    private static OrderCatalog instance = new OrderCatalog();
    public static OrderCatalog getInstance() { return instance; }

    public OrderCatalog() { }

    OrderItem currentOrder;

    static HashMap<String, OrderItem> orderItemHashMap = new HashMap<>();

    public Vector<CommunityOrderCatalog> getOrders() { return orderItemHashMap.values(); }

    public void addOrder (OrderItem orderItem) {
        orderItemHashMap.putIfAbsent(orderItem.name, orderItem);
        orderItemHashMap.putIfAbsent(String.valueOf(orderItem.unitPrice), orderItem);
        orderItemHashMap.putIfAbsent(String.valueOf(orderItem.price), orderItem);
        orderItemHashMap.putIfAbsent(String.valueOf(orderItem.quantityForOrder), orderItem);
    }

    public OrderItem getCurrentOrder() { return currentOrder; }

    public void setCurrentOrder (OrderItem orderItem) {
        this.currentOrder = orderItemHashMap.get(orderItem.name);
        this.currentOrder = orderItemHashMap.get(String.valueOf(orderItem.unitPrice));
        this.currentOrder = orderItemHashMap.get(String.valueOf(orderItem.price));
        this.currentOrder = orderItemHashMap.get(String.valueOf(orderItem.quantityForOrder));
    }

    public static HashMap<String, OrderItem> deleteOrder(OrderItem currentOrder, String item){

        orderItemHashMap.remove(item);
        return orderItemHashMap;
    }

    public static void addOrder(String Apt, OrderItem item) {
        orderItemHashMap.put(Apt, item);
    }

}
