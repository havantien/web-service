package com.demo.customer.response.customer;

import com.demo.customer.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse extends AbstractResponse {
    private Long id;
    private String fistName;
    private String lastName;


}
