package model.OrderData;



import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 *
 * 所有超市的所有订单 --- 每个超市的所有订单 ---- 社区的所有订单--------社区下面所有公寓的订单 -- 订单信息
 * MasterOrderList -- OrderCenter -- CommunityOrderCatalog -- AptOrderCatalog -- Order Item
 *
 * Master Order List
 * 继续吧 OrderCenter 中的订单汇总为这里的 MasterOrderList
 */
public class MasterOrderList {

    private static MasterOrderList instance = new MasterOrderList();
    public static MasterOrderList getInstance() {
        return instance;
    }
    Map<String, CommunityOrderCatalog> map;
    private MasterOrderList(){
        this.map = new HashMap<>();
    }
    public void addCommunityCatalog(CommunityOrderCatalog c){
        map.put(c.getCommunityName(), c);
    }
    public Map<String, CommunityOrderCatalog> getMap() {
        return map;
    }

    public void setMap(Map<String, CommunityOrderCatalog> map) {
        this.map = map;
    }
}
