package com.demo.customer.service;

import com.demo.customer.model.type.Category;


import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);

    boolean save(Category category);

    boolean remove(Long id);
}
