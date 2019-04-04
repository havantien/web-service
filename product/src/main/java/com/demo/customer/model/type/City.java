package com.demo.customer.model.type;

import com.demo.customer.model.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
public class City extends AbstractModel {
    private String name;

    public City(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
