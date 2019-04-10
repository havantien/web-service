package com.demo.customer.response.customer;

import com.demo.customer.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCustomerResponse extends AbstractResponse {
    private Long id;
    private String firstName;
    private String lastName;

}
