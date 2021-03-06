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
    List<Product> dir = new ArrayList<>();;

    public void updateItemCnt(int row, int val){
        dir.get(row).quantity = val;
        if(val == 0){
            dir.get(row).setInStock(false);
            fireTableCellUpdated(row, 4);
        }
        fireTableCellUpdated(row, 3);
    }

    public List<Product> getDir() {
        return dir;
    }

    public void setDir(List<Product> dir) {
        this.dir = dir;
    }

    public Warehouse() {
//        this.dir = new ArrayList<>();
    }

    public Product get(int idx) {
        return dir.get(idx);
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
    public Product getClone(Product p){
        //String name, double price, String modifiedDate, int quantity, boolean isInStock
        return new Product(p.name, p.price, p.modifiedDate, 1, p.isInStock);
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
