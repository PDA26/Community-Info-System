package ui;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Community;
import model.SignUp.AccountInfo;
import model.SignUp.AccountCatalog;
import ui.Administrator.Resident;
import ui.Community.communityView.communityManagement.CommunityManagement;
import ui.Community.mainJPanel.communityMain;
import ui.SignUp.CommunitySignUp;
import ui.SignUp.DeliverySignUp;
import ui.SignUp.MarketSignUp;
import ui.SuperMarket.mainJPanel.MainMarket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class SignIn {
    private JTextField textFieldUsr;
    private JPasswordField textFieldPwd;
    private JButton signInButton;
    private JButton signUpButton;
    private JRadioButton communityRadioButton;
    private JRadioButton deliveryRadioButton;
    private JRadioButton marketRadioButton;
    private JPanel panel;
    private JTable tableResident;
    private Community residentDir;

    private AccountInfo accountInfo;
    private AccountCatalog accountCatalog;

    public JPanel getPanel() {
        return panel;
    }


    public SignIn() {
        Main.addPanel(new Resident().getPanel(), "Resident");
        Main.addPanel(new communityMain().getPanel(), "Community");
        Main.addPanel(new MainMarket().getPanel(), "Market");
        Main.addPanel(new CommunitySignUp().getPanel(), "SignUpCommunity");
        Main.addPanel(new MarketSignUp().getPanel(), "SignUpMarket");
        Main.addPanel(new DeliverySignUp().getPanel(), "SignUpDelivery");
        Main.addPanel(new CommunityManagement().getPanel(), "CommunityManagement");

        ButtonGroup buttonGroup_Main = new ButtonGroup();
        buttonGroup_Main.add(communityRadioButton);
        buttonGroup_Main.add(deliveryRadioButton);
        buttonGroup_Main.add(marketRadioButton);

        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //json
                JsonObject login_object = null;
                try (FileReader reader = new FileReader("LogAndSign.json")){
                    login_object = JsonParser.parseReader(reader).getAsJsonObject();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                assert login_object != null;

                if (buttonGroup_Main.isSelected(communityRadioButton.getModel())) {
                    JsonArray array = login_object.get("resident").getAsJsonArray();
                    for(int i = 0; i < array.size(); i++) {
                        JsonObject curr = array.get(i).getAsJsonObject();
                        if (textFieldUsr.getText().equals(curr.get("usr").getAsString()) &&
                            new String(textFieldPwd.getPassword()).equals(curr.get("pwd").getAsString())) {
                            //jump to resident
                            Main.gotoPanel("Community");
                            System.out.println("Log-in to Community succeeded");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(panel,
                                                  "Wrong username or pwd of Community!!!");
                } else if (buttonGroup_Main.isSelected(deliveryRadioButton.getModel())) {
                    JsonArray array = login_object.get("delivery").getAsJsonArray();
                    for(int i = 0; i < array.size(); i++) {
                        JsonObject curr = array.get(i).getAsJsonObject();
                        if (textFieldUsr.getText().equals(curr.get("usr").getAsString()) &&
                            new String(textFieldPwd.getPassword()).equals(curr.get("pwd").getAsString())) {
                            //jump to resident
                            Main.gotoPanel("Delivery");
                            System.out.println("Log-in to Delivery succeeded");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(panel,
                                                  "Wrong username or pwd of Delivery!!!");
                } else if (buttonGroup_Main.isSelected(marketRadioButton.getModel())) {
                    JsonArray array = login_object.get("market").getAsJsonArray();
                    for(int i = 0; i < array.size(); i++) {
                        JsonObject curr = array.get(i).getAsJsonObject();
                        if (textFieldUsr.getText().equals(curr.get("usr").getAsString()) &&
                            new String(textFieldPwd.getPassword()).equals(curr.get("pwd").getAsString())) {
                            //jump to resident
                            Main.gotoPanel("Market");
                            System.out.println("Log-in to Market succeeded");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(panel,
                                                  "Wrong username or pwd of Market!!!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Wrong enter!!!");
                }
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonGroup_Main.isSelected(communityRadioButton.getModel())) {
                    //jump to Community Sign Up
                    Main.gotoPanel("SignUpCommunity");
                } else if (buttonGroup_Main.isSelected(marketRadioButton.getModel())) {
                    //jump to Community Sign Up
                    Main.gotoPanel("SignUpMarket");
                } else if (buttonGroup_Main.isSelected(deliveryRadioButton.getModel())) {
                    //jump to Community Sign Up
                    Main.gotoPanel("SignUpDelivery");
                }
            }
        });

        //System.out.println("test" + accountCatalog);
    }

    private void createUIComponents() {
        residentDir = new Community();
        tableResident = new JTable(residentDir);
        tableResident.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
