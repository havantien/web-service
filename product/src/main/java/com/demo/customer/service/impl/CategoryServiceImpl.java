package com.demo.customer.service.impl;

import com.demo.customer.model.type.Category;
import com.demo.customer.repository.CategoryRepository;
import com.demo.customer.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(Category category) {
        categoryRepository.save(category);
        return true;
    }

    @Override
    public boolean remove(Long id) {
        categoryRepository.deleteById(id);
        return true;
    }
}
