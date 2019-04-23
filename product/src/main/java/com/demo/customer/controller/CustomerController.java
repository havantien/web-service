package com.demo.customer.controller;

import com.demo.customer.model.type.City;
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
@RequestMapping("/v1/cities")
@AllArgsConstructor
public class CustomerController extends AbstractController {


    @GetMapping("/customers")
    public ResponseEntity<ResponseModel> listAllCustomer() {
        List<City> cities = cityService.findAll();
        List<Customer> customers = customerService.findAll();
        if (customers == null) {
            return FAIL_RESPONSE;
        }
        ListAllCustomerResponse listAllCustomerResponse = new ListAllCustomerResponse(customers);
        return ResponseUtils.buildResponseEntity(listAllCustomerResponse,HttpStatus.OK);
    }

    @GetMapping("/{city_id}/customers/{customer_id}")
    public ResponseEntity<ResponseModel> getCustomer(@PathVariable("customer_id") Long customerId,
                                                     @PathVariable("city_id") Long cityId) {
        City cities = cityService.findById(cityId);
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            return FAIL_RESPONSE;
        }
        CustomerResponse customerResponse = new CustomerResponse(customer.getId(), customer.getFirstName(),customer.getLastName());
        return ResponseUtils.buildResponseEntity(customerResponse, HttpStatus.OK);
    }

    @PostMapping("/{city_id}/customers")
    public ResponseEntity<Customer> createCustomer(@PathVariable(name = "city_id") Long cityId,
                                                   @RequestBody Customer customer,
                                                   UriComponentsBuilder builder) {

        City city = cityService.findById(cityId);
        customerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/v1/cities/{city_id}/customers/{customer_id}")
                .buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("/{city_id}/customers/{customer_id}")
    public ResponseEntity<ResponseModel> updateCustomer(@PathVariable("customer_id") Long customerId,
                                                   @PathVariable("city_id")Long cityId,
                                                   @RequestBody Customer customer) {
        Customer currentCustomer = customerService.findById(customerId);
        City city = cityService.findById(cityId);

        if (currentCustomer == null) {
            return FAIL_RESPONSE;
        }
        currentCustomer.setFirstName(customer.getFirstName());
        currentCustomer.setLastName(customer.getLastName());
        currentCustomer.setCity(customer.getCity());
        customerService.save(currentCustomer);
        AddCustomerResponse addCustomerResponse = new AddCustomerResponse(currentCustomer.getFirstName(), currentCustomer.getLastName());
        return ResponseUtils.buildResponseEntity(addCustomerResponse, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{customer_id}")
    public ResponseEntity<ResponseModel> deleteCustomer(@PathVariable("customer_id") Long customerId)
                                                         {
        Customer customer = customerService.findById(customerId);

        if (customer == null) {
            return FAIL_RESPONSE;
        }
        customerService.remove(customerId);
        DeleteCustomerResponse deleteCustomerResponse = new DeleteCustomerResponse();
        return ResponseUtils.buildResponseEntity(deleteCustomerResponse, HttpStatus.OK);
    }


}
