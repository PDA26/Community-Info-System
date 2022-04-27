package model.OrderData;

import model.OrderData.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 所有超市的所有订单 --- 每个超市的所有订单 ---- 社区的所有订单--------社区下面所有公寓的订单 -- 订单信息
 *  * MasterOrderList -- OrderCenter -- CommunityOrderCatalog -- AptOrderCatalog -- Order Item
 *
 * 以每一户公寓为单位存储下单的商品
 * 比如，存储 #105 买了 item 1; item 2 ...
 */
public class AptOrderCatalog {

    String aptNo;
    List<Order> list;


    public AptOrderCatalog(String aptNo) {
        this.aptNo = aptNo;
        this.list = new ArrayList<>();
    }
    public boolean addOrder(Order o){
        if(o == null)   return  false;
        list.add(o);
        return true;
    }
}
