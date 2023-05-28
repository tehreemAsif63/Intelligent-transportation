package com.intelligenttransportation.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String username;
    private String password;
    private String type;
    private Car car;
    private boolean isBoundCar;


    public User() {
    }

    public User(String username, String password, String type, Car car,  boolean isBoundCar) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.car = car;
        this.isBoundCar = isBoundCar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getUserName() {
        return null;
    }

    public Object getPassWord() {
        return null;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public boolean isBoundCar() {
        return isBoundCar;
    }

    public void setBoundCar(boolean boundCar) {
        isBoundCar = boundCar;
    }
}
