package com.First_Spring_Project_023.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    private int id;
    @JsonProperty("item_name")
    private String itemName;
    @JsonProperty("customer_id")
    private int customerId;
    private double price;


    public Order(int id, String itemName, int customerId, double price) {
        this.id = id;
        this.itemName = itemName;
        this.customerId = customerId;
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
