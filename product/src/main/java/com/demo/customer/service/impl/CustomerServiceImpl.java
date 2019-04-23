package com.demo.customer.service.impl;

import com.demo.customer.model.type.Customer;
import com.demo.customer.repository.CustomerRepository;
import com.demo.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(Customer customer) {
        customerRepository.save(customer);
        return true;
    }

    @Override
    public boolean remove(Long id) {
        customerRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Customer> findAllByCity_Id(Long id) {
        return customerRepository.findAllByCity_Id(id);
    }
}
