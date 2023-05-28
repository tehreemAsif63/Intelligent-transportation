package com.intelligenttransportation.model;

import java.io.Serializable;

public class Car implements Serializable {
    private int id;
    private int name;
    private int imageSrc;

    public Car() {
    }

    public Car(int id, int name, int imageSrc) {
        this.id = id;
        this.name = name;
        this.imageSrc = imageSrc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }

}
