//package model.SuperMarket.orderCenter;
//
//import model.OrderData.Order;
//
//import java.util.Collection;
//import java.util.HashMap;
//
//public class OrderCatalog {
//
//    public static Object addOrder;
//    private static OrderCatalog instance = new OrderCatalog();
//    public static OrderCatalog getInstance() { return instance; }
//
//    public OrderCatalog() { }
//
//    Order currentOrder;
//
//    static HashMap<String, Order> orderItemHashMap = new HashMap<>();
//
//    public Collection<Order> getOrders() { return orderItemHashMap.values(); }
//
//    public void addOrder (Order orderItem) {
//        orderItemHashMap.putIfAbsent(order.getName(), orderItem);
//        orderItemHashMap.putIfAbsent(String.valueOf(order.getUnitPrice()), orderItem);
//        orderItemHashMap.putIfAbsent(String.valueOf(order.getPrice()), orderItem);
//        orderItemHashMap.putIfAbsent(String.valueOf(order.getQuantityForOrder()), orderItem);
//    }
//
//    public Order getCurrentOrder() { return currentOrder; }
//
//    public void setCurrentOrder (Order orderItem) {
//        this.currentOrder = orderItemHashMap.get(orderItem.getName());
//        this.currentOrder = orderItemHashMap.get(String.valueOf(orderItem.getUnitPrice()));
//        this.currentOrder = orderItemHashMap.get(String.valueOf(orderItem.getPrice()));
//        this.currentOrder = orderItemHashMap.get(String.valueOf(orderItem.getQuantityForOrder()));
//    }
//
//    public static HashMap<String, Order> deleteOrder(Order currentOrder, String item){
//
//        orderItemHashMap.remove(item);
//        return orderItemHashMap;
//    }
//
//    public static void addOrder(String Apt, Order item) {
//        orderItemHashMap.put(Apt, item);
//    }
//
//}

