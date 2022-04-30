package ui.SignUp;

import model.SignUp.AccountCatalog;
import model.SignUp.AccountInfo;
import ui.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarketSignUp {
    private JPanel panelMarketSignUp;
    private JTextField txtUsername;
    private JButton btnConfirm;
    private JButton btnBack;
    private JPasswordField txtPassword;

    AccountCatalog accountCatalog = new AccountCatalog();
    AccountInfo accountInfo = new AccountInfo();

    public MarketSignUp() {

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String Username = MarketSignUp.this.txtUsername.getText();
                String Password = String.valueOf(MarketSignUp.this.txtPassword.getPassword());

                if (Username.isBlank()) {
                    JOptionPane.showMessageDialog(MarketSignUp.this.panelMarketSignUp, "Miss Username! Account not saved.");
                }
                else if (Password.isBlank()) {
                    JOptionPane.showMessageDialog(MarketSignUp.this.panelMarketSignUp, "Miss Password! Account not saved.");
                }
                else {
                    accountInfo.setUsername(Username);
                    accountInfo.setPassword(Password);
                    model.SignUp.AccountCatalog.addAccount(accountInfo);
//                    for (int i=0; i<model.SignUp.AccountCatalog.getAccounts().size(); i++) {
//                        System.out.println(model.SignUp.AccountCatalog.getAccounts().get(i).Username);
//                        System.out.println(model.SignUp.AccountInfo.Username);
//                    }

                    JOptionPane.showMessageDialog(MarketSignUp.this.panelMarketSignUp, "Account saved!");
                    txtPassword.setText("");
                    txtUsername.setText("");
                    Main.gotoPanel("SignIn");
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.gotoPanel("SignIn");
            }
        });


    }

    public JComponent getPanel() {
        return panelMarketSignUp;
    }
}
