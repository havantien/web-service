package com.demo.customer.response.customer;

import com.demo.customer.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteCustomerResponse extends AbstractResponse {
    String message = "thành công";
}
