//package model.CommunityData;
//
//import model.SuperMarket.orderCenter.OrderItem;
//import model.communityAndMarketDataTest.Apartment;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class CommunityOrderCatalog {
//
//    //    private static CommunityOrderCatalog instance = new CommunityOrderCatalog();
//    public static CommunityOrderCatalog getInstance() {
//        CommunityOrderCatalog instance = new CommunityOrderCatalog();
//        return instance;
//    }
//
//    public CommunityOrderCatalog() {
//
//    }
//
//    /**
//     * 按照字段查询，仅输出Apartment_Id
//     */
////    private HashMap<String, Map<String, OrderItem>> communityOrderCatalogMap = new HashMap<>();
//
////    public void addNewApt(Apartment apartment, Map<String, OrderItem> map) {
////
////        communityOrderCatalogMap.put(apartment.getAptNo(), map);
////        communityOrderCatalogMap.put(apartment, map);
////
////    }
//
////    public HashMap<String, Map<String, OrderItem>> getCommunityOrderCatalogMap() {
////        return communityOrderCatalogMap;
////    }
//
//    /**
//     * 按照对象查询，输出完整的对象
//     */
//    private HashMap<Apartment, Map<String, OrderItem>> communityOrderCatalogMap = new HashMap<>();
//
//    public void addNewApt(Apartment apartment, Map<String, OrderItem> map) {
//
//        communityOrderCatalogMap.put(apartment, map);
//
//    }
//
//    public HashMap<Apartment, Map<String, OrderItem>> getCommunityOrderCatalogMap() {
//        return communityOrderCatalogMap;
//    }
//}
