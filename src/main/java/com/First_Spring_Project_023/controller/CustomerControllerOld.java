package com.First_Spring_Project_023.controller;

import com.First_Spring_Project_023.model.Customer;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
//@RequestMapping("/customer")
public class CustomerControllerOld {

    static ArrayList<Customer> customerList = new ArrayList<>();

    @GetMapping(value = "/all")
    public static ArrayList<Customer> getAllCustomers(){
        return customerList;
    }

    @GetMapping(value = "/{id}")
    public static Customer getCustomerById(@PathVariable int id){
        for(Customer c : customerList){
            if (c.getCustomerId() == id){
                return c;
            }
        }
        return null;
    }

    @GetMapping
    public static Customer getCustomerByName(@RequestParam String name){
        for(Customer c : customerList){
            if(c.getCustomerName().equals(name)){
                return c;
            }
        }
        return null;
    }

    @PostMapping
    public static String createCustomer(@RequestBody Customer customer){
        customerList.add(customer);
        return "Customer with id " + customer.getCustomerId() + " and name " + customer.getCustomerName() + " was created";
    }

    @DeleteMapping
    public static String deleteCustomer(@RequestParam int id){
        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i).getCustomerId() == id){
                customerList.remove(i);
                return "Customer with id " + id + " was deleted";
            }
        }
        return "Customer wasn't found";
    }

//    @PutMapping
//    public static String updateCustomer(@RequestParam int id, @RequestBody Customer customer){
//        for (int i = 0; i < customerList.size(); i++) {
//            if(customerList.get(i).getCustomerId() == id){
//                customerList.remove(i);
//                customerList.add(customer);
//                return "Customer was updated";
//            }
//        }
//        return "Customer was not updated";
//    }

    @PutMapping
    public static String updateCustomer(@RequestParam int id, @RequestBody Customer customer){
        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i).getCustomerId() == id){
                if(customer.getCustomerEmail() != null){
                    customerList.get(i).setCustomerEmail(customer.getCustomerEmail());
                }
                if(customer.getCustomerName() != null){
                    customerList.get(i).setCustomerName(customer.getCustomerName());
                }
                return "Customer was updated";
            }
        }
        return "Customer was not found";
    }


}
