package com.demo.customer.controller;


import com.demo.customer.service.CustomerService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Getter
@Setter
public abstract class AbstractController {

    @Autowired
    protected CustomerService customerService;
}
