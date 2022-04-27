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
import java.util.Date;

public class Main {
    private JPanel JPanelMain;
    private JPanel JPanelContent;
    private JTextField textFieldUsr;
    private JTextField textFieldPwd;
    private JButton signInButton;
    private JButton signUpButton;
    private JRadioButton residentRadioButton;
    private JRadioButton managementRadioButton;
    private JRadioButton marketRadioButton;
    private JTable tableResident;
    private Community residentDir;

    JFrame frame = new JFrame("Main");


    public Main(){
        JPanelContent.add("Resident", new Resident().getPanel());
        ButtonGroup buttonGroup_Main = new ButtonGroup();
        buttonGroup_Main.add(residentRadioButton);
        buttonGroup_Main.add(managementRadioButton);
        buttonGroup_Main.add(marketRadioButton);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buttonGroup_Main.isSelected(residentRadioButton.getModel())
                && textFieldUsr.getText().compareTo("1") == 0
                && textFieldPwd.getText().compareTo("1") == 0){
                    //jump to resident
                    ((CardLayout) JPanelContent.getLayout()).show(JPanelContent, "Resident");
                }else{
                    JOptionPane.showMessageDialog(JPanelMain, "Wrong usrname or pwd!!!");
                }
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        try {
            OSInfo.OSType osType = AccessController.doPrivileged(OSInfo.getOSTypeAction());
            if (osType == OSInfo.OSType.WINDOWS) {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } else {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        Main main = new Main();
        JFrame frame = new JFrame("Main");
        frame.setContentPane(main.JPanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1200, 800);
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
