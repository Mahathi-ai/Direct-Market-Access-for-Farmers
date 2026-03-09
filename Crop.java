package com.example.cropconnect;

public class Crop {

    int id;
    String name;
    String price;
    String phone;

    public Crop(int id, String name, String price, String phone) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getPhone() {
        return phone;
    }
}
