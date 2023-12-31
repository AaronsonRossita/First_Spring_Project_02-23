package com.First_Spring_Project_023.repository.mapper;

import com.First_Spring_Project_023.model.Customer;
import com.First_Spring_Project_023.model.CustomerType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

//    @Override
//    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Customer customer = new Customer(rs.getInt("id"), rs.getString("full_name"), rs.getString("email"));
//        return customer;
//    }

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(
                rs.getInt("id"),
                rs.getString("full_name"),
                rs.getString("email"),
                CustomerType.valueOf(rs.getString("status"))
        );
    }



}
