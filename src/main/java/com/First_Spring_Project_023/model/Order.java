package com.First_Spring_Project_023.model;

public class Order {

    private int id;
    private String itemName;
    private int customerId;
    private double price;


    public Order(int id, String itemName, int customerName, double price) {
        this.id = id;
        this.itemName = itemName;
        this.customerId = customerName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
