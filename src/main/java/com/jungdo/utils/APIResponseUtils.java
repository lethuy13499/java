package com.jungdo.utils;

import com.jungdo.common.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;

public class APIResponseUtils {
    private APIResponseUtils() {
    }

    public static ResponseEntity<Object> buildResponse(HttpStatus httpStatus) {
        return new ResponseEntity<>(null, httpStatus);
    }

    public static ResponseEntity<Object> buildResponse(HttpStatus httpStatus, String message) {
        APIResponse dto = new APIResponse();
        dto.setTimestamp(Instant.now());
        dto.setCode(message);
//        dto.setMessage(ResourceBundleUtils.getMessage(message));
        return new ResponseEntity<>(dto, httpStatus);
    }

    public static ResponseEntity<Object> buildResponse(HttpStatus httpStatus, String message, Object data) {
        APIResponse dto = new APIResponse();
        dto.setTimestamp(Instant.now());
        dto.setCode(message);
//        dto.setMessage(ResourceBundleUtils.getMessage(message));
        dto.setData(data);
        return new ResponseEntity<>(dto, httpStatus);
    }


}
