package model.SuperMarket.wareHouse;

import jdk.jfr.Name;
import model.Product;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Warehouse: Inventory Directory OR Inventory Catalog
 */
public class Warehouse extends AbstractTableModel {
    List<Product> dir;

    public Warehouse() {
        this.dir = new ArrayList<>();
    }

    public void add(Product p){
        dir.add(p);
        fireTableRowsInserted(dir.size() - 1, dir.size() - 1);
    }

    public void delete(int idx){
        dir.remove(idx);
        fireTableRowsDeleted(idx, idx);
    }

    public void delete(Product p) {
        int row = dir.indexOf(p);
        delete(row);
    }

    public Product getByName(String s) {
        for(Product p : dir){
            if(p.getName().compareTo(s) == 0){
                return p;
            }
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return dir.size();
    }

    @Override
    public int getColumnCount() {
        return Product.class.getFields().length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        try {
            return Product.class.getFields()[col].get(dir.get(row));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        Field field = Product.class.getFields()[column];
        Name name = field.getAnnotation(Name.class);
        if (name != null) {
            return name.value();
        }
        return field.getName();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Product.class.getFields()[columnIndex].getType();
    }
}

//    private int idCnt = 0;
//    Map<Integer, Product> map;
//    List<Product> list;
//
//    public Warehouse() {
//        this.map = new HashMap<>();
//        this.list = new ArrayList<>();
//    }
//
//    public boolean addItem(String name, int price, String spec, Date mfg, Date exp, String description){
//        Product tmp = new Product(name, price, spec, mfg, exp, description);
//        for(Product si : list){
//            if(si.isSame(tmp)){
//                return false;
//            }
//        }
//        map.put(idCnt++, tmp);
//        list.add(tmp);
//    }
//    public List<Product> getItemByName(String name){
//        List<Product> res = new ArrayList<>();
//        for(Product si : list){
//            if(si.getName().compareTo(name) == 0){
//                res.add(si);
//            }
//        }
//        return res;
//    }
//    public Product getItemById(int id){
//        return map.getOrDefault(id, null);
//    }
