package com.example.customer_manager.service;

import com.example.customer_manager.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void delete(int id);

    void update(Customer customer);
}
