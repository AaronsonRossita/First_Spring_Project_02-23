package com.First_Spring_Project_023.repository;

import com.First_Spring_Project_023.model.Order;

import java.util.List;

public interface OrderRepository {

    void createOrder(Order order);
    void deleteOrder(int id);
    void updateOrderItemName(String newItemName, int orderId);
    void updateOrderItemPrice(double newPrice, int orderId);
    void updateOrderCustomerId(int newCustomerId, int orderId);


    List<Order> getAllOrders();
    Order getOrderById(int id);
    List<Order> getOrdersByCustomerId(int id);
    List<String> getItemNames();
    int getSumOfPrice();

}
