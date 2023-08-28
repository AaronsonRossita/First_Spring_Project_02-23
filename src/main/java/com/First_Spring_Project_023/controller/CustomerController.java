package com.First_Spring_Project_023.controller;

import com.First_Spring_Project_023.model.Customer;
import com.First_Spring_Project_023.repository.CustomerRepository;
import com.First_Spring_Project_023.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping(value = "/create")
    public void createCustomer(@RequestBody Customer customer){
        customerRepository.createCustomer(customer);
    }



}
