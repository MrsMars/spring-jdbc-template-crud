package com.aoher.dao;

import com.aoher.dto.Customer;

public interface CustomerDAO {

    Customer selectCustomer(int customerId);

    int insertCustomer(Customer customer);

    int deleteCustomer(int customerId);

    void updateCustomer(Customer customer);
}
