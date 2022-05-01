package model.SuperMarket.wareHouse;

import jdk.jfr.Name;
import model.SuperMarket.orderCenter.deletePending.ShopItem;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Warehouse: Inventory Directory OR Inventory Catalog
 */
public class Warehouse extends AbstractTableModel {
    List<ShopItem> dir;

    public Warehouse() {
        this.dir = new ArrayList<>();
    }

    public void add(ShopItem p){
        dir.add(p);
        fireTableRowsInserted(dir.size() - 1, dir.size() - 1);
    }

    public void delete(int idx){
        dir.remove(idx);
        fireTableRowsDeleted(idx, idx);
    }

    public void delete(ShopItem p) {
        int row = dir.indexOf(p);
        delete(row);
    }

    public ShopItem get(int i) {
        return dir.get(i);
    }

    @Override
    public int getRowCount() {
        return dir.size();
    }

    @Override
    public int getColumnCount() {
        return ShopItem.class.getFields().length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        try {
            return ShopItem.class.getFields()[col].get(dir.get(row));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        Field field = ShopItem.class.getFields()[column];
        Name name = field.getAnnotation(Name.class);
        if (name != null) {
            return name.value();
        }
        return field.getName();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return ShopItem.class.getFields()[columnIndex].getType();
    }
}

//    private int idCnt = 0;
//    Map<Integer, ShopItem> map;
//    List<ShopItem> list;
//
//    public Warehouse() {
//        this.map = new HashMap<>();
//        this.list = new ArrayList<>();
//    }
//
//    public boolean addItem(String name, int price, String spec, Date mfg, Date exp, String description){
//        ShopItem tmp = new ShopItem(name, price, spec, mfg, exp, description);
//        for(ShopItem si : list){
//            if(si.isSame(tmp)){
//                return false;
//            }
//        }
//        map.put(idCnt++, tmp);
//        list.add(tmp);
//    }
//    public List<ShopItem> getItemByName(String name){
//        List<ShopItem> res = new ArrayList<>();
//        for(ShopItem si : list){
//            if(si.getName().compareTo(name) == 0){
//                res.add(si);
//            }
//        }
//        return res;
//    }
//    public ShopItem getItemById(int id){
//        return map.getOrDefault(id, null);
//    }
