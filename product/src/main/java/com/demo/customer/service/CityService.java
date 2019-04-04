package com.demo.customer.service;

import com.demo.customer.model.type.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    List<City> findAll();

    City findById(Long id);

    void save(City city);

    void remove(Long id);
}
