package model;

import model.CommunityData.CommunityModel;

public class CurrentApt {

    String currentApt;

    private static CurrentApt instance = new CurrentApt();
    public static CurrentApt getInstance() {
        return instance;
    }



    public CurrentApt() {

    }

    public String getCurrentApt() {
        return currentApt;
    }

    public void setCurrentApt(String currentApt) {
        this.currentApt = currentApt;
    }
}
