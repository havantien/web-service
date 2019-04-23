package com.demo.customer.service.impl;

import com.demo.customer.model.type.Category;
import com.demo.customer.model.type.Product;
import com.demo.customer.repository.ProductRepository;
import com.demo.customer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(Product product) {
        productRepository.save(product);
        return true;
    }

    @Override
    public boolean remove(Long id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Category> findAllById(Long id) {
        return productRepository.findAllById(id);
    }

    @Override
    public List<Product> findAllByCustomer_Id(Long id) {
        return productRepository.findAllByCustomer_Id(id);
    }
}
