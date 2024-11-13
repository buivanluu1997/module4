package com.example.customer_manager.repository;

import com.example.customer_manager.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository{
    private List<Customer> customers = new ArrayList<>();;
    public CustomerRepository() {
        customers.add(new Customer(1, "Hoàng Ngọc Huy", "hoanghuy@gmail.com", "Đà Nẵng"));
        customers.add(new Customer(2, "Trần Ngọc Trung", "thuan@gmail.com", "Huế"));
        customers.add(new Customer(3, "Nguyễn Tuấn", "tuan123@gmail.com", "Hà Nội"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < customers.size(); i++){
            if (customers.get(i).getId() == id){
                customers.remove(i);
                break;
            }
        }
    }

    @Override
    public void update(Customer customer) {
        for (Customer custom : customers) {
            if (custom.getId() == customer.getId()) {
                custom.setName(customer.getName());
                custom.setEmail(customer.getEmail());
                custom.setAddress(customer.getAddress());
                break;
            }
        }
    }
}
