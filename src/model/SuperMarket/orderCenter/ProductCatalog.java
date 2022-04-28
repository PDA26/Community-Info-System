//package model.SuperMarket.orderCenter;
//
//import model.Product;
//
//import java.util.*;
//
///**
// * Product Catalog -- Product
// *
// * 用于存储超市的所有商品信息
// */
//public class ProductCatalog {
//
//    private static ProductCatalog instance = new ProductCatalog();
//
//    public static ProductCatalog getInstance() {
//        return instance;
//    }
//
//
//
//    private ProductCatalog() {
//    }
//
//    /*public ProductCatalog(HashMap<String, Product> productCatalogMap) {
//        this.productCatalogMap = productCatalogMap;
//    }
//
//    public HashMap<String, Product> getProductCatalogMap() {
//        return productCatalogMap;
//    }
//
//    public void setProductCatalogMap(HashMap<String, Product> productCatalogMap) {
//        this.productCatalogMap = productCatalogMap;
//    }*/
//    @Override
//    public String toString() {
//        return "ProductCatalog{" +
//                "productCatalogMap=" + productCatalogMap +
//                '}';
//    }
//
//    Product currentProduct;
//    private HashMap<String, Product> productCatalogMap = new HashMap<>();
//
//    public Collection<Product> getProducts() {
//        return productCatalogMap.values();
//    }
//
//    public HashMap<String, Product> getProductCatalogMap() {
//        return productCatalogMap;
//    }
//
//    public void addNewProduct(Product product) {
//        productCatalogMap.put(product.getName(), product);
//    }
//
//    public Product getCurrentProduct() {
//        return currentProduct;
//    }
//
//    public void setCurrentProduct(String name) {
//
//        if (productCatalogMap.get(name) != null) {
//
//            Set<Map.Entry<String, Product>> entries = productCatalogMap.entrySet();
//
//            for (Map.Entry<String, Product> entry : entries) {
//
//                String key = entry.getKey();
//                Product value = entry.getValue();
//
//                if (key.equals(name)){
//                    currentProduct = value;
//                    return;
//                }
//
//            }
//
//        }
//
//    }
//
//    public void deleteProduct(String name) {
//
//        if (productCatalogMap.get(name) != null) {
//
//            Set<Map.Entry<String, Product>> entries = productCatalogMap.entrySet();
//
//            for (Map.Entry<String, Product> entry : entries) {
//
//                String key = entry.getKey();
//                Product value = entry.getValue();
//
//                if (key.equals(name)){
//
//                    productCatalogMap.remove(key);
//                    System.out.println("delete successfully");
//                    break;
//
//                }
//
//            }
//
//        }
//
//    }
//
//    public Vector<Vector<Object>> getData() {
//        Vector<Vector<Object>> vectors = new Vector<>();
//
//        Set<Map.Entry<String, Product>> entries = productCatalogMap.entrySet();
//        for (Map.Entry<String, Product> entry : entries) {
//
//            String key = entry.getKey();
//            Product value = entry.getValue();
//
//            Vector<Object> vector = new Vector<>();
//            vector.add(value.getName());
//            vector.add(value.getPrice());
//            vector.add(value.getModifiedDate());
//            vector.add(value.getQuantity());
//
//            int flag = value.getItemStatus();
//            if (flag == 1) {
//                vector.add("In stock");
//            }else if (flag == 2){
//                vector.add("Out of stock");
//            }
////            vector.add(value.getItemStatus());
//
//            vectors.add(vector);
//
//        }
//
//        return vectors;
//    }
//
//    public void printCatalog() {
//
//        Set<Map.Entry<String, Product>> entries = productCatalogMap.entrySet();
//
//        for (Map.Entry<String, Product> entry : entries) {
//
//            String key = entry.getKey();
//            Product value = entry.getValue();
//            System.out.println(key + "  " + value);
//
//        }
//
//    }
//
//}
