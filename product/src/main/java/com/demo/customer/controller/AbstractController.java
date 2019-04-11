package com.demo.customer.controller;

import com.demo.customer.constant.CodeResponse;
import com.demo.customer.constant.MessageConstant;
import com.demo.customer.response.ResponseModel;
import com.demo.customer.service.CityService;
import com.demo.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class AbstractController {

    protected static final ResponseEntity<ResponseModel> FAIL = new ResponseEntity<>(new ResponseModel(
            CodeResponse.FAIL_CODE.getCode(), MessageConstant.NOT_CAPTAIN_COURSE), HttpStatus.OK);

    @Autowired
    protected CustomerService customerService;

    @Autowired
    protected CityService cityService;
}
