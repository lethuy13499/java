package com.jungdo.payload.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class GetLocationRequest {
    private Integer categoryId;
    private Integer provinceId;
    private Integer districtId;
    private Integer communeId;
    private Integer restaurantId;

}
