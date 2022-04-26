package model.SuperMarket;

import model.SuperMarket.orderCenter.*;
import model.communityAndMarketDataTest.Apartment;
import model.communityAndMarketDataTest.AptOrderCatalog;
import model.communityAndMarketDataTest.Community;
import model.communityAndMarketDataTest.CommunityOrderCatalog;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class TestForData {

    public static void main(String[] args) {

        TestForData instance = new TestForData();

        //test if productCatalog could successfully receive data from product
        //instance.ProductCatalogTest();

        //test if supermarket (supplier directory) could successfully combine the supplier and productCatalog
        //instance.SupplierDirectoryTest();

//        instance.AptMapTest();

        instance.TestHowToGetCertainData();

    }

    public void TestHowToGetCertainData() {

        /**
         * item_01 is 30 in total
         * item_02 is 40 in total
         * item_03 is 30 in total
         * item_40 is 30 in total
         */
        OrderItem item01 = new OrderItem("item_01", 10, 100, 10);
        OrderItem item02 = new OrderItem("item_02", 10, 100, 10);
        OrderItem item03 = new OrderItem("item_03", 10, 100, 10);
        OrderItem item04 = new OrderItem("item_04", 10, 100, 10);

        OrderItem item05 = new OrderItem("item_01", 10, 100, 10);
        OrderItem item06 = new OrderItem("item_02", 10, 100, 10);
        OrderItem item07 = new OrderItem("item_03", 10, 100, 10);

        OrderItem item08 = new OrderItem("item_01", 10, 100, 10);
        OrderItem item09 = new OrderItem("item_02", 10, 100, 10);
        OrderItem item10 = new OrderItem("item_04", 10, 100, 10);

        OrderItem item11 = new OrderItem("item_02", 10, 100, 10);
        OrderItem item12 = new OrderItem("item_03", 10, 100, 10);
        OrderItem item13 = new OrderItem("item_04", 10, 100, 10);

        Apartment apt01 = new Apartment("AptNO_01", "time01", 1);
        Apartment apt02 = new Apartment("AptNO_02", "time02", 2);
        Apartment apt03 = new Apartment("AptNO_03", "time03", 3);
        Apartment apt04 = new Apartment("AptNO_04", "time04", 4);

        Community community01 = new Community("communityName_01", "address01", "zipcode01");
        Community community02 = new Community("communityName_02", "address02", "zipcode02");

        Supplier supplier01 = new Supplier("supplierId_01", "name", "logo", "zipcode01");

        AptOrderCatalog aptModel = AptOrderCatalog.getInstance();
        AptOrderCatalog aptModel02 = AptOrderCatalog.getInstance();
        AptOrderCatalog aptModel03 = AptOrderCatalog.getInstance();
        AptOrderCatalog aptModel04 = AptOrderCatalog.getInstance();

        CommunityOrderCatalog communityModel = CommunityOrderCatalog.getInstance();
        CommunityOrderCatalog communityModel02 = CommunityOrderCatalog.getInstance();

        OrderCenter orderCenterModel = OrderCenter.getInstance();

        MasterOrderList masterModel = MasterOrderList.getInstance();

        aptModel.addNewOrderItem(item01);
        aptModel.addNewOrderItem(item02);
        aptModel.addNewOrderItem(item03);
        aptModel.addNewOrderItem(item04);

        aptModel02.addNewOrderItem(item05);
        aptModel02.addNewOrderItem(item06);
        aptModel02.addNewOrderItem(item07);

        aptModel03.addNewOrderItem(item08);
        aptModel03.addNewOrderItem(item09);
        aptModel03.addNewOrderItem(item10);

        aptModel04.addNewOrderItem(item11);
        aptModel04.addNewOrderItem(item12);
        aptModel04.addNewOrderItem(item13);

        communityModel.addNewApt(apt01, aptModel.getAptOrderCatalogMap());
        communityModel.addNewApt(apt02, aptModel02.getAptOrderCatalogMap());

        communityModel02.addNewApt(apt03, aptModel03.getAptOrderCatalogMap());
        communityModel02.addNewApt(apt04, aptModel04.getAptOrderCatalogMap());

        orderCenterModel.addNewCommunity(community01, communityModel.getCommunityOrderCatalogMap());

        orderCenterModel.addNewCommunity(community02, communityModel02.getCommunityOrderCatalogMap());

        masterModel.addNewOrderCenter(supplier01, orderCenterModel.getOrderCenterMap());

        HashMap<Supplier, Map<Community, Map<Apartment, Map<String, OrderItem>>>> masterOrderMap = masterModel.getMasterOrderMap();

        /**
         * validate the data
         */
        /*Set<Map.Entry<Supplier, Map<Community, Map<Apartment, Map<String, OrderItem>>>>> entries = masterOrderMap.entrySet();
        for (Map.Entry<Supplier, Map<Community, Map<Apartment, Map<String, OrderItem>>>> entry : entries) {
            Supplier key = entry.getKey();
            Map<Community, Map<Apartment, Map<String, OrderItem>>> value = entry.getValue();
            System.out.println(key + "===" + value);
        }
        System.out.println("---------------------------------------------------------------------------");*/
        /**
         * Supplier{supplierId=supplierId_01, name='name', logo='logo', zipCode='zipcode01'}===
         *
         * {Community{communityName='communityName_01', communityAddress='address01', communityZipcode='zipcode01'}=
         *
         * {Apartment{aptNo='AptNO_01', orderTime='time01', orderId = 1}=
         *
         * {item_01=OrderItem{name='item_01', unitPrice=10.0, price=100.0, quantityForOrder=10}}}}
         */

        /**
         * Obtain required data through for & for
         */
        Map<Community, Map<Apartment, Map<String, OrderItem>>> communityMapMap = masterOrderMap.get(supplier01);
        Set<Map.Entry<Community, Map<Apartment, Map<String, OrderItem>>>> entries = communityMapMap.entrySet();
        for (Map.Entry<Community, Map<Apartment, Map<String, OrderItem>>> entry : entries) {

            int latestId = 0;
            Community key = entry.getKey();
            Map<Apartment, Map<String, OrderItem>> apartmentMapMap = communityMapMap.get(key);
            Set<Map.Entry<Apartment, Map<String, OrderItem>>> entries1 = apartmentMapMap.entrySet();
            for (Map.Entry<Apartment, Map<String, OrderItem>> entry02 : entries1) {
                Apartment key1 = entry02.getKey();

                System.out.println(key.getCommunityName() + " include the following apartments " + key1.getAptNo());

                if (key1.getOrderId() > latestId) {
                    latestId = key1.getOrderId();
                    System.out.println("the latest order is placed by " + key1 + "and the biggest id is " + latestId);
                    System.out.println("if clause run one time");
                }


            }

            System.out.println("-------------");

        }

        /**
         * Count the quantity and price of order items grouped by community
         */
        /**
         * group by supermarket
         */
//        Map<Community, Map<Apartment, Map<String, OrderItem>>> communityMapMap = masterOrderMap.get(supplier01);
//        Set<Map.Entry<Community, Map<Apartment, Map<String, OrderItem>>>> communityEntries = communityMapMap.entrySet();
//        for (Map.Entry<Community, Map<Apartment, Map<String, OrderItem>>> communityMapEntry : communityEntries) {
//
//            Community key = communityMapEntry.getKey();
//            Map<Apartment, Map<String, OrderItem>> apartmentMapMap = communityMapMap.get(key);
//
//            Set<Map.Entry<Apartment, Map<String, OrderItem>>> apartmentEntries = apartmentMapMap.entrySet();
//            for (Map.Entry<Apartment, Map<String, OrderItem>> apartmentMapEntry : apartmentEntries) {
//
//                Apartment key1 = apartmentMapEntry.getKey();
//
//                Map<String, OrderItem> stringOrderItemMap = apartmentMapMap.get(key1);
//                Set<Map.Entry<String, OrderItem>> itemEntries = stringOrderItemMap.entrySet();
//                for (Map.Entry<String, OrderItem> itemEntry : itemEntries) {
//
//                    OrderItem value = itemEntry.getValue();
//                    System.out.println(value);
//
//                }
//
//            }
//
//        }

        /**
         * group by community 01 and get the data vector
         */
//        HashMap<String, Integer> countMap = new HashMap<>();
//        HashMap<String, OrderItem> orderItemMap = new HashMap<>();
//        Vector<Vector<Object>> vectors = new Vector<>();
//
//        Map<Community, Map<Apartment, Map<String, OrderItem>>> communityMapMap = masterOrderMap.get(supplier01);
//        Map<Apartment, Map<String, OrderItem>> apartmentMapMap = communityMapMap.get(community01);
//        Set<Map.Entry<Apartment, Map<String, OrderItem>>> apartmentEntries = apartmentMapMap.entrySet();
//        for (Map.Entry<Apartment, Map<String, OrderItem>> apartmentMapEntry : apartmentEntries) {
//
//            Apartment key1 = apartmentMapEntry.getKey();
//
//            Map<String, OrderItem> stringOrderItemMap = apartmentMapMap.get(key1);
//            Set<Map.Entry<String, OrderItem>> itemEntries = stringOrderItemMap.entrySet();
//            for (Map.Entry<String, OrderItem> itemEntry : itemEntries) {
//
//                OrderItem value = itemEntry.getValue();
//                orderItemMap.put(value.getName(), value);
//
//                System.out.println(value);
//
//                if (countMap.containsKey(value.getName())) {
//                    countMap.put(value.getName(), countMap.get(value.getName()) + value.getQuantityForOrder());
//                }else {
//                    countMap.put(value.getName(), value.getQuantityForOrder());
//                }
//
//            }
//
//        }
//
//        Set<Map.Entry<String, Integer>> countEntries = countMap.entrySet();
//        Set<Map.Entry<String, OrderItem>> itemEntries = orderItemMap.entrySet();
//
//        for (Map.Entry<String, Integer> countEntry : countEntries) {
//
//            String key = countEntry.getKey();
//            Integer value = countEntry.getValue();
//            int quantity = (int) value;
//
//            Vector<Object> vector = new Vector<>();
//
//            vector.add(key);
//
//            for (Map.Entry<String, OrderItem> itemEntry : itemEntries) {
//
//                String key1 = itemEntry.getKey();
//                OrderItem value1 = itemEntry.getValue();
//
//                if (key.equals(key1)) {
//
//                    vector.add(value1.getUnitPrice());
//                    vector.add(quantity);
//                    vector.add(value1.getUnitPrice() * quantity);
//
//                    vectors.add(vector);
//
//                }
//
//            }
//
//        }
//
//        for (Vector<Object> v : vectors) {
//            System.out.println(v);
//        }

//        Set<Map.Entry<String, Integer>> entries = countMap.entrySet();
//        for (Map.Entry<String, Integer> entry : entries) {
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            System.out.println("the name of the item and the quantities of them are");
//            System.out.println(key + "===" + value);
//        }

        /**
         * group by community01  and count the quantity and price
         */
//        Map<Community, Map<Apartment, Map<String, OrderItem>>> communityMapMap = masterOrderMap.get(supplier01);
//        Set<Map.Entry<Community, Map<Apartment, Map<String, OrderItem>>>> communityEntries = communityMapMap.entrySet();
//
//        HashMap<String, Integer> countMap = new HashMap<>();
//
//        for (Map.Entry<Community, Map<Apartment, Map<String, OrderItem>>> communityMapEntry : communityEntries) {
//
//            Community key = communityMapEntry.getKey();
//            Map<Apartment, Map<String, OrderItem>> apartmentMapMap = communityMapMap.get(key);
//
//            Set<Map.Entry<Apartment, Map<String, OrderItem>>> apartmentEntries = apartmentMapMap.entrySet();
//            for (Map.Entry<Apartment, Map<String, OrderItem>> apartmentMapEntry : apartmentEntries) {
//
//                Apartment key1 = apartmentMapEntry.getKey();
//
//                Map<String, OrderItem> stringOrderItemMap = apartmentMapMap.get(key1);
//                Set<Map.Entry<String, OrderItem>> itemEntries = stringOrderItemMap.entrySet();
//                for (Map.Entry<String, OrderItem> itemEntry : itemEntries) {
//
//                    OrderItem value = itemEntry.getValue();
//                    //System.out.println(value);
//
//                    if (countMap.containsKey(value.getName())) {
//                        countMap.put(value.getName(), countMap.get(value.getName()) + value.getQuantityForOrder());
//                    }else {
//                        countMap.put(value.getName(), value.getQuantityForOrder());
//                    }
//
//                }
//
//            }
//
//        }



    }


    public void AptMapTest() {

//        OrderItem orderItem01 = new OrderItem("name01", 10, 100, 10);
//        OrderItem orderItem02 = new OrderItem("name02", 10, 100, 10);
//
//        /**
//         * family 1 submit its order
//         */
//        Apartment apt01 = new Apartment("01apt", "02/02/2022");
//        AptOrderCatalog model01 = AptOrderCatalog.getInstance();
//        model01.addNewOrderItem(orderItem01);
//        model01.addNewOrderItem(orderItem02);
//
//        HashMap<String, OrderItem> aptMapTest = model01.getAptOrderCatalogMap();
//        Set<Map.Entry<String, OrderItem>> entries = aptMapTest.entrySet();
//        for (Map.Entry<String, OrderItem> entry : entries) {
//            String key = entry.getKey();
//            OrderItem value = entry.getValue();
//            System.out.println(key + "  " + value);
//        }
//
//        /**
//         * family 2 submit its order
//         */
//        Apartment apt02 = new Apartment("02apt", "02/02/2022");
//        OrderItem orderItem03 = new OrderItem("name03", 10, 100, 10);
//        OrderItem orderItem04 = new OrderItem("name04", 10, 100, 10);
//        AptOrderCatalog model02 = AptOrderCatalog.getInstance();
//        model02.addNewOrderItem(orderItem03);
//        model02.addNewOrderItem(orderItem04);
//
//        CommunityOrderCatalog communityInstance = CommunityOrderCatalog.getInstance();
//        communityInstance.addNewApt(apt01, model01.getAptOrderCatalogMap());
//        communityInstance.addNewApt(apt02, model02.getAptOrderCatalogMap());
//
//        HashMap<String, Map<String, OrderItem>> communityOrderCatalogMap = communityInstance.getCommunityOrderCatalogMap();
//        Set<Map.Entry<String, Map<String, OrderItem>>> entries = communityOrderCatalogMap.entrySet();
//        for (Map.Entry<String, Map<String, OrderItem>> entry : entries) {
//            String key = entry.getKey();
//            Map<String, OrderItem> value = entry.getValue();
//            System.out.println(key + "  " + value);
//        }

    }

    public void ProductCatalogTest() {

        Product product1 = new Product("tofu", 10, "01/22/2022", 10, 1);
        Product product2 = new Product("tofu1", 10, "01/22/2022", 10, 1);

        //ProductCatalog productCatalog = new ProductCatalog();

        //先初始化一个 map 的写法，后面不用了
        //HashMap<String, Product> map = productCatalog.InitHashMap();
        //HashMap<String, Product> map = productCatalog.getProductCatalogMap();

        /*map.put(product1.getName(), product1);
        map.put(product2.getName(), product2);*/
        /*productCatalog.addNewProduct(product1);
        productCatalog.addNewProduct(product2);

        //用 get 方法获取添加完元素后的 map
        HashMap<String, Product> map = productCatalog.getProductCatalogMap();

        Set<Map.Entry<String, Product>> entries = map.entrySet();

        for (Map.Entry<String, Product> entry : entries) {

            String key = entry.getKey();
            Product value = entry.getValue();

            System.out.println(key + "  " + value);

        }*/

    }

    public void SupplierDirectoryTest() {

//        SupplierDirectory supplierDirectory = new SupplierDirectory();
//        HashMap<Supplier, ProductCatalog> directory = supplierDirectory.InitHashMap();
//
//        *//**
//         * supermarket 1
//         *//*
//        Supplier supplier01 = new Supplier("walmart", "", "02215");
//
//        ProductCatalog productCatalog1 = new ProductCatalog();
//        HashMap<String, Product> map1 = productCatalog1.InitHashMap();
//
//        Product product1 = new Product("tofu", 10, "01/22/2022", 10, 1);
//        Product product2 = new Product("tofu1", 10, "01/22/2022", 10, 1);
//        map1.put(product1.getName(), product1);
//        map1.put(product2.getName(), product2);
//
//        *//**
//         * supermarket 2
//         *//*
//        Supplier supplier02 = new Supplier("target", "", "02215");
//
//        ProductCatalog productCatalog2 = new ProductCatalog();
//        HashMap<String, Product> map2 = productCatalog2.InitHashMap();
//
//        Product product3 = new Product("tofu2", 10, "01/22/2022", 10, 1);
//        Product product4 = new Product("tofu3", 10, "01/22/2022", 10, 1);
//        map2.put(product3.getName(), product3);
//        map2.put(product4.getName(), product4);
//
//        directory.put(supplier01, productCatalog1);
//        directory.put(supplier02, productCatalog2);
//        Set<Map.Entry<Supplier, ProductCatalog>> entries = directory.entrySet();
//        for (Map.Entry<Supplier, ProductCatalog> entry : entries) {
//
//            Supplier key = entry.getKey();
//
//            ProductCatalog value = entry.getValue();
//
//            System.out.println(key + "  " + value);
//
//        }

    }

}
