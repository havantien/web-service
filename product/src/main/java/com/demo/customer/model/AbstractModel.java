package com.demo.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;



@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value ="id",
        allowGetters = true
)
public abstract class AbstractModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;


}
