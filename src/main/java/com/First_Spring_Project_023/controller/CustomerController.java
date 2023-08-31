package com.First_Spring_Project_023.controller;

import com.First_Spring_Project_023.model.Customer;
import com.First_Spring_Project_023.repository.CustomerRepository;
import com.First_Spring_Project_023.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping
    public void createCustomer(@RequestBody Customer customer){
        customerRepository.createCustomer(customer);
    }

    @DeleteMapping
    public String deleteCustomerById(@RequestParam int id){
        return customerRepository.deleteCustomerById(id);
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
            return customerRepository.updateCustomerName(customer.getCustomerId(),customer.getCustomerName());
        }
    }

    @PutMapping(value = "/update/email")
    public String updateCustomerEmail(@RequestBody Customer customer){
        if (customer.getCustomerId() == 0 || customer.getCustomerEmail() == null){
            return "Can't change stuff to null";
        }else{
            return customerRepository.updateCustomerEmail(customer.getCustomerId(),customer.getCustomerEmail());
        }

    }


    @GetMapping
    public Customer getCustomerById(@RequestParam int id){
        return customerRepository.getCustomerById(id);
    }

    @GetMapping(value = "/all")
    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }

    @GetMapping(value = "/names")
    public List<String> getAllCustomerName(){
        return customerRepository.getAllCustomerNames();
    }




}
