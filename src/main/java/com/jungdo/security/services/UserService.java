package com.jungdo.security.services;

import com.jungdo.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
}
