package model;

/**
 * Product
 */
public class Product {

    public String name; //商品的名称
    public double price; //商品的价格
    public String modifiedDate; //商品信息更新的时间
    public int quantity; //商品数量
    public boolean isInStock; //商品状态，quantity 归零变为 out of stock;

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
    public String[] getStringArr(){
        //"Date", "Name", "Quantity", "Unit Price", "Total Price", "Status"
        String[] res = new String[4];
        res[0] = String.valueOf(modifiedDate);
        res[1] = name;
        res[2] = String.valueOf(quantity);
        res[3] = String.valueOf(price);
        //res[4] = String.valueOf(isInStock);
        return res;
    }

}
