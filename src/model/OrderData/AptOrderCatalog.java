package model.OrderData;

import jdk.jfr.Name;
import model.OrderData.Order;
import model.Product;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
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

    private String aptNo;
    private List<Order> list;

    public Date getMostRecentOrderDate(){
        if(list.size() == 0){
            return null;
        }
        return list.get(list.size() - 1).getDate();
    }

    public AptOrderCatalog(String aptNo) {
        this.aptNo = aptNo;
        this.list = new ArrayList<>();
    }
    public boolean addOrder(Order o){
        if(o == null)   return  false;
        list.add(o);
        return true;
    }
    public String[][] getAllOrderDetails(){
        int n = 0, i = 0;
        for(Order o : list){
            for(Product p : o.getItemList()){
                n++;
            }
        }
        //String[] titleOrder = {"ID", "Date", "Name", "Quantity", "Unit Price", "Status"};
        String[][] res = new String[n][6];
        for(Order o : list){
            int id = o.getId();
            Date date = o.getDate();
            for(Product p : o.getItemList()) {
                res[i][0] = String.valueOf(id);
                res[i][1] = date.toString();
                res[i][2] = p.getName();
                res[i][3] = String.valueOf(p.getQuantity());
                res[i][4] = String.valueOf(p.getPrice());
                res[i][5] = o.getStatus().toString();
                i++;
            }
        }
        return res;
    }

    public String getAptNo() {
        return aptNo;
    }

    public void setAptNo(String aptNo) {
        this.aptNo = aptNo;
    }

    public List<Order> getList() {
        return list;
    }

    public void setList(List<Order> list) {
        this.list = list;
    }
}
