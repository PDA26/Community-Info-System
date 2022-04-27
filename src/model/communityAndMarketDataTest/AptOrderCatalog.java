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

    OrderItem currentApartment;

    public AptOrderCatalog() {}

    private HashMap<String, OrderItem> aptOrderCatalogMap = new HashMap<>();

//    public Collection<Apartment> getApts() { return aptOrderCatalogMap.values(); }

    public OrderItem getCurrentApt() { return currentApartment; }

    public void setCurrentApartment (Apartment apartment) {
        this.currentApartment = aptOrderCatalogMap.get(apartment.getOrderId());
        this.currentApartment = aptOrderCatalogMap.get(apartment.getAptNo());
        this.currentApartment = aptOrderCatalogMap.get(apartment.getOrderTime());
    }

    public void addNewOrderItem(OrderItem orderItem) {

        aptOrderCatalogMap.put(orderItem.getName(), orderItem);

    }

    public HashMap<String, OrderItem> getAptOrderCatalogMap() {
        return aptOrderCatalogMap;
    }
}
