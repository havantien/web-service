package com.demo.customer.controller;

import com.demo.customer.constant.CodeResponse;
import com.demo.customer.model.type.Customer;
import com.demo.customer.response.ResponseModel;
import com.demo.customer.response.customer.AddCustomerResponse;
import com.demo.customer.response.customer.CustomerResponse;
import com.demo.customer.response.customer.ListAllCustomerResponse;
import com.demo.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.demo.customer.utils.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class CustomerController extends AbstractController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list-customer")
    public ResponseEntity<ResponseModel> listAllCustomer() {
        List<Customer> customers = customerService.findAll();
        if (customers == null) {
            return new ResponseEntity<>(new ResponseModel(CodeResponse.FAIL_CODE),HttpStatus.OK);
        }
        ListAllCustomerResponse listAllCustomerResponse = new ListAllCustomerResponse(customers);
        return ResponseUtils.buildResponseEntity(listAllCustomerResponse,HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<ResponseModel> getCustomer(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(new ResponseModel(CodeResponse.FAIL_CODE),HttpStatus.OK);
        }
        CustomerResponse customerResponse = new CustomerResponse(id, customer.getFirstName(),customer.getLastName());
        return ResponseUtils.buildResponseEntity(customerResponse, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer, UriComponentsBuilder builder) {
        customerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/customers/{id}")
                .buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<ResponseModel> updateCustomer(@PathVariable("id") Long id,
                                                   @RequestBody Customer customer) {
        Customer currentCustomer = customerService.findById(id);

        if (currentCustomer == null) {
            return new ResponseEntity<>(new ResponseModel(CodeResponse.FAIL_CODE), HttpStatus.OK);
        }
        currentCustomer.setFirstName(customer.getFirstName());
        currentCustomer.setLastName(customer.getLastName());
        customerService.save(currentCustomer);
        AddCustomerResponse addCustomerResponse = new AddCustomerResponse(id, currentCustomer.getFirstName(), currentCustomer.getLastName());
        return ResponseUtils.buildResponseEntity(addCustomerResponse, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<ResponseModel> deleteCustomer(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(new ResponseModel(CodeResponse.FAIL_CODE),HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
