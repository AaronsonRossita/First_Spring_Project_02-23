package com.First_Spring_Project_023.repository.mapper;

import com.First_Spring_Project_023.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {


    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Order(
                rs.getInt("id"),
                rs.getString("item_name"),
                rs.getInt("customer_id"),
                rs.getDouble("item_price")
        );
    }
}
