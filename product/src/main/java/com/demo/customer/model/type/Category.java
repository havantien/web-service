package com.demo.customer.model.type;

import com.demo.customer.model.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Category")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Category extends AbstractModel {
    @Column(name = "Name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_category",
            joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> productList;


}
