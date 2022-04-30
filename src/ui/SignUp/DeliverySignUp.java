package ui.SignUp;

import model.SignUp.AccountCatalog;
import model.SignUp.AccountInfo;
import ui.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeliverySignUp {
    private JPanel panelDeliverySignUp;
    private JTextField txtUsername;
    private JButton btnBack;
    private JButton btnConfirm;
    private JPasswordField txtPassword;

    AccountCatalog accountCatalog = new AccountCatalog();
    AccountInfo accountInfo = new AccountInfo();

    public DeliverySignUp() {

        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String Username = DeliverySignUp.this.txtUsername.getText();
                String Password = String.valueOf(DeliverySignUp.this.txtPassword.getPassword());

                if (Username.isBlank()) {
                    JOptionPane.showMessageDialog(DeliverySignUp.this.panelDeliverySignUp, "Miss Username! Account not saved.");
                }
                else if (Password.isBlank()) {
                    JOptionPane.showMessageDialog(DeliverySignUp.this.panelDeliverySignUp, "Miss Password! Account not saved.");
                }
                else {
                    accountInfo.setUsername(Username);
                    accountInfo.setPassword(Password);
                    model.SignUp.AccountCatalog.addAccount(accountInfo);
//                    for (int i=0; i<model.SignUp.AccountCatalog.getAccounts().size(); i++) {
//                        System.out.println(model.SignUp.AccountCatalog.getAccounts().get(i).Username);
//                        System.out.println(model.SignUp.AccountInfo.Username);
//                    }

                    JOptionPane.showMessageDialog(DeliverySignUp.this.panelDeliverySignUp, "Account saved!");
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
        return panelDeliverySignUp;
    }
}
