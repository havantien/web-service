package com.demo.customer.service.impl;

import com.demo.customer.model.type.City;
import com.demo.customer.repository.CityRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;


public class CityServiceImplTest {

    @InjectMocks
    private  CityServiceImpl cityServiceImpl;

    @Mock
    private CityRepository cityRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() {
        List<City> list = new ArrayList<City>();

        City city1 = new City((long) 1, "ha noi");
        City city2 = new City((long) 2, "thai binh");
        City city3 = new City((long) 3, "ba cham");

        list.add(city1);
        list.add(city2);
        list.add(city3);


        when(cityRepository.findAll()).thenReturn(list);

        List<City> cityList = cityServiceImpl.findAll();

        assertEquals(3, cityList.size());
//        verify(cityRepository,times());
    }

    @Test
    public void findById() {

        when(cityRepository.findById((long) 1)).thenReturn(java.util.Optional.of(new City((long) 1, "hanoi")));

        City city = cityServiceImpl.findById((long) 1);

        assertEquals("hanoi", city.getName());
    }

    @Test
    public void save() {

        City city = new City((long) 1, "hanoi");
        cityServiceImpl.save(city);
//        verify(cityRepository);
    }

    @Test
    public void remove() {
        City city = new City((long)1, "ha noi");
        cityServiceImpl.remove((long) 1);
    }
}