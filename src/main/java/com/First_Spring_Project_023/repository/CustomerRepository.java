package com.First_Spring_Project_023.repository;

import com.First_Spring_Project_023.model.Customer;

import java.util.List;

public interface CustomerRepository {

    void createCustomer(Customer customer);
    String updateCustomerName(int id, String name);
    String deleteCustomerById(int id);
    String updateCustomerEmail(int id, String email);

    Customer getCustomerById(int id);
    //getCustomerByName
    List<Customer> getAllCustomers();
    List<String> getAllCustomerNames();

}
