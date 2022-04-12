package model;

import java.util.Date;

public class ShopItem {
    String name;
    int price;
    String description;
    String spec; // eg: 6pcs, 1pcs, 600ml
    Date mfg; //Manufacture Date
    Date exp; //Expiration Date
    int cnt;

    public ShopItem(String name, int price, int cnt, Date mfg, Date exp) {
        this.name = name;
        this.price = price;
        this.description = "N/A";
        this.spec = "N/A";
        this.mfg = mfg;
        this.exp = exp;
    }

    public ShopItem(String name, int price, String spec, int cnt, Date mfg, Date exp , String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.spec = spec;
        this.mfg = mfg;
        this.exp = exp;
    }

    public boolean isSame(ShopItem a){
        if(this.name.compareTo(a.name) == 0
        && this.description.compareTo(a.description) == 0
        && this.mfg.compareTo(a.mfg) == 0
        && this.exp.compareTo(a.exp) == 0){
            return true;
        }
        return false;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Date getMfg() {
        return mfg;
    }

    public void setMfg(Date mfg) {
        this.mfg = mfg;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }
}
