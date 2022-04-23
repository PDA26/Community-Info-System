package model;

import jdk.jfr.Name;

public class CommunityInfo {
    @Name("communityName")
    public String communityName;
    @Name("communityAdd")
    public String communityAdd;
    @Name("communityZip")
    public String communityZip;
    @Name("communityPhone")
    public String communityPhone;

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
