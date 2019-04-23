package com.demo.customer.service;

import com.demo.customer.model.type.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    boolean save(Customer customer);

    boolean remove(Long id);

    List<Customer> findAllByCity_Id(Long id);

}
