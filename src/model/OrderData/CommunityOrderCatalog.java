package model.OrderData;

import model.OrderData.Order;

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
