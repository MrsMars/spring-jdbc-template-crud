package com.aoher.dao.impl;

import com.aoher.dao.CustomerDAO;
import com.aoher.dto.Customer;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDAOImpl implements CustomerDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer selectCustomer(int customerId) {
        final Customer customer = new Customer();
        String query = "SELECT * FROM customer WHERE custid='" + customerId + "'";
        return jdbcTemplate.query(query, resultSet -> {
            if (resultSet.next()) {
                customer.setCustomerId(resultSet.getInt(1));
                customer.setCustomerName(resultSet.getString(2));
                customer.setCustomerAddress(resultSet.getString(3));
            }
            return customer;
        });
    }

    @Override
    public int insertCustomer(Customer customer) {
        String query = "INSERT INTO customer VALUES(?,?,?)";
        return jdbcTemplate.update(query,
                customer.getCustomerId(),
                customer.getCustomerName(),
                customer.getCustomerAddress());
    }

    @Override
    public int deleteCustomer(int customerId) {
        String query = "DELETE from customer where custid=?";
        return jdbcTemplate.update(query, customerId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        String query = "UPDATE customer SET custname=?,city=? WHERE custid=?";
        jdbcTemplate.update(query, customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerId());
    }
}
