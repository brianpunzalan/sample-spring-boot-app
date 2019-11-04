/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.mvc.app.CustomerApp.services;

import com.spring.mvc.app.CustomerApp.models.Customer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 *
 * @author brianpunzalan
 */
@Service
@Profile({ "default", "map" })
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers ;
    
    public CustomerServiceImpl() {
        loadCustomers();
    }
    
    private void loadCustomers() {
        customers = new HashMap<>();
        
        Customer customer1 = new Customer();
        customer1.setId(getNextKey());
        customer1.setFirstName("Brian");
        customer1.setLastName("Punzalan");
        customer1.setEmailAddress("punzalan25brian@gmail.com");
        customer1.setPhoneNumber("09774920391");
        customer1.setAddress("415 Rose St. Reparo Baesa Caloocan City");
        customers.put(customer1.getId(), customer1);
        
        
        Customer customer2 = new Customer();
        customer2.setId(getNextKey());
        customer2.setFirstName("Carlo");
        customer2.setLastName("Punzalan");
        customer2.setEmailAddress("punzalan10carlo@gmail.com");
        customer2.setPhoneNumber("09162345123");
        customer2.setAddress("415 Rose St. Reparo Baesa Caloocan City");
        customers.put(customer2.getId(), customer2);
        
        Customer customer3 = new Customer();
        customer3.setId(getNextKey());
        customer3.setFirstName("Dave");
        customer3.setLastName("Punzalan");
        customer3.setEmailAddress("punzalan16dave@gmail.com");
        customer3.setPhoneNumber("091611224455");
        customer3.setAddress("415 Rose St. Reparo Baesa Caloocan City");
        customers.put(customer3.getId(), customer3);
    }
    
    private Integer getNextKey() {
        if (customers.keySet().isEmpty()) {
            return 1;
        } else {
            return Collections.max(customers.keySet()) + 1;
        }
    }
    
    @Override
    public List<Customer> listAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer get(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer save(Customer customer) {
        if (customer != null) {
            // check if customer is new
            if (customer.getId() == null) {
                customer.setId(getNextKey());
            }
            
            customers.put(customer.getId(), customer);
            
            return customer;
        } else {
            throw new RuntimeException("Customer cannot be null");
        }
    }

    @Override
    public void delete(Integer id) {
        customers.remove(id);
    }
    
}
