package com.hjy.xmb.bean;

import java.io.Serializable;

/**
 * Created by Stefan on 2018/5/8.
 */

public class ShopBean implements Serializable{
    private String img;
    private String name;
    private int count;
    private double price;

    public ShopBean() {
    }

    public ShopBean(String img, String name, int count, double price) {
        this.img = img;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
