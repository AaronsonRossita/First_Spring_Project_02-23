package com.First_Spring_Project_023.repository;

import com.First_Spring_Project_023.model.Customer;
import com.First_Spring_Project_023.model.CustomerType;
import com.First_Spring_Project_023.repository.mapper.CustomerMapper;
import com.First_Spring_Project_023.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer createCustomer(Customer customer) {
        String sql = "INSERT INTO " + Constants.CUSTOMER_TABLE_NAME + " (full_name, email, status) VALUES (?,?,?)";
        jdbcTemplate.update(sql,customer.getCustomerName(),customer.getCustomerEmail(),customer.getCustomerType().name());
        sql = "SELECT id FROM " + Constants.CUSTOMER_TABLE_NAME + " WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, customer.getCustomerEmail());
    }

    @Override
    public String updateCustomerName(int id, String name) {
        String sql = "UPDATE " + Constants.CUSTOMER_TABLE_NAME + " SET full_name = ? WHERE id = ?";
        if(jdbcTemplate.update(sql,name,id) == 1){
            return "Customer's name with id " + id + " was updated to " + name;
        }else{
            return "Customer with id " + id + " was not found";
        }
    }

    @Override
    public String deleteCustomerById(int id) {
        String sql = "DELETE FROM " + Constants.CUSTOMER_TABLE_NAME + " WHERE id = ?";
        if(jdbcTemplate.update(sql,id) == 1){
            return "Customer with id " + id + " was deleted";
        }else{
            return "Customer with id " + id + " was not found";
        }
    }

    @Override
    public String updateCustomerEmail(int id, String email) {
        String sql = "UPDATE " + Constants.CUSTOMER_TABLE_NAME + " SET email = ? WHERE id = ?";
        if(jdbcTemplate.update(sql,email,id) == 1){
            return "Customer's email with id " + id + " was updated to " + email;
        }else{
            return "Customer with id " + id + " was not found";
        }
    }

    @Override
    public Customer getCustomerById(Integer id) {
        String sql = "SELECT * FROM " + Constants.CUSTOMER_TABLE_NAME + " WHERE id = ?";
        try{
            return jdbcTemplate.queryForObject(sql,new CustomerMapper(),id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM " + Constants.CUSTOMER_TABLE_NAME;
        return jdbcTemplate.query(sql,new CustomerMapper());
    }


    @Override
    public List<String> getAllCustomerNames() {
        String sql = "SELECT full_name FROM " + Constants.CUSTOMER_TABLE_NAME;
        return jdbcTemplate.queryForList(sql,String.class);
    }

    @Override
    public List<Customer> getAllCustomersByType(CustomerType type) {
        String sql;
//        if(type == CustomerType.VIP){
//            sql = "SELECT * FROM customer WHERE status = 'VIP'";
//        }else if (type == CustomerType.REGULAR){
//            sql = "SELECT * FROM customer WHERE status = 'REGULAR'";
//        }else{
//            sql = "SELECT * FROM customer WHERE status = 'SPECIAL'";
//        }
        sql = "SELECT * FROM " + Constants.CUSTOMER_TABLE_NAME + " WHERE status = ?";
        return jdbcTemplate.query(sql,new CustomerMapper(),type.name());
    }

}

// queryForObject = returns one object
// query = returns List of object by rowMapper
// queryForList = returns List of primitive type but class String, Integer, Byte, Boolean....
