package com.demo.customer.repository;

import com.demo.customer.model.type.Category;
import com.demo.customer.model.type.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findAllByProductList(Product product);
}
