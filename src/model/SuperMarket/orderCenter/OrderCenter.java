package model.SuperMarket.orderCenter;

import model.communityAndMarketDataTest.Apartment;
import model.communityAndMarketDataTest.Community;
import model.communityAndMarketDataTest.CommunityOrderCatalog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所有超市的所有订单 --- 每个超市的所有订单 ---- 社区的所有订单--------社区下面所有公寓的订单 -- 订单信息
 *  * MasterOrderList -- OrderCenter -- CommunityOrderCatalog -- AptOrderCatalog -- Order Item
 *
 * 每个超市都有他们独立的 OrderCenter 用来存储这个超市的所有订单
 * 每个超市看到的所有社区一级一级提交上来的订单
 * 比如现在是超市 A
 * 这个类存储的就是 A 收到的 社区 a, b, c ... 上传的所有订单
 */
public class OrderCenter {

//    private static OrderCenter instance = new OrderCenter();
    public static OrderCenter getInstance() {
        OrderCenter instance = new OrderCenter();
        return instance;
    }

    private OrderCenter() {

    }

    /**
     * 按照字段查询
     */
//    private HashMap<String, Map<String, Map<String, OrderItem>>> orderCenterMap = new HashMap<>();

//    public void addNewCommunity(Community community, Map<String, Map<String, OrderItem>> map) {
//
//        orderCenterMap.put(community.getCommunityName(), map);
//
//    }

//    public HashMap<String, Map<String, Map<String, OrderItem>>> getOrderCenterMap() {
//        return orderCenterMap;
//    }

    /**
     * 按照对象查询
     */
    private HashMap<Community, Map<Apartment, Map<String, OrderItem>>> orderCenterMap = new HashMap<>();

    public void addNewCommunity(Community community, Map<Apartment, Map<String, OrderItem>> map) {

        orderCenterMap.put(community, map);

    }

    public HashMap<Community, Map<Apartment, Map<String, OrderItem>>> getOrderCenterMap() {
        return orderCenterMap;
    }
}
