package com.intelligenttransportation;

import java.util.List;

public class User {
    private String username;
    private String password;
    private String type;

    private List<Car> cars;
    private boolean isLogged;
    private boolean isBoundCar;


    public User() {
    }

    public User(String username, String password, String type, List<Car> cars, boolean isLogged, boolean isBoundCar) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.cars = cars;
        this.isLogged = isLogged;
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public boolean isBoundCar() {
        return isBoundCar;
    }

    public void setBoundCar(boolean boundCar) {
        isBoundCar = boundCar;
    }
}
