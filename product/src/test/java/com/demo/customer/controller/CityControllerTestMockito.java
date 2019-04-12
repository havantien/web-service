package com.demo.customer.controller;

import com.demo.customer.model.type.City;
import com.demo.customer.service.CityService;
import com.demo.customer.service.CustomerService;
import com.demo.customer.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerTestMockito {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CityService cityService;

    @MockBean
    CustomerService customerService;

    @Test
    public void listCity() throws Exception {
        City city = new City();
        city.setId((long) 123);
        city.setName("hanoi");

        List<City> citys = Collections.singletonList(city);

        given(cityService.findAll()).willReturn(citys);

        MockHttpServletResponse response = mvc.perform(get("/v1/listCity")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }

    @Test
    public void getCity() throws Exception {

        City city = new City();
        city.setId((long) 123);
        city.setName("hanoi");


        given(cityService.findById((long) 123)).willReturn(city);

        MockHttpServletResponse response = mvc.perform(get("/v1/citys/{id}", 123)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
    }

    @Test
    public void createCity() throws Exception {
        City city = new City();
        city.setId((long) 123);
        city.setName("hanoi");

        given(cityService.save(city)).willReturn(true);

        MockHttpServletResponse response = mvc.perform(post("/v1/citys")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.convertObjToJsonCity(city)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.code").value(1))
                .andReturn()
                .getResponse();
    }

    @Test
    public void updateCity() throws Exception {
        City city = new City();
        city.setId((long) 123);
        city.setName("hanoi");

        given(cityService.findById((long)123)).willReturn(city);
        given(cityService.save(city)).willReturn(true);

        MockHttpServletResponse response = mvc.perform(put("/v1/citys/{id}",123)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.convertObjToJsonCity(city)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andReturn()
                .getResponse();
    }

    @Test
    public void deleteCity() throws Exception {
        City city = new City();
        city.setId((long) 123);
        city.setName("hanoi");

        given(cityService.findById((long)123)).willReturn(city);
        given(cityService.remove((long)100)).willReturn(true);

        MockHttpServletResponse response = mvc.perform(put("/v1/citys/{id}",123)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.convertObjToJsonCity(city)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andReturn()
                .getResponse();
    }
}