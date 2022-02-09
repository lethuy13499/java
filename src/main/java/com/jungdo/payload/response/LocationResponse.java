package com.jungdo.payload.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class LocationResponse {
    private String locationId;
    private String restaurantName;
    private String coordinate;
    private Integer status;
    private String address;
    private Integer phone;
    private Integer districtId;
    private String districtName;
    private Integer communeId;
    private String communeName;
    private Integer provinceId;
    private String provinceName;
}
