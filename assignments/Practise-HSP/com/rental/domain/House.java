package com.rental.domain;

public class House {
    private int id;
    private String name;
    private String phone;
    private String address;
    private int cost;
    private String state;

    public House(int id, String name, String phone, String address, int cost, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.cost = cost;
        this.state = state;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String state() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id +
                "\t\t" + name +
                "\t\t" + phone +
                "\t\t" + address + '\'' +
                "\t\t" + cost +
                "\t\t" + state;
    }

    public String getState() {
        return state;
    }
}
