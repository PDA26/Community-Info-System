package model;

public class Apartment {

    String aptNo;
    //String orderTime;
    //int orderId;

    public Apartment() {
    }

    public Apartment(String aptNo, String orderTime, int orderId) {
        this.aptNo = aptNo;
        //this.orderTime = orderTime;
        //this.orderId = orderId;
    }

    public String getAptNo() {
        return aptNo;
    }

    public void setAptNo(String aptNo) {
        this.aptNo = aptNo;
    }

//    public String getOrderTime() {
//        return orderTime;
//    }
//
//    public void setOrderTime(String orderTime) {
//        this.orderTime = orderTime;
//    }
//
//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }

    @Override
    public String toString() {
        return "Apartment{" + "aptNo=" + aptNo + "";
    }
}
