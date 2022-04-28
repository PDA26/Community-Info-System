package model;

import jdk.jfr.Name;

public class CommunityInfo {
    @Name("communityName")
    public String communityName;
    @Name("communityAddress")
    public String communityAddress;
    @Name("communityZipcode")
    public String communityZipcode;
    @Name("communityPhone")
    public String communityPhone;

    public CommunityInfo(String communityName, String communityAddress, String communityZipcode, String communityPhone) {
        this.communityName = communityName;
        this.communityAddress = communityAddress;
        this.communityZipcode = communityZipcode;
        this.communityPhone = communityPhone;
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
