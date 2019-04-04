package com.demo.customer.service;

import com.demo.customer.model.type.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

}
