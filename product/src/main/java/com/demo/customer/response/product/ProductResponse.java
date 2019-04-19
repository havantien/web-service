package com.demo.customer.response.product;

import com.demo.customer.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse extends AbstractResponse {
    private Long id;
    private String name;
    private String size;
    private String color;
}
