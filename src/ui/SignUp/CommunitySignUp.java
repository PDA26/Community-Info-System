package ui.SignUp;

//import com.google.gson.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.SignUp.AccountCatalog;
import model.SignUp.AccountInfo;
import ui.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.Map;

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
            public void actionPerformed(ActionEvent ee) {


                String Username = CommunitySignUp.this.txtUsername.getText();
                String Password = String.valueOf(CommunitySignUp.this.txtPassword.getPassword());

                System.out.println(Username);
                System.out.println(Password);

                JsonObject sign_up_object = null;
                try (FileReader reader = new FileReader("LogAndSign.json")) {
                    sign_up_object = JsonParser.parseReader(reader).getAsJsonObject();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                assert sign_up_object != null;

                JsonArray array = sign_up_object.get("resident").getAsJsonArray();
                for (int i = 0; i < array.size(); i++) {
                    JsonObject curr = array.get(i).getAsJsonObject();
                    if (Username.equals(curr.get("usr").getAsString()) &&
                        Password.equals(curr.get("pwd").getAsString())) {
                        //System.out.println("Overlapped usr and pwd");
                        JOptionPane.showMessageDialog(CommunitySignUp.this.panelCommunitySignUp,
                                                      "Overlapped usr and pwd!");
                        txtPassword.setText("");
                        txtUsername.setText("");
                        return;
                    }
                }
                JsonObject res = new JsonObject();
                res.addProperty("usr", Username);
                res.addProperty("pwd", Password);
                array.add(res);
                sign_up_object.add("resident", array);
                //String str = finalSign_up_object.getAsString();
                Gson gson = new Gson();
                try (Writer writer = new FileWriter("LogAndSign.json")) {
                    gson.toJson(sign_up_object, writer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("New usr and pwd successfully added!");
                JOptionPane.showMessageDialog(CommunitySignUp.this.panelCommunitySignUp,
                                              "Account saved!");
                txtPassword.setText("");
                txtUsername.setText("");
                Main.gotoPanel("SignIn");
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
        return panelCommunitySignUp;
    }
}
