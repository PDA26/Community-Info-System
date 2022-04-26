package model.CommunityData;

import java.util.Collection;
import java.util.HashMap;

public class CommunityModel {

    private static CommunityModel instance = new CommunityModel();

    public static CommunityModel getInstance() { return instance; }

    public CommunityModel() { };

    model.CommunityInfo currentCommunity;
    HashMap<String, model.CommunityInfo> communityInfoHashMap = new HashMap<>();

    public Collection<model.CommunityInfo> getCommunities() { return communityInfoHashMap.values(); }

    public void addNewCommunity(model.CommunityInfo communityInfo) { communityInfoHashMap.putIfAbsent(communityInfo.communityName, communityInfo); }

    public model.CommunityInfo getCurrentCommunity() { return currentCommunity; }

    public void setCurrentCommunity(String communityInfo) {
        this.currentCommunity = communityInfoHashMap.get(communityInfo);
    }


}
