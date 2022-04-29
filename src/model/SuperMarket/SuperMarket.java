package model.SuperMarket;

import model.OrderData.MasterOrderList;
import model.SuperMarket.finCenter.FinCenter;
import model.OrderData.OrderCenter;
import model.SuperMarket.wareHouse.Warehouse;

public class SuperMarket {
    private static SuperMarket instance = new SuperMarket();
    public static SuperMarket getInstance() {
        return instance;
    }
    Warehouse wh;
    OrderCenter oc;
    FinCenter fc;

    public SuperMarket() {
        this.wh = new Warehouse();
        this.oc = new OrderCenter();
        this.fc = new FinCenter();
    }

    public Warehouse getWh() {
        return wh;
    }

    public void setWh(Warehouse wh) {
        this.wh = wh;
    }

    public OrderCenter getOc() {
        return oc;
    }

    public void setOc(OrderCenter oc) {
        this.oc = oc;
    }

    public FinCenter getFc() {
        return fc;
    }

    public void setFc(FinCenter fc) {
        this.fc = fc;
    }
}
