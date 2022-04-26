package model.CommunityData;

import jdk.jfr.Name;
import model.CommunityInfo;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Communities extends AbstractTableModel {
    List<model.CommunityInfo> dir;

    public Communities() {
        this.dir = new ArrayList<>();
    }

    public void add(model.CommunityInfo c) {
        dir.add(c);
        fireTableRowsInserted(dir.size() - 1, dir.size() - 1);
    }

    public model.CommunityInfo get(int i) { return dir.get(i); }


    @Override
    public int getRowCount() {
        return dir.size();
    }

    @Override
    public int getColumnCount() {
        return model.CommunityInfo.class.getFields().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            return model.CommunityInfo.class.getFields()[columnIndex].get(dir.get(rowIndex));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getColumnName (int column) {
        Field field = CommunityInfo.class.getFields()[column];
        jdk.jfr.Name name = field.getAnnotation(Name.class);
        if ( name != null) {
            return name.value();
        }
        return field.getName();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return CommunityInfo.class.getFields()[columnIndex].getType();
    }
}
