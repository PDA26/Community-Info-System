package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;

public class AptOrderCatalog {

    public static AptOrderCatalog getInstance() {
        AptOrderCatalog instance = new AptOrderCatalog();
        return instance;
    }

    Apartment currentApartment;

    public AptOrderCatalog() {}

    private HashMap<String, Apartment> aptOrderCatalogMap = new HashMap<>();

    public Collection<Apartment> getApts() { return aptOrderCatalogMap.values(); }

    public Vector<Apartment> getCurrentApt() { return currentApartment; }

    public void setCurrentApartment (Apartment apartment) {
        this.currentApartment = aptOrderCatalogMap.get(apartment.orderId);
        this.currentApartment = aptOrderCatalogMap.get(apartment.aptNo);
        this.currentApartment = aptOrderCatalogMap.get(apartment.orderTime);
    }

    public HashMap<String, Apartment> getAptOrderCatalogMap() {
        return aptOrderCatalogMap;
    }
}
