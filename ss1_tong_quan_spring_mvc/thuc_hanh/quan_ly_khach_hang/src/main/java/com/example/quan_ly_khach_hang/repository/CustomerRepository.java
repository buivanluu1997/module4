package com.example.quan_ly_khach_hang.repository;

import com.example.quan_ly_khach_hang.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository{
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(1, "Nguyen Khac Nhat", "nhat@codegym.vn",  "Ha Noi"));
        customerList.add(new Customer(2, "Dang Huy Hoa", "hoa.dang@codegym.vn",  "Da Nang"));
        customerList.add(new Customer(3, "Le Thi Chau", "chau.le@codegym.vn",  "Ha Noi"));
        customerList.add(new Customer(4, "Nguyen Thuy Duong", "dung.nguyen@codegym.vn",  "Sai Gon"));
        customerList.add(new Customer(5, "CodeGym", "codegym@codegym.vn",  "Viet Nam"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }
}
