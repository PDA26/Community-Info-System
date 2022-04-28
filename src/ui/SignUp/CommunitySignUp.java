package ui.SignUp;

import model.SignUp.AccountCatalog;
import model.SignUp.AccountInfo;
import ui.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CommunitySignUp {

    private JPanel panelCommunitySignUp;
    private JButton btnBack;
    private JButton btnConfirm;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    AccountCatalog accountCatalog = new AccountCatalog();
    AccountInfo accountInfo = new AccountInfo();

    public CommunitySignUp() {

//        CommunitySignUp newCommunity;

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String Username = CommunitySignUp.this.txtUsername.getText();
                String Password = String.valueOf(CommunitySignUp.this.txtPassword.getPassword());

                if (Username.isBlank()) {
                    JOptionPane.showMessageDialog(CommunitySignUp.this.panelCommunitySignUp, "Miss Username! Account not saved.");
                }
                else if (Password.isBlank()) {
                    JOptionPane.showMessageDialog(CommunitySignUp.this.panelCommunitySignUp, "Miss Password! Account not saved.");
                }
                else {
                    accountInfo.setUsername(Username);
                    accountInfo.setPassword(Password);
                    model.SignUp.AccountCatalog.addAccount(accountInfo);
//                    for (int i=0; i<model.SignUp.AccountCatalog.getAccounts().size(); i++) {
//                        System.out.println(model.SignUp.AccountCatalog.getAccounts().get(i).Username);
//                        System.out.println(model.SignUp.AccountInfo.Username);
//                    }

                    JOptionPane.showMessageDialog(CommunitySignUp.this.panelCommunitySignUp, "Account saved!");
                    txtPassword.setText("");
                    txtUsername.setText("");
                    Main.gotoPanel("Login");
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.gotoPanel("Login");
            }
        });

    }

    public JComponent getPanel() {
        return panelCommunitySignUp;
    }
}
