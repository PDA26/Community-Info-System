package ui.Community;

import javax.swing.*;

public class residentManagement {


    private JPanel panelResidentManagement;
    private JButton btnBack;
    private JTable tableItem;
    private JTable tableCart;
    private JButton btnConfirm;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JTextField txtAptNo;
    private JButton btnAdd;

    public residentManagement() {

    }

    public JPanel getPanel() {
        return panelResidentManagement;
    }



    public static void main(String[] args) {
        new residentManagement();
    }
}
