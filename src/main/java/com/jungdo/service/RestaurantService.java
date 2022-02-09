package com.jungdo.service;

import com.jungdo.entity.Restaurant;

import java.util.Optional;

public interface RestaurantService {
    Optional<Restaurant> findById(Long id);
}
