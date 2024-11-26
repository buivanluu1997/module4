package com.example.i18n_customer_manager.service.impl;

import com.example.i18n_customer_manager.model.Customer;
import com.example.i18n_customer_manager.repository.ICustomerRepository;
import com.example.i18n_customer_manager.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Page<Customer> findByNameContaining(String name, Pageable pageable) {
        return customerRepository.findByNameContaining(name, pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }
}
