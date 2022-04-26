package model.communityAndMarketDataTest;

import model.SuperMarket.orderCenter.OrderItem;

import java.util.HashMap;

/**
 * 所有超市的所有订单 --- 每个超市的所有订单 ---- 社区的所有订单--------社区下面所有公寓的订单 -- 订单信息
 *  * MasterOrderList -- OrderCenter -- CommunityOrderCatalog -- AptOrderCatalog -- Order Item
 *
 * 以每一户公寓为单位存储下单的商品
 * 比如，存储 #105 买了 item 1; item 2 ...
 */
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
