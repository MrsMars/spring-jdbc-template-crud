package com.aoher;

import com.aoher.business.AppBean;
import com.aoher.dto.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        AppBean demo = (AppBean) context.getBean("db");

        // Inserting Data into customer table
        demo.insertCustomer(1, "chandra", "Hyd");

        // Selecting data from customer table
        Customer customer = demo.selectCustomer(1);
        System.out.println("Inserted Customer Name : " + customer.getCustomerName());

        // updating customer data in customer table
        Customer customer2 = new Customer(1, "Vizag", "shekhar");
        demo.updateCustomer(customer2);

        // Deleting customer data from customer table

		 int count = demo.deleteCustomer(1);
		 System.out.println(count > 0 ? "Deleted Success" : "No Records found");
    }
}
