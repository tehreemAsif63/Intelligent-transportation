package com.intelligenttransportation;

import android.widget.ImageView;

import java.io.Serializable;

public class Car implements Serializable {
    private int id;
    private String name;
    private String imageSrc;

    public Car() {
    }

    public Car(int id, String name, String imageSrc) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

}
