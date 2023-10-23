package com.First_Spring_Project_023.controller;

import com.First_Spring_Project_023.model.Customer;
import com.First_Spring_Project_023.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Integer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @DeleteMapping
    public String deleteCustomerById(@RequestParam int id){
        return customerService.deleteCustomerById(id);
    }

//    @PutMapping
//    public String updateCustomerName(@RequestParam String name, @RequestParam int id){
//        return customerRepository.updateCustomerName(id,name);
//    }

    @PutMapping(value = "/update/name")
    public String updateCustomerName(@RequestBody Customer customer){
        if (customer.getCustomerId() == 0 || customer.getCustomerName() == null){
            return "Can't change stuff to null";
        }else{
            return customerService.updateCustomerName(customer.getCustomerId(),customer.getCustomerName());
        }
    }

    @PutMapping(value = "/update/email")
    public String updateCustomerEmail(@RequestBody Customer customer){
        if (customer.getCustomerId() == 0 || customer.getCustomerEmail() == null){
            return "Can't change stuff to null";
        }else{
            return customerService.updateCustomerEmail(customer.getCustomerId(),customer.getCustomerEmail());
        }

    }


    @GetMapping
    public Customer getCustomerById(@RequestParam int id) throws JsonProcessingException {
        return customerService.getCustomerById(id);
    }

    @GetMapping(value = "/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/names")
    public List<String> getAllCustomerName(){
        return customerService.getAllCustomerNames();
    }




}
