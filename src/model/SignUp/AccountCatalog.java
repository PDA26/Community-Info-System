package model.SignUp;

import java.util.ArrayList;

public class AccountCatalog {

    private static ArrayList<AccountInfo> accounts;

    public AccountCatalog() { this.accounts = new ArrayList<>(); }

    public static ArrayList<AccountInfo> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<AccountInfo> accounts) {
        this.accounts = accounts;
    }

    public static ArrayList<AccountInfo> addAccount(AccountInfo accountInfo) {
        AccountInfo newAccount = new AccountInfo();
        accounts.add(newAccount);
        return accounts;
    }


//    public VitalSigns addNewVitals(){
//        VitalSigns newVitals=new VitalSigns();
//        history.add(newVitals);
//        return newVitals;
//    }


}
