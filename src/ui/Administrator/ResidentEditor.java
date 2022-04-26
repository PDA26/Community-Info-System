package ui.Administrator;

import model.Resident;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ResidentEditor {
    private JTextField textFieldName;
    private JTextField textFieldGender;
    private JSpinner spinnerDob;
    private JTextField textFieldAddress;
    private JTextField textFieldCommunity;
    private JPanel panelResidentEditor;

    public static Resident showResidentEditor(Component parent, Resident resident) {
        ResidentEditor editor = new ResidentEditor();
        String title;
        if (resident == null) {
            title = "Create Resident Info";
        } else {
            editor.textFieldName.setText(resident.name);
            editor.spinnerDob.getModel().setValue(resident.dob);
            editor.textFieldGender.setText(resident.gender);
            editor.textFieldAddress.setText(resident.address);
            editor.textFieldCommunity.setText(resident.community);
            title = "Edit Person Info";
        }
        int selection = JOptionPane.showConfirmDialog(parent,
                editor.panelResidentEditor,
                title,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (selection == JOptionPane.OK_OPTION) {
            if (resident == null) {
                resident = new Resident();
            }
            String name = editor.textFieldName.getText();
            String gender = editor.textFieldGender.getText();
            Date dob = (Date) editor.spinnerDob.getValue();
            String address = editor.textFieldAddress.getText();
            String community = editor.textFieldCommunity.getText();

            if (name.isBlank()) {
                JOptionPane.showMessageDialog(editor.panelResidentEditor, "Name empty!");
                return null;
            }
            if((gender.toLowerCase().compareTo("male") != 0)
                    && (gender.toLowerCase().compareTo("female") != 0)){
                JOptionPane.showMessageDialog(editor.panelResidentEditor, "Wrong input of gender!");
                return null;
            }
            if (address.isBlank()) {
                JOptionPane.showMessageDialog(editor.panelResidentEditor, "Address empty!");
                return null;
            }
            if (community.isBlank()) {
                JOptionPane.showMessageDialog(editor.panelResidentEditor, "Community empty!");
                return null;
            }

            resident.name = name;
            resident.gender = gender;
            resident.dob = dob;
            resident.address = address;
            resident.community = community;
            return resident;
        } else {
            return null;
        }
    }

    private void createUIComponents() {
        spinnerDob = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerDob, "MM/dd/yyyy");
        spinnerDob.setEditor(dateEditor);
    }
}