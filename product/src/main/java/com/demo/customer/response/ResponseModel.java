package com.demo.customer.response;

import com.demo.customer.constant.CodeResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseModel {
    private int code;
    private AbstractResponse data;
    private String message;

    public ResponseModel(CodeResponse codeResponse) {
        this.code = codeResponse.getCode();
        this.message = codeResponse.getMessage();
    }

    public ResponseModel(AbstractResponse data) {
        this.code = CodeResponse.SUCCESS_CODE.getCode();
        this.message = CodeResponse.SUCCESS_CODE.getMessage();
        this.data = data;
    }
    public ResponseModel() {
        this.code = CodeResponse.SUCCESS_CODE.getCode();
        this.message = CodeResponse.SUCCESS_CODE.getMessage();
    }

    public ResponseModel(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
