package model;

/**
 * Product
 */
public class Product {

    private String name; //商品的名称
    private double price; //商品的价格
    private String modifiedDate; //商品信息更新的时间
    private int quantity; //商品数量
    private boolean isInStock; //商品状态，quantity 归零变为 out of stock;

    public Product() {
    }

    public Product(String name, double price, String modifiedDate, int quantity, boolean isInStock) {
        this.name = name;
        this.price = price;
        this.modifiedDate = modifiedDate;
        this.quantity = quantity;
        this.isInStock = isInStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        this.isInStock = inStock;
    }

    @Override
    public String toString() {
        return "Product{" +
               "name='" + name + '\'' +
               ", price='" + price + '\'' +
               ", modifiedDate='" + modifiedDate + '\'' +
               ", quantity=" + quantity +
               ", itemStatus=" + isInStock +
               '}';
    }

}
