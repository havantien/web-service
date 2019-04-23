package com.demo.customer.controller;

import com.demo.customer.model.type.Product;
import com.demo.customer.response.ResponseModel;
import com.demo.customer.response.city.ListAllCityResponse;
import com.demo.customer.response.product.AddProductResponse;
import com.demo.customer.response.product.DeleteProductResponse;
import com.demo.customer.response.product.ProductResponse;
import com.demo.customer.utils.ResponseUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product,
                                          UriComponentsBuilder builder){
        productService.save(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder
                .path("/products/{id}")
                .buildAndExpand(product.getId())
                .toUri());
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ResponseModel> updateProduct(@PathVariable("id") Long id,
                                                       @RequestBody Product product){
        Product currentProduct = productService.findById(id);
        if (currentProduct == null) {
            return FAIL_RESPONSE;
        }

        currentProduct.setName(product.getName());
        currentProduct.setColor(product.getColor());
        currentProduct.setSize(product.getSize());
        currentProduct.setCategoryList(product.getCategoryList());
        productService.save(currentProduct);
        AddProductResponse addProductResponse = new AddProductResponse();
        return ResponseUtils.buildResponseEntity(addProductResponse, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ResponseModel> deleteProduct(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        if (product == null) {
            return FAIL_RESPONSE;
        }
        productService.remove(id);
        DeleteProductResponse deleteProductResponse = new DeleteProductResponse();
        return ResponseUtils.buildResponseEntity(deleteProductResponse, HttpStatus.OK);
    }
}
