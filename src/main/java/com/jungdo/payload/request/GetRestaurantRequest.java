package com.jungdo.payload.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class GetRestaurantRequest {
    private String name;
    private String status;
    private String address;
    private Integer categoryId;
    private String location;

}
