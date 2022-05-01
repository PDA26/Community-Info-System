package model;

import model.Apartment;
import model.Community;
import model.CommunityOrderCatalog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 每个超市看到的所有社区一级一级提交上来的订单
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
