/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.mvc.app.CustomerApp.services;

import com.spring.mvc.app.CustomerApp.models.Customer;
import java.util.List;

/**
 *
 * @author brianpunzalan
 */
public interface CustomerService {
    List<Customer> listAll();
    Customer get(Integer id);
    Customer save(Customer customer);
    void delete(Integer id);
}
