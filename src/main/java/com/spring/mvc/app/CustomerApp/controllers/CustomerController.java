/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.mvc.app.CustomerApp.controllers;

import com.spring.mvc.app.CustomerApp.models.Customer;
import com.spring.mvc.app.CustomerApp.services.CustomerService;
import com.spring.mvc.app.CustomerApp.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author brianpunzalan
 */
@Controller
public class CustomerController {
    
    private CustomerService customerService;
    
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @RequestMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.listAll());
        return "customers";
    }
    
    @RequestMapping("/customer/{id}")
    public String viewCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.get(id));
        return "customer";
    }
    
    @RequestMapping("/customer/new")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }
    
    @RequestMapping("/customer/edit/{id}")
    public String updateCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.get(id));
        return "customer-form";
    }
    
    @RequestMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id, Model model) {
        customerService.delete(id);
        return "redirect:/customers";
    }
    
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String save(Customer customer) {
        customer = customerService.save(customer);
        return "redirect:/customer/" + customer.getId();
    }
}
