package model;

import jdk.jfr.Name;

public class CommunityInfo {

    public String communityName;
    public String communityAdd;
    public String communityZip;
    public String communityPhone;

    public CommunityInfo() { }

    public CommunityInfo(String communityName, String communityAdd, String communityZip, String communityPhone) {
        this.communityName = communityName;
        this.communityAdd = communityAdd;
        this.communityZip = communityZip;
        this.communityPhone = communityPhone;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityAdd() {
        return communityAdd;
    }

    public void setCommunityAdd(String communityAdd) {
        this.communityAdd = communityAdd;
    }

    public String getCommunityZip() {
        return communityZip;
    }

    public void setCommunityZip(String communityZip) {
        this.communityZip = communityZip;
    }

    public String getCommunityPhone() {
        return communityPhone;
    }

    public void setCommunityPhone(String communityPhone) {
        this.communityPhone = communityPhone;
    }
}
