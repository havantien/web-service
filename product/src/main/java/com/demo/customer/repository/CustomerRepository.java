package com.demo.customer.repository;

import com.demo.customer.model.type.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByCity_Id(Long id);

}
