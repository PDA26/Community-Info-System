package ui.Administrator;

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
    private JButton addButton;
    private JButton modifyButton;
    private JButton deleteButton;
    private JPanel panelResOverview;

    public Resident() {
        addButton.addActionListener(actionEvent -> {
            model.Resident p = ResidentEditor.showResidentEditor(tableResident, null);
            if (p != null) {
                residentDir.add(p);
            }
        });
        modifyButton.addActionListener(actionEvent -> {
            int selected = tableResident.getSelectedRow();
            if (selected != -1) {
                model.Resident p = residentDir.get(selected);
                p = ResidentEditor.showResidentEditor(tableResident, p);
                if (p != null) {
                    residentDir.fireTableRowsUpdated(selected, selected);
                }
            }
        });
        deleteButton.addActionListener(actionEvent -> {
            int selected = tableResident.getSelectedRow();
            if (selected != -1) {
                residentDir.delete(selected);
                //abnormalPatientModel.notifyUpdate();
            }
        });
    }

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
