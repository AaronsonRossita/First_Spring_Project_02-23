package com.First_Spring_Project_023.service;

import com.First_Spring_Project_023.model.Customer;
import com.First_Spring_Project_023.model.Order;
import com.First_Spring_Project_023.model.OrderRequest;
import com.First_Spring_Project_023.model.OrderResponse;
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
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Customer customer = orderRequest.getCustomer();
        Order order = orderRequest.getOrder();
        OrderResponse orderResponse;
        if(customer.getCustomerId() != null && customerService.getCustomerById(customer.getCustomerId()) != null){
            order.setCustomerId(customer.getCustomerId());
            orderRepository.createOrder(order);
            orderResponse = new OrderResponse(
                    customerService.getCustomerById(customer.getCustomerId()),
                    orderRepository.getOrdersByCustomerId(customer.getCustomerId())
            );
        }else{
            Integer newCustomerId = customerService.createCustomer(customer);
            order.setCustomerId(newCustomerId);
            orderRepository.createOrder(order);
            orderResponse = new OrderResponse(
                    customerService.getCustomerById(newCustomerId),
                    orderRepository.getOrdersByCustomerId(newCustomerId)
            );
        }
        return orderResponse;
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
