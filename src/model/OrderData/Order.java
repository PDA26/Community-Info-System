package model.OrderData;

import model.Product;
import jdk.jfr.Name;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.DuplicateFormatFlagsException;
import java.util.List;

/**
 * Order
 */
public class Order {
    private static int idCount = 0;
    private final int id;
    private Date date;
    private List<Product> itemList;
    public enum OrderStatus{
        PENDING, ACCEPTED, FINISHED
    }
    OrderStatus status;

    public Order(List<Product> input) {
        this.id = idCount++;
        this.itemList = input;
        status = OrderStatus.PENDING;
        //this.date = new Date();
    }
    public Order() {
        this.id = idCount++;
        this.itemList = new ArrayList<>();
        status = OrderStatus.PENDING;
        //this.date = new Date();
    }
    public int addProduct(Product p){
        itemList.add(p);
        return p.getQuantity();
    }

    public List<Product> getItemList() {
        return itemList;
    }

    public void setItemList(List<Product> itemList) {
        this.itemList = itemList;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }
}
