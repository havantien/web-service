package com.demo.customer.controller;

import com.demo.customer.model.type.Customer;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
    public void listAllCustomerFail() throws Exception {
//        Customer customer = null;

        List<Customer> customers = null;

        given(customerService.findAll()).willReturn(customers);

        MockHttpServletResponse response = mvc.perform(get("/v1/list-customer")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(0))
                .andReturn()
                .getResponse();
    }

    @Test
    public void getCustomer() throws Exception {

        Customer customer = new Customer();
        customer.setId((long)100);
        customer.setFirstName("tiki");
        customer.setLastName("taka");


        given(customerService.findById((long) 100)).willReturn(customer);

        MockHttpServletResponse response = mvc.perform(get("/v1/customers/{id}", 100)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andReturn()
                .getResponse();

        boolean a = true;
    }

    @Test
    public void getCustomerFail() throws Exception {
        Customer customer = null;


        given(customerService.findById((long) 100)).willReturn(customer);

        MockHttpServletResponse response = mvc.perform(get("/v1/customers/{id}", 100)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(0))
                .andExpect(jsonPath("$.message").value("User is not captain of this course"))
                .andReturn()
                .getResponse();
    }

    @Test
    public void createCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("tikike");
        customer.setLastName("hihehe");


        given(customerService.save(customer)).willReturn(true);

        MockHttpServletResponse response = mvc.perform(post("/v1/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.convertObjToJsonCustomer(customer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("tikike"))
                .andExpect(jsonPath("$.lastName").value("hihehe"))
                .andReturn()
                .getResponse();

    }


    @Test
    public void updateCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setId((long)100);
        customer.setFirstName("hihi");
        customer.setLastName("hhihi");

        given(customerService.findById((long)100)).willReturn(customer);
        given(customerService.save(customer)).willReturn(true);

        MockHttpServletResponse response = mvc.perform(put("/v1/customers/{id}",100)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.convertObjToJsonCustomer(customer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andReturn()
                .getResponse();

    }

    @Test
    public void updateCustomerFail() throws Exception {
        Customer currentCustomer = null;

        given(customerService.findById((long)100)).willReturn(currentCustomer);

        Customer customer = new Customer();
        customer.setLastName("hihihi");
        customer.setFirstName("cxzczxx");

        MockHttpServletResponse response = mvc.perform(put("/v1/customers/{id}",100)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.convertObjToJsonCustomer(customer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(0))
                .andReturn()
                .getResponse();

    }

    @Test
    public void deleteCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setId((long) 100);
        customer.setFirstName("hihi");
        customer.setLastName("hhihi");

        given(customerService.findById((long)100)).willReturn(customer);
        given(customerService.remove((long) 100)).willReturn(true);

        MockHttpServletResponse response = mvc.perform(put("/v1/customers/{id}",100)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.convertObjToJsonCustomer(customer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andReturn()
                .getResponse();



    }


}