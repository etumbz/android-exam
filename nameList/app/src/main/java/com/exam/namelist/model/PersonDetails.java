package com.exam.namelist.model;

public class PersonDetails implements IPersonDetails {

    private String fName;

    private String lName;

    private String bday;

    private int age;

    private String email;

    private String mobileNum;

    private String address;

    private String cntctPrsn;

    private String cntctPrsnNum;

    public PersonDetails(String fName, String lName, String bday, int age, String email, String mobileNum, String address, String cntctPrsn, String cntctPrsnNum) {
        this.fName = fName;
        this.lName = lName;
        this.bday = bday;
        this.age = age;
        this.email = email;
        this.mobileNum = mobileNum;
        this.address = address;
        this.cntctPrsn = cntctPrsn;
        this.cntctPrsnNum = cntctPrsnNum;
    }

    public PersonDetails() {

    }

    @Override
    public String getFname() {
        return fName;
    }

    @Override
    public String getLname() {
        return lName;
    }

    @Override
    public String getBday() {
        return bday;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getMobileNum() {
        return mobileNum;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getCntctPrsn() {
        return cntctPrsn;
    }

    @Override
    public String getCntctPrsnNum() {
        return cntctPrsnNum;
    }
}
