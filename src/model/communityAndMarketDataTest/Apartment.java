package model.communityAndMarketDataTest;

public class Apartment {

    private String aptNo;
    private String orderTime;
    private int orderId; //下单的id，用来获取最新的下单时间

    public Apartment() {
    }

    public Apartment(String aptNo, String orderTime, int orderId) {
        this.aptNo = aptNo;
        this.orderTime = orderTime;
        this.orderId = orderId;
    }

    public String getAptNo() {
        return aptNo;
    }

    public void setAptNo(String aptNo) {
        this.aptNo = aptNo;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "aptNo='" + aptNo + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}
