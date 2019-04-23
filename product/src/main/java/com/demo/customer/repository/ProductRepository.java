package com.demo.customer.repository;

import com.demo.customer.model.type.Category;
import com.demo.customer.model.type.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Category> findAllById(Long id);

    List<Product> findAllByCustomer_Id(Long id);
}
