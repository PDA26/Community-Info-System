package model;

import jdk.jfr.Name;

import java.util.Date;

public class Resident {
    private static int idCount = 0;
    @Name("ID")
    public final int id;
    @Name("Name")
    public String name;
    @Name("Gender")
    public String gender;
    @Name("Date of Birth")
    public Date dob;
    @Name("Address")
    public String address;
    @Name("Community")
    public String community;
    @Name("Community")
    public String AptNo;

    public Resident(String name, String gender, Date dob, String address, String community, String AptNo) {
        id = idCount++;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.community = community;
        this.AptNo = AptNo;
    }

    public Resident() {
        id = idCount++;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAptNo() {
        return AptNo;
    }

    public void setAptNo(String aptNo) {
        AptNo = aptNo;
    }

    public int getId() {
        return id;
    }
}
