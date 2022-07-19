package com.bxl.javatym.hotel.service;

import com.bxl.javatym.hotel.listeners.EMFWebListener;
import com.bxl.javatym.hotel.models.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.List;

public class CustomerService {
    private static CustomerService instance;
    public static CustomerService getInstance(){
        return instance == null ? instance = new CustomerService() : instance;
    }


    private CustomerService() {
    }


    private final EntityManager manager = EMFWebListener.createEntityManager();

    public List<Customer> getAll(){
        return manager.createNamedQuery("c_get_all", Customer.class).getResultList();
    }

    public Customer getOne(int id){
        return manager.find(Customer.class, id);
    }

    public void insert(Customer toInsert){
        manager.getTransaction().begin();
        manager.persist(toInsert);
        manager.getTransaction().commit();
    }

    public void update(Customer customer) {
        if( customer == null ) throw new IllegalArgumentException("Customer cannot be null");
        if( !existsById(customer.getId()) ) throw new EntityNotFoundException("Entity not found");
        manager.getTransaction().begin();
        manager.merge(customer);
        manager.getTransaction().commit();
    }

    public void delete(int id) {
        manager.getTransaction().begin();
        Customer customerToDelete = getOne(id);
        manager.remove(customerToDelete);
        manager.getTransaction().commit();
    }

    public boolean existsById(int id){
        return getOne(id) != null;
    }
}
