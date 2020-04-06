package com.aoher.business;

import com.aoher.dao.CustomerDAO;
import com.aoher.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;

public class AppBean {

    @Autowired
    private CustomerDAO customerDAO;

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void insertCustomer(int id, String name, String address) {
        Customer customer = new Customer(id, name, address);
        int res = customerDAO.insertCustomer(customer);
        System.out.println(res + ": Records inserted");
    }

    public int deleteCustomer(int customerId) {
        return customerDAO.deleteCustomer(customerId);
    }

    public Customer selectCustomer(int customerId) {
        return customerDAO.selectCustomer(customerId);
    }

    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }
}
