package model;

public class Community {

    private String communityName;
    private String communityAddress;
    private String communityZipcode;

    public Community() {
    }

    public Community(String communityName, String communityAddress, String communityZipcode) {
        this.communityName = communityName;
        this.communityAddress = communityAddress;
        this.communityZipcode = communityZipcode;
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

    @Override
    public String toString() {
        return "Community{" +
                "communityName='" + communityName + '\'' +
                ", communityAddress='" + communityAddress + '\'' +
                ", communityZipcode='" + communityZipcode + '\'' +
                '}';
    }
}
