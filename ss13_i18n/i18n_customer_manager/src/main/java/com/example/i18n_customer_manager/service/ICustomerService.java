package com.example.i18n_customer_manager.service;

import com.example.i18n_customer_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findByNameContaining(String name, Pageable pageable);

    void save(Customer customer);

    Customer findById(int id);

    void deleteById(int id);

    void update(Customer customer);
}
