package com.demo.customer.utils;

import com.demo.customer.response.AbstractResponse;
import com.demo.customer.response.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseUtils {

    private ResponseUtils() {
    }

    public static <T extends AbstractResponse> ResponseEntity<ResponseModel> buildResponseEntity(T t, HttpStatus status) {
        return new ResponseEntity<>(new ResponseModel(t), status);
    }
}