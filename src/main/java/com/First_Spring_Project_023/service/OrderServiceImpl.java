package com.First_Spring_Project_023.service;

import com.First_Spring_Project_023.model.Order;
import com.First_Spring_Project_023.model.OrderRequest;
import com.First_Spring_Project_023.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerService customerService;
    @Override
    public void createOrder(OrderRequest orderRequest) {
        if(orderRequest.getCustomer().getCustomerId() != 0 && customerService.getCustomerById(orderRequest.getCustomer().getCustomerId()) != null){
            orderRepository.createOrder(orderRequest.getOrder());
        }else{
            customerService.createCustomer(orderRequest.getCustomer());

        }
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteOrder(id);
    }

    @Override
    public void updateOrderItemName(String newItemName, int orderId) {
        orderRepository.updateOrderItemName(newItemName,orderId);
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.getOrderById(id);
    }
}
