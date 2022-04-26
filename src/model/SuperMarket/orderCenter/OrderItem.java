package model.SuperMarket.orderCenter;

/**
 * New Order Items
 */
public class OrderItem {

    //    private Product product;
    private String name;
    private double unitPrice; //price of per unit
    private double price; // unitPrice * quantityForOrder
    private int quantityForOrder;

    /**
     * delete all the codes below later
     */
    public OrderItem() {
    }

    public OrderItem(String name, double unitPrice, double price, int quantityForOrder) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.price = price;
        this.quantityForOrder = quantityForOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityForOrder() {
        return quantityForOrder;
    }

    public void setQuantityForOrder(int quantityForOrder) {
        this.quantityForOrder = quantityForOrder;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", price=" + price +
                ", quantityForOrder=" + quantityForOrder +
                '}';
    }

}
