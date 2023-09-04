package com.First_Spring_Project_023.repository;

import com.First_Spring_Project_023.model.Customer;
import com.First_Spring_Project_023.repository.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createCustomer(Customer customer) {
        String sql = "INSERT INTO customer (full_name, email, status) VALUES (?,?,?)";
        jdbcTemplate.update(sql,customer.getCustomerName(),customer.getCustomerEmail(),customer.getCustomerType().name());
    }

    @Override
    public String updateCustomerName(int id, String name) {
        String sql = "UPDATE customer SET full_name = ? WHERE id = ?";
        if(jdbcTemplate.update(sql,name,id) == 1){
            return "Customer's name with id " + id + " was updated to " + name;
        }else{
            return "Customer with id " + id + " was not found";
        }
    }

    @Override
    public String deleteCustomerById(int id) {
        String sql = "DELETE FROM customer WHERE id = ?";
        if(jdbcTemplate.update(sql,id) == 1){
            return "Customer with id " + id + " was deleted";
        }else{
            return "Customer with id " + id + " was not found";
        }
    }

    @Override
    public String updateCustomerEmail(int id, String email) {
        String sql = "UPDATE customer SET email = ? WHERE id = ?";
        if(jdbcTemplate.update(sql,email,id) == 1){
            return "Customer's email with id " + id + " was updated to " + email;
        }else{
            return "Customer with id " + id + " was not found";
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,new CustomerMapper(),id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM customer";
        return jdbcTemplate.query(sql,new CustomerMapper());
    }


    @Override
    public List<String> getAllCustomerNames() {
        String sql = "SELECT full_name FROM customer";
        return jdbcTemplate.queryForList(sql,String.class);
    }
}
