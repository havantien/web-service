package com.demo.customer.controller;

import com.demo.customer.model.type.Customer;
import com.demo.customer.response.ResponseModel;
import com.demo.customer.response.customer.AddCustomerResponse;
import com.demo.customer.response.customer.CustomerResponse;
import com.demo.customer.response.customer.DeleteCustomerResponse;
import com.demo.customer.response.customer.ListAllCustomerResponse;
import lombok.AllArgsConstructor;
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


    @GetMapping("/list-customer")
    public ResponseEntity<ResponseModel> listAllCustomer() {
        List<Customer> customers = customerService.findAll();
        if (customers == null) {
            return FAIL;
        }
        ListAllCustomerResponse listAllCustomerResponse = new ListAllCustomerResponse(customers);
        return ResponseUtils.buildResponseEntity(listAllCustomerResponse,HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<ResponseModel> getCustomer(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return FAIL;
        }
        CustomerResponse customerResponse = new CustomerResponse(customer.getId(), customer.getFirstName(),customer.getLastName());
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
            return FAIL;
        }
        currentCustomer.setFirstName(customer.getFirstName());
        currentCustomer.setLastName(customer.getLastName());
        customerService.save(currentCustomer);
        AddCustomerResponse addCustomerResponse = new AddCustomerResponse(currentCustomer.getFirstName(), currentCustomer.getLastName());
        return ResponseUtils.buildResponseEntity(addCustomerResponse, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<ResponseModel> deleteCustomer(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return FAIL;
        }
        customerService.remove(id);
        DeleteCustomerResponse deleteCustomerResponse = new DeleteCustomerResponse();
        return ResponseUtils.buildResponseEntity(deleteCustomerResponse, HttpStatus.OK);
    }


}
