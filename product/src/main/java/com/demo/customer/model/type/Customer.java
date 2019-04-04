package com.demo.customer.model.type;


import com.demo.customer.model.AbstractModel;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "customer", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends AbstractModel {
    private String firstName;
    private String lastName;
    

    public Customer(Long id,String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
