package com.example.myrecycledemo;

/**
 * Created by acer on 2018/10/31.
 */

public class User {

    private String name;
    private int type;

    public User (String name,int type){
        this.name=name;
        this.type=type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
