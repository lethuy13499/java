package com.jungdo.service.impl;

import com.jungdo.entity.Restaurant;
import com.jungdo.service.RestaurantService;

import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService {
    @Override
    public Optional<Restaurant> findById(Long id) {
        return Optional.empty();
    }
}
