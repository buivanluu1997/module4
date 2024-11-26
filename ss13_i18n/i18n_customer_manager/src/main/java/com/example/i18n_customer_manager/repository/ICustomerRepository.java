package com.example.i18n_customer_manager.repository;

import com.example.i18n_customer_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findByNameContaining(String name, Pageable pageable);
}
