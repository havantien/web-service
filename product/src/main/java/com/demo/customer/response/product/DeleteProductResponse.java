package com.demo.customer.response.product;

import com.demo.customer.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteProductResponse extends AbstractResponse {
    private String message =  "thanh cong";
}
