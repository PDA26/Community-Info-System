package model.SuperMarket.orderCenter;

import model.communityAndMarketDataTest.Apartment;
import model.communityAndMarketDataTest.Community;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 *
 * 所有超市的所有订单 --- 每个超市的所有订单 ---- 社区的所有订单--------社区下面所有公寓的订单 -- 订单信息
 * MasterOrderList -- OrderCenter -- CommunityOrderCatalog -- AptOrderCatalog -- Order Item
 *
 * Master Order List
 * 继续吧 OrderCenter 中的订单汇总为这里的 MasterOrderList
 */
public class MasterOrderList {

    private static MasterOrderList instance = new MasterOrderList();
    public static MasterOrderList getInstance() {
        return instance;
    }

    private MasterOrderList(){

    }

    /**
     * 按照字段查询
     */
//    private HashMap<String, Map<String, Map<String, Map<String, OrderItem>>>> masterOrderMap = new HashMap<>();

//    public void addNewOrderCenter(Supplier supplier, Map<String, Map<String, Map<String, OrderItem>>> map) {
//
//        masterOrderMap.put(supplier.getSupplierId(), map);
//
//    }

//    public HashMap<String, Map<String, Map<String, Map<String, OrderItem>>>> getMasterOrderMap() {
//        return masterOrderMap;
//    }

    /**
     * 按照对象查询
     */
    private HashMap<Supplier, Map<Community, Map<Apartment, Map<String, OrderItem>>>> masterOrderMap = new HashMap<>();

    public void addNewOrderCenter(Supplier supplier, Map<Community, Map<Apartment, Map<String, OrderItem>>> map) {

        masterOrderMap.put(supplier, map);

    }

    public HashMap<Supplier, Map<Community, Map<Apartment, Map<String, OrderItem>>>> getMasterOrderMap() {
        return masterOrderMap;
    }

    /**
     * 获取 ViewAllOrder 表里的所有数据
     * @param supplier
     * @param community
     * @param apartment
     * @param item
     * @return
     */
    public Vector<Vector<Object>> getData(Supplier supplier, Community community, Apartment apartment, OrderItem item) {
        int ID = 1;
        String orderStatus = "pending";
        Vector<Vector<Object>> vectors = new Vector<>();

        Map<Community, Map<Apartment, Map<String, OrderItem>>> communityMapMap = masterOrderMap.get(supplier);
        Set<Map.Entry<Community, Map<Apartment, Map<String, OrderItem>>>> entries01 = communityMapMap.entrySet();

        for (Map.Entry<Community, Map<Apartment, Map<String, OrderItem>>> entry01 : entries01) {

            int latestId = 0;
            Vector<Object> vector = new Vector<>();

            vector.add(ID);

            Community key = entry01.getKey();
            String communityName = key.getCommunityName();
            vector.add(communityName);

            Map<Apartment, Map<String, OrderItem>> apartmentMapMap = communityMapMap.get(key);
            Set<Map.Entry<Apartment, Map<String, OrderItem>>> entries02 = apartmentMapMap.entrySet();
            for (Map.Entry<Apartment, Map<String, OrderItem>> entry02 : entries02) {

                Apartment key1 = entry02.getKey();
                if (key1.getOrderId() > latestId) {
                    latestId = key1.getOrderId();
                    vector.add(key1.getOrderTime());
                }

            }

            vector.add(orderStatus);
            ID ++;
        }

        return vectors;
    }

    public void dataOfOrderDetail(Supplier supplier, Community community) {

        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, OrderItem> orderItemMap = new HashMap<>();
        Vector<Vector<Object>> vectors = new Vector<>();

        Map<Community, Map<Apartment, Map<String, OrderItem>>> communityMapMap = masterOrderMap.get(supplier);
        Map<Apartment, Map<String, OrderItem>> apartmentMapMap = communityMapMap.get(community);
        Set<Map.Entry<Apartment, Map<String, OrderItem>>> apartmentEntries = apartmentMapMap.entrySet();
        for (Map.Entry<Apartment, Map<String, OrderItem>> apartmentMapEntry : apartmentEntries) {

            Apartment key1 = apartmentMapEntry.getKey();

            Map<String, OrderItem> stringOrderItemMap = apartmentMapMap.get(key1);
            Set<Map.Entry<String, OrderItem>> itemEntries = stringOrderItemMap.entrySet();
            for (Map.Entry<String, OrderItem> itemEntry : itemEntries) {

                OrderItem value = itemEntry.getValue();
                orderItemMap.put(value.getName(), value);

//                System.out.println(value);

                if (countMap.containsKey(value.getName())) {
                    countMap.put(value.getName(), countMap.get(value.getName()) + value.getQuantityForOrder());
                }else {
                    countMap.put(value.getName(), value.getQuantityForOrder());
                }

            }

        }

        Set<Map.Entry<String, Integer>> countEntries = countMap.entrySet();
        Set<Map.Entry<String, OrderItem>> itemEntries = orderItemMap.entrySet();

        for (Map.Entry<String, Integer> countEntry : countEntries) {

            String key = countEntry.getKey();
            Integer value = countEntry.getValue();
            int quantity = (int) value;

            Vector<Object> vector = new Vector<>();

            vector.add(key);

            for (Map.Entry<String, OrderItem> itemEntry : itemEntries) {

                String key1 = itemEntry.getKey();
                OrderItem value1 = itemEntry.getValue();

                if (key.equals(key1)) {

                    vector.add(value1.getUnitPrice());
                    vector.add(quantity);
                    vector.add(value1.getUnitPrice() * quantity);

                    vectors.add(vector);

                }

            }

        }

    }

}
