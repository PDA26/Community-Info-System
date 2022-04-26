package model.communityAndMarketDataTest;

import model.SuperMarket.orderCenter.OrderItem;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有超市的所有订单 --- 每个超市的所有订单 ---- 社区的所有订单--------社区下面所有公寓的订单 -- 订单信息
 *  * MasterOrderList -- OrderCenter -- CommunityOrderCatalog -- AptOrderCatalog -- Order Item
 *
 * 社区存储下面所有的公寓上传的的订单信息
 * 比如现在所在的是社区 A
 * 那么这个类下面存储的就是 A 社区下面的所有 AptOrderCatalog 里面以每一户为单位的订单
 */
public class CommunityOrderCatalog {

//    private static CommunityOrderCatalog instance = new CommunityOrderCatalog();
    public static CommunityOrderCatalog getInstance() {
        CommunityOrderCatalog instance = new CommunityOrderCatalog();
        return instance;
    }

    private CommunityOrderCatalog() {

    }

    /**
     * 按照字段查询，仅输出Apartment_Id
     */
//    private HashMap<String, Map<String, OrderItem>> communityOrderCatalogMap = new HashMap<>();

//    public void addNewApt(Apartment apartment, Map<String, OrderItem> map) {
//
//        communityOrderCatalogMap.put(apartment.getAptNo(), map);
//        communityOrderCatalogMap.put(apartment, map);
//
//    }

//    public HashMap<String, Map<String, OrderItem>> getCommunityOrderCatalogMap() {
//        return communityOrderCatalogMap;
//    }

    /**
     * 按照对象查询，输出完整的对象
     */
    private HashMap<Apartment, Map<String, OrderItem>> communityOrderCatalogMap = new HashMap<>();

    public void addNewApt(Apartment apartment, Map<String, OrderItem> map) {

        communityOrderCatalogMap.put(apartment, map);

    }

    public HashMap<Apartment, Map<String, OrderItem>> getCommunityOrderCatalogMap() {
        return communityOrderCatalogMap;
    }
}
