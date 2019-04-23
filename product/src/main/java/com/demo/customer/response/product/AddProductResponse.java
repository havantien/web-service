package com.demo.customer.response.product;

import com.demo.customer.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductResponse extends AbstractResponse {
    private String name;
    private String size;
    private String color;
}
