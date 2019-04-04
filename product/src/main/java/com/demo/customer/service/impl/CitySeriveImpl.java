package com.demo.customer.service.impl;

import com.demo.customer.model.type.City;
import com.demo.customer.repository.CityRepository;
import com.demo.customer.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CitySeriveImpl implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);

    }
}
