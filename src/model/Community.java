package model;

import jdk.jfr.Name;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Community extends AbstractTableModel {
    List<Resident> dir;

    public Community() {
        this.dir = new ArrayList<>();
    }

    public void add(Resident p) {
        dir.add(p);
        fireTableRowsInserted(dir.size() - 1, dir.size() - 1);
    }

    public void delete(int idx) {
        dir.remove(idx);
        fireTableRowsDeleted(idx, idx);
    }

    public void delete(Resident p) {
        int row = dir.indexOf(p);
        delete(row);
    }

    public Resident get(int i) {
        return dir.get(i);
    }

    @Override
    public int getRowCount() {
        return dir.size();
    }

    @Override
    public int getColumnCount() {
        return Resident.class.getFields().length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        try {
            return Resident.class.getFields()[col].get(dir.get(row));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        Field field = Resident.class.getFields()[column];
        Name name = field.getAnnotation(Name.class);
        if (name != null) {
            return name.value();
        }
        return field.getName();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Resident.class.getFields()[columnIndex].getType();
    }
}
