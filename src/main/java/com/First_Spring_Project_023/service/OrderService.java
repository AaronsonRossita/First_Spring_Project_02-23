package com.First_Spring_Project_023.service;

import com.First_Spring_Project_023.model.Order;
import com.First_Spring_Project_023.model.OrderRequest;
import com.First_Spring_Project_023.model.OrderResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OrderService {

    OrderResponse createOrder(OrderRequest orderRequest) throws JsonProcessingException;
    void deleteOrder(int id);
    void updateOrderItemName(String newItemName, int orderId);
    Order getOrderById(int id);

}
