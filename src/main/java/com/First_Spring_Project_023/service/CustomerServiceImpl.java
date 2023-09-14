package com.First_Spring_Project_023.service;

import com.First_Spring_Project_023.model.Customer;
import com.First_Spring_Project_023.model.CustomerType;
import com.First_Spring_Project_023.repository.CustomerRepositoryImpl;
import com.First_Spring_Project_023.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepositoryImpl customerRepository;
    @Override
    public String createCustomer(Customer customer) {
        if (customer.getCustomerType() == CustomerType.VIP){
            if(customerRepository.getAllCustomersByType(CustomerType.VIP).size() < Constants.MAX_VIP){
                return customerRepository.createCustomer(customer);
            }else{
                return "Sorry can't create more VIP customers";
            }
        }else {
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