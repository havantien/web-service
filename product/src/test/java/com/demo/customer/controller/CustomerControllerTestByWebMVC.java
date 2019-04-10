package com.demo.customer.controller;

import com.demo.customer.model.type.Customer;
import com.demo.customer.service.CityService;
import com.demo.customer.service.CustomerService;
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

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTestByWebMVC {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private CityService cityService;

    @Test
    public void listAllCustomer() throws Exception {

        Customer customer = new Customer();
        customer.setId((long)123);
        customer.setLastName("tine");
        customer.setFirstName("river");

        List<Customer> customers = Collections.singletonList(customer);

        given(customerService.findAll()).willReturn(customers);

        MockHttpServletResponse response = mvc.perform(get("/v1/list-customer")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        boolean a = true;
    }

    @Test
    public void getCustomer() {
    }

    @Test
    public void createCustomer() {
    }

    @Test
    public void updateCustomer() {
    }

    @Test
    public void deleteCustomer() {
    }
}