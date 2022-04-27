package model.SuperMarket.orderCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Order
 */
public class Order {

    private HashMap<String, ArrayList<OrderItem>> orderMap;

    /*
    List<ShopItem> list;
    static int idCount = 0;
    int id;
    public Order() {
        this.list = new LinkedList<>();
        id = idCount++;
    }
    public void addItem(ShopItem si){
        for(ShopItem curr : list){
            if(curr.isSame(si)) {
                curr.setCnt(curr.getCnt() + si.getCnt());
                return;
            }
        }
        list.add(si);
    }
    */
}
