package ui;

import model.Community;
import model.SignUp.AccountInfo;
import model.SignUp.AccountCatalog;
import model.SignUp.AccountInfo;
import ui.Administrator.Resident;
import ui.Community.mainJPanel.communityMain;
import ui.SignUp.CommunitySignUp;
import ui.SignUp.DeliverySignUp;
import ui.SignUp.MarketSignUp;
import ui.SuperMarket.mainJPanel.MainMarket;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private AccountInfo accountInfo;
    private AccountCatalog accountCatalog;

    public JPanel getPanel() {
        return panel;
    }


    public Login() {
        Main.addPanel(new Resident().getPanel(), "Resident");
        Main.addPanel(new communityMain().getPanel(), "Community");
        Main.addPanel(new MainMarket().getPanel(), "Market");
        Main.addPanel(new CommunitySignUp().getPanel(), "SignUpCommunity");
        Main.addPanel(new MarketSignUp().getPanel(), "SignUpMarket");
        Main.addPanel(new DeliverySignUp().getPanel(), "SignUpDelivery");

        ButtonGroup buttonGroup_Main = new ButtonGroup();
        buttonGroup_Main.add(residentRadioButton);
        buttonGroup_Main.add(managementRadioButton);
        buttonGroup_Main.add(marketRadioButton);

//        AccountCatalog accountCatalog = new AccountCatalog();
//        String name = String.valueOf(accountCatalog.getAccounts());
//        System.out.println(name);

        signInButton.addActionListener(new ActionListener() {

//            AccountInfo accountInfo = new AccountInfo();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonGroup_Main.isSelected(residentRadioButton.getModel())) {
                    if (accountCatalog.getAccounts().size() > 0) {
                        for (int i = 0; i < accountCatalog.getAccounts().size(); i++) {
                            if (textFieldUsr.getText()
                                            .equals(model.SignUp.AccountCatalog.getAccounts()
                                                                               .get(i).Username) &&
                                Arrays.equals(textFieldPwd.getPassword(),
                                              model.SignUp.AccountCatalog.getAccounts()
                                                                         .get(i).Password.toCharArray())) {
                                //jump to resident
                                Main.gotoPanel("Resident");
                            } else {
                                JOptionPane.showMessageDialog(panel,
                                                              "Wrong username or pwd of Delivery!!!");
                                break;
                            }
                        }
                    }
                } else if (buttonGroup_Main.isSelected(managementRadioButton.getModel())) {
                    if (accountCatalog.getAccounts().size() > 0) {
                        for (int i = 0; i < accountCatalog.getAccounts().size(); i++) {
                            if (textFieldUsr.getText()
                                            .equals(model.SignUp.AccountCatalog.getAccounts()
                                                                               .get(i).Username) &&
                                Arrays.equals(textFieldPwd.getPassword(),
                                              model.SignUp.AccountCatalog.getAccounts()
                                                                         .get(i).Password.toCharArray())) {
                                //jump to resident
                                Main.gotoPanel("Community");
                            } else {
                                JOptionPane.showMessageDialog(panel,
                                                              "Wrong username or pwd of Community!!!");
                                break;
                            }
                        }
                    }
                } else if (buttonGroup_Main.isSelected(marketRadioButton.getModel())) {
                    if (accountCatalog.getAccounts().size() > 0) {
                        for (int i = 0; i < accountCatalog.getAccounts().size(); i++) {
                            if (textFieldUsr.getText()
                                            .equals(model.SignUp.AccountCatalog.getAccounts()
                                                                               .get(i).Username) &&
                                Arrays.equals(textFieldPwd.getPassword(),
                                              model.SignUp.AccountCatalog.getAccounts()
                                                                         .get(i).Password.toCharArray())) {
                                //jump to resident
                                Main.gotoPanel("Market");
                            } else {
                                JOptionPane.showMessageDialog(panel,
                                                              "Wrong username or pwd of Market!!!");
                                break;
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Wrong enter!!!");
                }
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buttonGroup_Main.isSelected(managementRadioButton.getModel())) {
                    //jump to Community Sign Up
                    Main.gotoPanel("SignUpCommunity");
                } else if (buttonGroup_Main.isSelected(marketRadioButton.getModel())) {
                    //jump to Community Sign Up
                    Main.gotoPanel("SignUpMarket");
                } else if (buttonGroup_Main.isSelected(residentRadioButton.getModel())) {
                    //jump to Community Sign Up
                    Main.gotoPanel("SignUpDelivery");
                }
            }
        });

        System.out.println("test" + accountCatalog);
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
