package model.SuperMarket.orderCenter;

import java.util.Collection;
import java.util.HashMap;

public class OrderCatalog {

    public static Object addOrder;
    private static OrderCatalog instance = new OrderCatalog();
    public static OrderCatalog getInstance() { return instance; }

    public OrderCatalog() { }

    OrderItem currentOrder;

    static HashMap<String, OrderItem> orderItemHashMap = new HashMap<>();

    public Collection<OrderItem> getOrders() { return orderItemHashMap.values(); }

    public void addOrder (OrderItem orderItem) {
        orderItemHashMap.putIfAbsent(orderItem.getName(), orderItem);
        orderItemHashMap.putIfAbsent(String.valueOf(orderItem.getUnitPrice()), orderItem);
        orderItemHashMap.putIfAbsent(String.valueOf(orderItem.getPrice()), orderItem);
        orderItemHashMap.putIfAbsent(String.valueOf(orderItem.getQuantityForOrder()), orderItem);
    }

    public OrderItem getCurrentOrder() { return currentOrder; }

    public void setCurrentOrder (OrderItem orderItem) {
        this.currentOrder = orderItemHashMap.get(orderItem.getName());
        this.currentOrder = orderItemHashMap.get(String.valueOf(orderItem.getUnitPrice()));
        this.currentOrder = orderItemHashMap.get(String.valueOf(orderItem.getPrice()));
        this.currentOrder = orderItemHashMap.get(String.valueOf(orderItem.getQuantityForOrder()));
    }

    public static HashMap<String, OrderItem> deleteOrder(OrderItem currentOrder, String item){

        orderItemHashMap.remove(item);
        return orderItemHashMap;
    }

    public static void addOrder(String Apt, OrderItem item) {
        orderItemHashMap.put(Apt, item);
    }

}

