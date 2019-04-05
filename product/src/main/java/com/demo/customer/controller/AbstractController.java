package com.demo.customer.controller;


import com.demo.customer.model.type.City;
import com.demo.customer.service.CityService;
import com.demo.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractController {



    @Autowired
    protected CityService cityService;
}
