package com.demo.customer.response.customer;

import com.demo.customer.model.type.Customer;
import com.demo.customer.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListAllCustomerResponse extends AbstractResponse {
    private List<Customer> customers;
}
