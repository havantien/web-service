package com.demo.customer.controller;

import com.demo.customer.CustomerApplication;
import com.demo.customer.model.type.Customer;
import com.demo.customer.service.CustomerService;
import com.demo.utils.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerApplication.class)
@Transactional
public class CustomerControllerTest {

    private MockMvc mockMvc;

    @Autowired
    protected CustomerService customerService;


    private JacksonTester<Customer> jsonSuperHero;

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        JacksonTester.initFields(this, new ObjectMapper());
        this.mockMvc = MockMvcBuilders.standaloneSetup(new CustomerController(customerService)).build();
    }

    @Test
    @Transactional
    public void getCustomer() throws Exception{
        Customer customer = new Customer();
        customer.setId((long)12);
        customer.setFirstName("hihádasd");
        customer.setLastName("hhihi12323322");
        String json = JsonUtil.convertObjToJsonCustomer(customer);


        //when
        MockHttpServletResponse response = mockMvc.perform(get("/v1/customers/{id}", 12).
                accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonSuperHero.write(customer).getJson()
        );


    }

    @Test
    @Transactional
    public void createCustomer() throws Exception {

        Customer currentCustomer = new Customer();
        currentCustomer.setId((long)22);
        currentCustomer.setFirstName("abc");
        currentCustomer.setLastName("zxc");


        //when
        MockHttpServletResponse response = mockMvc.perform(post("/v1/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonSuperHero.write(currentCustomer).getJson()))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonSuperHero.write(currentCustomer).getJson()
        );

    }

    @Test
    @Transactional
    public void updateCustomer() throws Exception {
        customer = customerService.findById((long)12);
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());

        //when
        MockHttpServletResponse response = mockMvc.perform(put("/v1/customers/{id}", 12)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonSuperHero.write(customer).getJson()))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonSuperHero.write(customer).getJson()
        );

    }

    @Test
    @Transactional
    public void deleteCustomer() throws Exception {

        //when
        MockHttpServletResponse response = mockMvc.perform(delete("/v1/customers/{id}", 12)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();


    }
}