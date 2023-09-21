package com.First_Spring_Project_023.service;

import com.First_Spring_Project_023.model.Customer;
import com.First_Spring_Project_023.model.CustomerType;
import com.First_Spring_Project_023.repository.CustomerRepositoryImpl;
import com.First_Spring_Project_023.utils.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepositoryImpl customerRepository;

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public int createCustomer(Customer customer) {
        if (customer.getCustomerType() == CustomerType.VIP){
            if(customerRepository.getAllCustomersByType(CustomerType.VIP).size() < Constants.MAX_VIP){
                try {
                    String customerAsString = objectMapper.writeValueAsString(customer);
                    System.out.println(customerAsString);
                    Customer customerFromString = objectMapper.readValue(customerAsString,Customer.class);
                    System.out.println(customerFromString.getCustomerName());
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                return customerRepository.createCustomer(customer);
            }else{
                return -1;
            }
        }else {
            try {
                String customerAsString = objectMapper.writeValueAsString(customer);
                System.out.println(customerAsString);
                Customer customerFromString = objectMapper.readValue(customerAsString,Customer.class);
                System.out.println(customerFromString.getCustomerName());
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return customerRepository.createCustomer(customer);
        }

    }

    @Override
    public String updateCustomerName(int id, String name) {
        return customerRepository.updateCustomerName(id,name);
    }

    @Override
    public String deleteCustomerById(int id) {
        return customerRepository.deleteCustomerById(id);
    }

    @Override
    public String updateCustomerEmail(int id, String email) {
        return customerRepository.updateCustomerEmail(id,email);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public List<String> getAllCustomerNames() {
        return customerRepository.getAllCustomerNames();
    }
}
