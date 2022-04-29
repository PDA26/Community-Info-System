package model.CommunityData;

import model.CommunityData.CommunityInfo;

import java.util.Collection;
import java.util.HashMap;

public class CommunityModel {

    private static CommunityModel instance;
    private CommunityInfo currentCommunity;
    private String currentAptNo;
    private HashMap<String, CommunityInfo> communityInfoHashMap;
    public static CommunityModel getInstance() {
        if(instance == null){
            instance = new CommunityModel();
        }
        return instance;
    }

    public CommunityModel() {
        this.communityInfoHashMap = new HashMap<>();
    };

    public Collection<CommunityInfo> getCommunities() { return communityInfoHashMap.values(); }

    public void addNewCommunity(CommunityInfo communityInfo) {
        communityInfoHashMap.putIfAbsent(communityInfo.communityName, communityInfo);
    }
    public CommunityInfo getCommunityByKey(String key){
        return communityInfoHashMap.getOrDefault(key, null);
    }
    public CommunityInfo getCurrentCommunity() { return currentCommunity; }

    public void setCurrentCommunity(String communityInfo) {
        this.currentCommunity = communityInfoHashMap.get(communityInfo);
    }

    public String getCurrentAptNo() {
        return currentAptNo;
    }

    public void setCurrentAptNo(String currentAptNo) {
        this.currentAptNo = currentAptNo;
    }
}
