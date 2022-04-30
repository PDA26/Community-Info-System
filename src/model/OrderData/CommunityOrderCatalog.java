package model.OrderData;

import model.OrderData.Order;
import model.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有超市的所有订单 --- 每个超市的所有订单 ---- 社区的所有订单--------社区下面所有公寓的订单 -- 订单信息
 *  * MasterOrderList -- OrderCenter -- CommunityOrderCatalog -- AptOrderCatalog -- Order Item
 *
 * 社区存储下面所有的公寓上传的的订单信息
 * 比如现在所在的是社区 A
 * 那么这个类下面存储的就是 A 社区下面的所有 AptOrderCatalog 里面以每一户为单位的订单
 */
public class CommunityOrderCatalog {
    String communityName;
    Map<String, AptOrderCatalog> map;
    public CommunityOrderCatalog() {
        this.map = new HashMap<>();
    }
    public CommunityOrderCatalog(String communityName) {
        this.communityName = communityName;
        this.map = new HashMap<>();
    }
    public void addApt(String s){
        if(map.containsKey(s))  return;
        map.put(s, new AptOrderCatalog(s));
    }

    public String[][] getDigest(){
        int n = 0, i = 0;
        for(String key : map.keySet()){
            if(map.get(key).getMostRecentOrderDate() != null){
                AptOrderCatalog aoc = map.get(key);
                for(Order o : aoc.getList()){
                    if(o.getStatus() == Order.OrderStatus.PENDING){
                        n++;
                    }
                }
            }
        }

        String[][] res = new String[n][2];
        for(String key : map.keySet()){
            if(map.get(key).getMostRecentOrderDate() != null){
                AptOrderCatalog aoc = map.get(key);
                for(Order o : aoc.getList()){
                    if(o.getStatus() == Order.OrderStatus.PENDING){
                        res[i][0] = key;
                        res[i][1] = o.getDate().toString();
                        i++;
                    }
                }
            }
        }
        return res;
    }

    public String[][] getPending(){
        int n = 0, i = 0;
        for(String key : map.keySet()){
            AptOrderCatalog aoc = map.get(key);
            if(aoc.getList().size() != 0){
                n += aoc.getList().size();
            }
        }
        String[][] res = new String[n][7];
        //String[] titleOrders = {"AptNo", "ID", "Date", "Name", "Quantity", "Unit Price", "Total Price", "Status"};
        for(String key : map.keySet()){
            AptOrderCatalog aoc = map.get(key);
            if(map.get(key).getList().size() != 0) {
                String[][] tmp = aoc.getAllOrderDetails();
                res[i][0] = aoc.getAptNo();
                for(int j = 0; j < 6; j++){
                    res[i][j + 1] = tmp[i][j];
                }
                i++;
            }
        }
        return res;
    }


    public String[][] getFull(){
        int n = 0, i = 0;
        for(String key : map.keySet()){
            AptOrderCatalog aoc = map.get(key);
            for(Order o : aoc.getList()){
                for (Product p : o.getItemList()){
                    n++;
                }
            }
        }
        String[][] res = new String[n][7];
        //String[] titleOrders = {"AptNo", "ID", "Date", "Name", "Quantity", "Unit Price", "Status"};
        for(String key : map.keySet()){
            AptOrderCatalog aoc = map.get(key);
            if(map.get(key).getList().size() != 0) {
                //String[][] tmp = aoc.getAllOrderDetails();
                for(Order o : aoc.getList()){
                    for(Product p : o.getItemList()){
                        String[] tmp = p.getStringArr();
                        res[i][0] = aoc.getAptNo();
                        res[i][1] = String.valueOf(o.getId());
                        for(int j = 0; j < 4; j++){
                            res[i][j + 2] = tmp[j];
                        }
                        res[i][6] = o.getStatus().toString();
                        i++;
                    }
                }
            }
        }
        return res;
    }



    public AptOrderCatalog getByAptNo(String key){
        return map.getOrDefault(key, null);
    }
    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public Map<String, AptOrderCatalog> getMap() {
        return map;
    }

    public void setMap(Map<String, AptOrderCatalog> map) {
        this.map = map;
    }
}
