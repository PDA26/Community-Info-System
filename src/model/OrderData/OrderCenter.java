package model.OrderData;

import model.OrderData.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有超市的所有订单 --- 每个超市的所有订单 ---- 社区的所有订单--------社区下面所有公寓的订单 -- 订单信息
 *  * MasterOrderList -- OrderCenter -- CommunityOrderCatalog -- AptOrderCatalog -- Order Item
 *
 * 每个超市都有他们独立的 OrderCenter 用来存储这个超市的所有订单
 * 每个超市看到的所有社区一级一级提交上来的订单
 * 比如现在是超市 A
 * 这个类存储的就是 A 收到的 社区 a, b, c ... 上传的所有订单
 */
public class OrderCenter {
    String superMarketName;
    Map<String, CommunityOrderCatalog> map;

    public OrderCenter(String superMarketName) {
        this.superMarketName = superMarketName;
        this.map = new HashMap<>();
    }
    public OrderCenter() {
        this.map = new HashMap<>();
    }

    public String getSuperMarketName() {
        return superMarketName;
    }

    public void setSuperMarketName(String superMarketName) {
        this.superMarketName = superMarketName;
    }

    public Map<String, CommunityOrderCatalog> getMap() {
        return map;
    }

    public void setMap(Map<String, CommunityOrderCatalog> map) {
        this.map = map;
    }

}
