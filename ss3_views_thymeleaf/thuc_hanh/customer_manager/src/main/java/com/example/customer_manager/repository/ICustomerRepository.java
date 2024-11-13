package com.example.customer_manager.repository;

import com.example.customer_manager.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void delete(int id);

    void update(Customer customer);
}
