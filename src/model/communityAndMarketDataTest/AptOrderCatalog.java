package model.communityAndMarketDataTest;

import model.SuperMarket.orderCenter.OrderItem;

import java.util.HashMap;

public class AptOrderCatalog {

//    private static AptOrderCatalog instance = new AptOrderCatalog();
    public static AptOrderCatalog getInstance() {
        AptOrderCatalog instance = new AptOrderCatalog();
        return instance;
    }

    private AptOrderCatalog() {}

    private HashMap<String, OrderItem> aptOrderCatalogMap = new HashMap<>();

    public void addNewOrderItem(OrderItem orderItem) {

        aptOrderCatalogMap.put(orderItem.getName(), orderItem);

    }

    public HashMap<String, OrderItem> getAptOrderCatalogMap() {
        return aptOrderCatalogMap;
    }
}
