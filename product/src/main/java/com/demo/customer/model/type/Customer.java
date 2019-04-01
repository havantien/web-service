package com.demo.customer.model.type;

import com.demo.customer.model.AbstractModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "customer", schema = "public")
@NoArgsConstructor
public class Customer extends AbstractModel {
    private String firstName;
    private String lastName;


    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
