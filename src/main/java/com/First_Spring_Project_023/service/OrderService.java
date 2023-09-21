package com.First_Spring_Project_023.service;

import com.First_Spring_Project_023.model.Order;
import com.First_Spring_Project_023.model.OrderRequest;

public interface OrderService {

    void createOrder(OrderRequest orderRequest);
    void deleteOrder(int id);
    void updateOrderItemName(String newItemName, int orderId);
    Order getOrderById(int id);

}
