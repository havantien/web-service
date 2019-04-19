package com.demo.customer.model.type;

import com.demo.customer.model.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
public class City extends AbstractModel {
    @Column(name = "Name")
    private String name;

    @OneToMany(targetEntity = Customer.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "city")
    private List<Customer> customerList;

    public City(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
