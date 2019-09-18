package com.example.materialtest;

/**
 * Created by lenovo-pc on 2018-09-08.
 */

public class Goldfish {
    private String name;
    private int imageId;

    public Goldfish(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
