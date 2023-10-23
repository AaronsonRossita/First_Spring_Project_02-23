package com.First_Spring_Project_023.repository;

import com.First_Spring_Project_023.model.Customer;
import com.First_Spring_Project_023.model.CustomerType;
import com.First_Spring_Project_023.repository.cache.CacheRepository;
import com.First_Spring_Project_023.repository.mapper.CustomerMapper;
import com.First_Spring_Project_023.utils.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPooled;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CacheRepository cacheRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public Integer createCustomer(Customer customer) {
        String sql = "INSERT INTO " + Constants.CUSTOMER_TABLE_NAME + " (full_name, email, status) VALUES (?,?,?)";
        jdbcTemplate.update(sql,customer.getCustomerName(),customer.getCustomerEmail(),customer.getCustomerType().name());
        sql = "SELECT MAX(id) FROM " + Constants.CUSTOMER_TABLE_NAME;
        return jdbcTemplate.queryForObject(sql, Integer.class);
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
    public Customer getCustomerById(Integer id) throws JsonProcessingException {
        String cacheKey = createKeyForCustomer(id);
        if(cacheRepository.isCacheEntityExists(cacheKey)){
            String customerAsString = cacheRepository.getCacheEntity(cacheKey);
            System.out.println("got customer " + id + " from cache");
            return objectMapper.readValue(customerAsString, Customer.class);
        }else{
            String sql = "SELECT * FROM " + Constants.CUSTOMER_TABLE_NAME + " WHERE id = ?";
            System.out.println("got customer " + id + " from db and stored it in cache");
            try{
                Customer customerFromDb = jdbcTemplate.queryForObject(sql,new CustomerMapper(),id);
                cacheRepository.createCacheEntity(cacheKey, objectMapper.writeValueAsString(customerFromDb));
                return customerFromDb;
            }catch (EmptyResultDataAccessException e){
                return null;
            }
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

    private String createKeyForCustomer(Integer customerId){
        return "customer id: " + customerId;
    }

}

// queryForObject = returns one object
// query = returns List of object by rowMapper
// queryForList = returns List of primitive type but class String, Integer, Byte, Boolean....
