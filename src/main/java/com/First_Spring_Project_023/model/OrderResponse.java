package com.First_Spring_Project_023.model;

import java.util.ArrayList;
import java.util.List;

public class OrderResponse {

    private Customer customer;
    private List<Order> orders;

    public OrderResponse(Customer customer, List<Order> orders) {
        this.customer = customer;
        this.orders = orders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
