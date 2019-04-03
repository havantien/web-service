package com.demo.customer.controller.sub;

import com.demo.customer.exception.RestExceptionHandler;
import com.demo.customer.filter.CustomerFilter;
import com.demo.customer.model.type.Customer;
import com.demo.customer.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private JacksonTester<Customer> jsonSuperHero;

    @Before
    public void setUp(){
        JacksonTester.initFields(this, new ObjectMapper());
        // MockMvc standalone approach
        mockMvc = MockMvcBuilders.standaloneSetup(customerController)
                .setControllerAdvice(new RestExceptionHandler())
                .addFilters(new CustomerFilter())
                .build();
    }
    @Test
    public void listAllCustomer() throws Exception {

    }

    @Test
    public void getCustomer() throws Exception {
        Customer customer = new Customer((long)3,"hihi","hehe");
        // given
        given(customerService.findById((long) 3))
                .willReturn(customer);

        // when
        MockHttpServletResponse response = mockMvc.perform(
                get("/v1/customers/3")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonSuperHero.write(customer).getJson()
        );
    }

    @Test
    public void createCustomer() {
//        MockHttpServletResponse response = mockMvc.perform(
//                post("/v1/customers").contentType(MediaType.APPLICATION_JSON)
//                .content(jsonSuperHero.write())
//        )
    }

    @Test
    public void updateCustomer() {
    }

    @Test
    public void deleteCustomer() {
    }
}