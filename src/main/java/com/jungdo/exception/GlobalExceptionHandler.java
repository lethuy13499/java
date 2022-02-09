package com.jungdo.exception;

import com.jungdo.utils.APIResponseUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                               HttpHeaders headers, HttpStatus status, WebRequest request) {
        ex.printStackTrace();
        List<Object> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        return APIResponseUtils.buildResponse(HttpStatus.BAD_REQUEST,
                "common.warning.bad_request", errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleCommon(Exception ex, WebRequest request) {
        ex.printStackTrace();
        return APIResponseUtils.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                "common.error.internal_server");
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Object> handleAuthentication(Exception ex, WebRequest request) {
        ex.printStackTrace();
        return APIResponseUtils.buildResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());
    }


    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleDataNotFound(Exception ex, WebRequest request) {
        ex.printStackTrace();
        return APIResponseUtils.buildResponse(HttpStatus.NOT_FOUND,
                ex.getMessage());
    }


}
