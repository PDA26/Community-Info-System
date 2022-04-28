package model;

/**
 * Product
 */
public class Product {

    private String name; //商品的名称
    private double price; //商品的价格
    private String modifiedDate; //商品信息更新的时间
    private int quantity; //商品数量
    private int itemStatus; //商品状态，quantity 归零变为 out of stock; 1 = in stock; 2 = out of stock

    public Product() {
    }

    public Product(String name, double price, String modifiedDate, int quantity, int itemStatus) {
        this.name = name;
        this.price = price;
        this.modifiedDate = modifiedDate;
        this.quantity = quantity;
        this.itemStatus = itemStatus;
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

    public int getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(int itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", quantity=" + quantity +
                ", itemStatus=" + itemStatus +
                '}';
    }

}
