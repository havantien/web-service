package com.demo.customer.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum  CodeResponse {
    SUCCESS_CODE(1,"Success"),
    FAIL_CODE(0,"Failed");


    private int code;
    private String message;

}
