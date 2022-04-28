package model.SignUp;

import jdk.jfr.Name;

public class AccountInfo {

    private static int idCount = 0;
    @Name("ID")
    public int id;
    @Name("Username")
    public String Username;
    @Name("Password")
    public String Password;

    public AccountInfo() {  }

    public AccountInfo(String Username, String Password) {
        id = idCount ++;
        this.Username = Username;
        this.Password = Password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

