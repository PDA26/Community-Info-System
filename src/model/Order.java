package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Order {
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
}
