package com.jungdo.repository;

import com.jungdo.entity.Restaurant;
import com.jungdo.payload.request.GetRestaurantRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Page<Restaurant> getAll(GetRestaurantRequest request, Pageable pageable);



}
