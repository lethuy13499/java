package com.jungdo.controller;

import com.jungdo.entity.Restaurant;
import com.jungdo.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") long id) {
        Optional<Restaurant> restaurantData = restaurantRepository.findById(id);

        if (restaurantData.isPresent()) {
            return new ResponseEntity<>(restaurantData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/restaurant")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        try {
            Restaurant _restaurant = restaurantRepository
                    .save(new Restaurant(
                            restaurant.getStatus(),
                            restaurant.getAddress(),
                            restaurant.getImage(),
                            restaurant.getVote(),
                            restaurant.getPhone(),
                            restaurant.getCategory(),
                            restaurant.getLocation()

                            ));
            return new ResponseEntity<>(_restaurant, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
