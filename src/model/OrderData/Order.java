package model.OrderData;

import model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Order
 */
public class Order {

    private List<Product> itemList;
    public enum OrderStatus{
        PENDING, ACCEPTED, FINISHED
    }
    OrderStatus status;

    public Order(List<Product> input) {
        this.itemList = input;
        status = OrderStatus.PENDING;
    }
    public Order() {
        this.itemList = new ArrayList<>();
        status = OrderStatus.PENDING;
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
    /*
    List<Product> list;
    static int idCount = 0;
    int id;
    public Order() {
        this.list = new LinkedList<>();
        id = idCount++;
    }
    public void addItem(Product si){
        for(Product curr : list){
            if(curr.isSame(si)) {
                curr.setCnt(curr.getCnt() + si.getCnt());
                return;
            }
        }
        list.add(si);
    }
    */
}
