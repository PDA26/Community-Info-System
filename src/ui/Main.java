package ui;

import model.Community;
import model.Resident;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.text.DateFormat;
import java.util.Date;

public class Main {
    private JPanel JPanel;
    private JPanel JPanelMain;
    private JTextField textField1;
    private JTextField textField2;
    private JButton signInButton;
    private JButton signUpButton;
    private JButton logOutButton;
    private JRadioButton residentRadioButton;
    private JRadioButton managementRadioButton;
    private JRadioButton supermarketRadioButton;
    private JButton addButton;
    private JButton modifyButton;
    private JButton deleteButton;
    private JTable tableResident;
    private Community residentDir;
    public Main(){
        addButton.addActionListener(actionEvent -> {
            Resident p = ResidentEditor.showResidentEditor(tableResident, null);
            if (p != null) {
                residentDir.add(p);
            }
        });
        modifyButton.addActionListener(actionEvent -> {
            int selected = tableResident.getSelectedRow();
            if (selected != -1) {
                Resident p = residentDir.get(selected);
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        Main main = new Main();
        frame.setContentPane(main.JPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void createUIComponents() {
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
