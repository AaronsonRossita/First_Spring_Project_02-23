package com.First_Spring_Project_023.service;

import com.First_Spring_Project_023.model.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CustomerService {

    Integer createCustomer(Customer customer);
    String updateCustomerName(int id, String name);
    String deleteCustomerById(int id);
    String updateCustomerEmail(int id, String email);

    Customer getCustomerById(Integer id) throws JsonProcessingException;
    //getCustomerByName
    List<Customer> getAllCustomers();
    List<String> getAllCustomerNames();

}
