package model.CommunityData;

import jdk.jfr.Name;
import model.OrderData.AptOrderCatalog;
import model.OrderData.CommunityOrderCatalog;
import model.OrderData.Order;

import java.util.*;

public class CommunityInfo {

    private static int idCount = 0;
    @Name("ID")
    public int id;
    @Name("Name")
    public String communityName;
    @Name("Address")
    public String communityAddress;
    @Name("ZipCode")
    public String communityZipcode;
    @Name("PhoneNum")
    public String communityPhone;

    private List<String> aptList;
    private CommunityOrderCatalog orders;


    public CommunityInfo() {

        aptList = new ArrayList<>();
        orders = new CommunityOrderCatalog();

    }


    public CommunityInfo(String communityName, String communityAddress, String communityZipcode, String communityPhone) {
        id = idCount++;
        this.communityName = communityName;
        this.communityAddress = communityAddress;
        this.communityZipcode = communityZipcode;
        this.communityPhone = communityPhone;
        this.aptList = new ArrayList<>();
        this.orders = new CommunityOrderCatalog();
    }

    public CommunityOrderCatalog getOrders() {
        return orders;
    }

//    public CommunityOrderCatalog getPendingOrder() {
//        CommunityOrderCatalog res = new CommunityOrderCatalog();
//        for (AptOrderCatalog ap : orders.getMap().values()) {
//            for (Order o : ap.getList()) {
//                if (o.getStatus() == Order.OrderStatus.PENDING) {
//                    res.getMap().
//                }
//            }
//        }
//        return res;
//    }

    public void setOrders(CommunityOrderCatalog orders) {
        this.orders = orders;
    }

    public List<String> getAptList() {
        return aptList;
    }

    public void setAptList(List<String> aptList) {
        this.aptList = aptList;
    }

    public void addApt(String s){
        for(String name : aptList){
            if(name.equals(s)){
                return;
            }
        }
        aptList.add(s);
        orders.addApt(s);
    }


    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityAddress() {
        return communityAddress;
    }

    public void setCommunityAddress(String communityAddress) {
        this.communityAddress = communityAddress;
    }

    public String getCommunityZipcode() {
        return communityZipcode;
    }

    public void setCommunityZipcode(String communityZipcode) {
        this.communityZipcode = communityZipcode;
    }

    public String getCommunityPhone() {
        return communityPhone;
    }

    public void setCommunityPhone(String communityPhone) {
        this.communityPhone = communityPhone;
    }
}
