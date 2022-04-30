package model.OrderData;

import model.Product;
import jdk.jfr.Name;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.DuplicateFormatFlagsException;
import java.util.List;

/**
 * Order
 */
public class Order extends AbstractTableModel {
    private static int idCount = 0;
    private final int id;
    private Date date;
    private List<Product> itemList;

    public enum OrderStatus{
        PENDING, ACCEPTED, FINISHED
    }
    OrderStatus status;

    public Order(List<Product> input) {
        this.id = idCount++;
        this.itemList = input;
        status = OrderStatus.PENDING;
        //this.date = new Date();
    }
    public Order() {
        this.id = idCount++;
        this.itemList = new ArrayList<>();
        status = OrderStatus.PENDING;
        //this.date = new Date();
    }
    public int addProduct(Product p){
        for(Product curr : itemList){
            if(curr.getName().equals(p.getName()) && curr.getPrice() == p.getPrice()){
                curr.quantity = curr.quantity + p.quantity;
                return p.quantity;
            }
        }
        itemList.add(p);
        fireTableRowsInserted(itemList.size() - 1, itemList.size() - 1);
        return p.getQuantity();
    }
    public void removeItem(int row){
        itemList.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public List<Product> getItemList() {
        return itemList;
    }

    public void setItemList(List<Product> itemList) {
        this.itemList = itemList;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }



    @Override
    public int getRowCount() {
        return itemList.size();
    }

    @Override
    public int getColumnCount() {
        return Product.class.getFields().length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        try {
            return Product.class.getFields()[col].get(itemList.get(row));
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
