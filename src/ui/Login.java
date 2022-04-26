package ui;

import model.Community;
import sun.awt.OSInfo;
import ui.Administrator.Resident;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.AccessController;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

public class Login {
    private JTextField textFieldUsr;
    private JPasswordField textFieldPwd;
    private JButton signInButton;
    private JButton signUpButton;
    private JRadioButton residentRadioButton;
    private JRadioButton managementRadioButton;
    private JRadioButton marketRadioButton;
    private JPanel panel;
    private JTable tableResident;
    private Community residentDir;


    public JPanel getPanel() {
        return panel;
    }


    public Login() {
        Main.addPanel(new Resident().getPanel(), "Resident");
        ButtonGroup buttonGroup_Main = new ButtonGroup();
        buttonGroup_Main.add(residentRadioButton);
        buttonGroup_Main.add(managementRadioButton);
        buttonGroup_Main.add(marketRadioButton);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonGroup_Main.isSelected(residentRadioButton.getModel())
                    && textFieldUsr.getText().equals("1")
                    && Arrays.equals(textFieldPwd.getPassword(), "1".toCharArray())) {
                    //jump to resident
                    Main.gotoPanel("Resident");
                } else {
                    JOptionPane.showMessageDialog(panel, "Wrong username or pwd!!!");
                }
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
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
