package com.demo.customer.model.type;


import com.demo.customer.model.AbstractModel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends AbstractModel {
    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_city")
//    private City city;

    public Customer(Long id,String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
