/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.mvc.app.CustomerApp.services;

import com.spring.mvc.app.CustomerApp.models.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 *
 * @author brianpunzalan
 */
@Service
@Profile("jpadao")
public class CustomerServiceJpaDaoImpl implements CustomerService {

    private EntityManagerFactory emf;
    
    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public List<Customer> listAll() {
        EntityManager em = emf.createEntityManager();
        
        return em.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer get(Integer id) {
        EntityManager em = emf.createEntityManager();
        
        return em.find(Customer.class, id);
    }

    @Override
    public Customer save(Customer customer) {
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Customer savedCustomer = em.merge(customer);
        em.getTransaction().commit();
        
        return savedCustomer;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.remove(em.find(Customer.class, id));
        em.getTransaction().commit();
    }
    
    
}
