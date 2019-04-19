package com.demo.customer.response.product;

import com.demo.customer.model.type.Product;
import com.demo.customer.response.AbstractResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListAllProductResponse extends AbstractResponse {
    private List<Product> productList;
}
