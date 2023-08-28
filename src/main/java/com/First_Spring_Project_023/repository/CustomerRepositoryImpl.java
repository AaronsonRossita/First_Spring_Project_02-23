package com.First_Spring_Project_023.repository;

import com.First_Spring_Project_023.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void createCustomer(Customer customer) {
//        INSERT INTO customer (full_name, email) VALUES ('def','@@')
        String sql = "INSERT INTO customer (full_name, email) VALUES (?,?)";
        jdbcTemplate.update(sql,customer.getCustomerName(),customer.getCustomerEmail());
    }


}
