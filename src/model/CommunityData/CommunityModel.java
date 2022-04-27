package model.CommunityData;

import model.CommunityInfo;

import java.util.Collection;
import java.util.HashMap;

public class CommunityModel {

    private static CommunityModel instance = new CommunityModel();

    public static CommunityModel getInstance() { return instance; }

    public CommunityModel() { };

    CommunityInfo currentCommunity;
    HashMap<String, CommunityInfo> communityInfoHashMap = new HashMap<>();

    public Collection<CommunityInfo> getCommunities() { return communityInfoHashMap.values(); }

    public void addNewCommunity(CommunityInfo communityInfo) { communityInfoHashMap.putIfAbsent(communityInfo.communityName, communityInfo); }

    public CommunityInfo getCurrentCommunity() { return currentCommunity; }

    public void setCurrentCommunity(String communityInfo) {
        this.currentCommunity = communityInfoHashMap.get(communityInfo);
    }
}
