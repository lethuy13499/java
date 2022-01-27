package com.jungdo.exception;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;

public class BusinessException extends RuntimeException{
    private String errorCode;
    private HttpStatus httpStatus;
    private Object content;

    public BusinessException(String errorCode) {
        this.errorCode = errorCode;
        content = new ArrayList<>();
    }

    public BusinessException(String errorCode, Object content) {
        this.errorCode = errorCode;
        this.content = content;
    }

    public BusinessException(String errorCode, Object content, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.content = content;
        this.httpStatus = httpStatus;
    }
}
