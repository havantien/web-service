package com.demo.customer.service;

import com.demo.customer.model.type.Category;
import com.demo.customer.model.type.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    boolean save(Product product);

    boolean remove(Long id);

    List<Category> findAllById(Long id);

    List<Product> findAllByCustomer_Id(Long id);
}
