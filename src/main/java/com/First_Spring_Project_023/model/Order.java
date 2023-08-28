package com.First_Spring_Project_023.model;

public class Order {

    private int id;
    private String itemName;
    private String customerName;
    private double price;


    public Order(int id, String itemName, String customerName, double price) {
        this.id = id;
        this.itemName = itemName;
        this.customerName = customerName;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
