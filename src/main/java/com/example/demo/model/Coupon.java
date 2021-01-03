package com.example.demo.model;

public class Coupon {
    int id;
    String name;
    float discount;
    String description;

    public Coupon() {
    }

    public Coupon(int id, String name, float discount, String description) {
        this.id = id;
        this.name = name;
        this.discount = discount;
        this.description = description;
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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
