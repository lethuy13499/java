package com.jungdo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
public class APIResponse {
    private Instant timestamp;

    private String code;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Object data;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Object> errors;
}
