package com.intelligenttransportation;


public class User {
    private String userName;
    private String passWord;
    private String type;
    private int hasCar;
    private String loginStatus;
    protected Car aCar;


    public Car getACar() {
        return aCar;
    }

    public void setACar(Car aCar) {
        this.aCar = aCar;
    }

    public User(String userName, String passWord, String type) {
        this.userName = userName;
        this.passWord = passWord;
        this.hasCar = hasCar;
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getHasCar() {
        return hasCar;
    }

    public String getType() {
        return type;
    }

    public void setHasCar(int hasCar) {
        this.hasCar = hasCar;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", Car ='" + hasCar + '\'' +
                ", login ='" + loginStatus + '\'' +
                ", type ='" + type + '\'' +
                '}';
    }
}
