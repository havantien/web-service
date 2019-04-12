package com.demo.customer.service;

import com.demo.customer.model.type.City;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CityService {
    List<City> findAll();

    City findById(Long id);

    boolean save(City city);

    boolean remove(Long id);
}
