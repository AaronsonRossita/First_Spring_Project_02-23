package com.First_Spring_Project_023.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {

    @JsonProperty("id")
    private int customerId;
    @JsonProperty("name")
    private String customerName;
    @JsonProperty("email")
    private String customerEmail;

    public Customer(int id, String name, String phone) {
        this.customerId = id;
        this.customerName = name;
        this.customerEmail = phone;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return String.format("%s is a customer with id %s and phone number %s",this.customerName,this.customerId,this.customerEmail);
    }
}
