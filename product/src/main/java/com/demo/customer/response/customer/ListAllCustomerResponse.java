package com.demo.customer.response.customer;

import com.demo.customer.model.type.Customer;
import com.demo.customer.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListAllCustomerResponse extends AbstractResponse {
    private List<Customer> customers;
}
