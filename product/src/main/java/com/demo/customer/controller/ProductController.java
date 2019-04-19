package com.demo.customer.controller;

import com.demo.customer.model.type.Product;
import com.demo.customer.response.ResponseModel;
import com.demo.customer.response.city.ListAllCityResponse;
import com.demo.customer.response.product.ProductResponse;
import com.demo.customer.utils.ResponseUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController extends AbstractController{
    @GetMapping("/products")
    public ResponseEntity<ResponseModel> listProduct() {
        List<Product> products = productService.findAll();
        if (products == null) {
            return FAIL_RESPONSE;
        }
        ListAllCityResponse listAllCityResponse = new ListAllCityResponse();
        return ResponseUtils.buildResponseEntity(listAllCityResponse, HttpStatus.OK);
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<ResponseModel> getProduct(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        if (product == null) {
            return FAIL_RESPONSE;
        }
        ProductResponse productResponse = new ProductResponse();
        return ResponseUtils.buildResponseEntity(productResponse, HttpStatus.OK);
    }
}
