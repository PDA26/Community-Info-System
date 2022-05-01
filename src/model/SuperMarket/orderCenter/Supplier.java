package model.SuperMarket.orderCenter;

/**
 * Supplier OR Supermarket: 也就是对应的超市对应不同的 Product Catalog
 */
public class Supplier {

    private String supplierId;
    private String name;
    private String logo;
    private String zipCode;

    public Supplier() {
    }

    public Supplier(String supplierId, String name, String logo, String zipCode) {
        this.supplierId = supplierId;
        this.name = name;
        this.logo = logo;
        this.zipCode = zipCode;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
