package ui;

import model.Community;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.text.DateFormat;
import java.util.Date;

public class Resident {
    private JTable tableResident;
    private Community residentDir;

    private JTabbedPane tabbedPane;
    private JPanel panelResident;
    private JTable table1;
    private JButton addButton;
    private JButton modifyButton;
    private JButton deleteButton;
    private JPanel panelResOverview;

    public JPanel getPanel() {
        return panelResident;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableCellRenderer DateRenderer = new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                if (value instanceof Date) {
                    this.setText(DateFormat.getDateInstance().format(value));
                } else {
                    super.setValue(value);
                }
            }
        };
        DefaultTableCellRenderer DateTimeRenderer = new DefaultTableCellRenderer() {
            @Override
            protected void setValue(Object value) {
                if (value instanceof Date) {
                    this.setText(DateFormat.getDateTimeInstance().format(value));
                } else {
                    super.setValue(value);
                }
            }
        };

        residentDir = new Community();
        tableResident = new JTable(residentDir);
        // tableResident.setDefaultRenderer(Date.class, DateRenderer);
        tableResident.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
