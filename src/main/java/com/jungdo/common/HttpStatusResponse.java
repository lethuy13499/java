package com.jungdo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpStatusResponse {
    private String code;
    private Integer http;
    private Object content;
}
