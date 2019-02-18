package com.hjy.xmb.bean;

import java.io.Serializable;

/**
 * Created by QKun on 2018/5/7.
 */

public class HomeBean implements Serializable{

    private int drawbles;
    private String text;
    private int id;
    private double price;
    private int count;
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    private String time;


    public HomeBean(int drawbles, String text, int id, int price, int count, String time) {
        this.drawbles = drawbles;
        this.text = text;
        this.id = id;
        this.price = price;
        this.count = count;
        this.time = time;

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public int getDrawbles() {
        return drawbles;
    }

    public void setDrawbles(int drawbles) {
        this.drawbles = drawbles;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
