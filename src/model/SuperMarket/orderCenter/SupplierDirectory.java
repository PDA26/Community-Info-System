package model.SuperMarket.orderCenter;

import java.util.HashMap;
import java.util.Map;

/**
 * Supplier Directory: 也就是不同的超市
 */
public class SupplierDirectory {

    ProductCatalog productCatalogModel = ProductCatalog.getInstance();

    private static SupplierDirectory instance = new SupplierDirectory();
    public static SupplierDirectory getInstance() {
        return instance;
    }

    private SupplierDirectory() {

    }

    private HashMap<String, Map<String, Product>> supplierDirectoryMap = new HashMap<>();

    public void addNewSupplierAndItsProducts(Supplier supplier) {

        supplierDirectoryMap.put(supplier.getSupplierId(), productCatalogModel.getProductCatalogMap());

    }

    public HashMap<String, Map<String, Product>> getSupplierDirectoryMap() {
        return supplierDirectoryMap;
    }
}
