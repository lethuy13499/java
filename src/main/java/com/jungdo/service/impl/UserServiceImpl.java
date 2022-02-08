package com.jungdo.service.impl;

import com.jungdo.entity.User;
import com.jungdo.repository.AuthRepository;
import com.jungdo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AuthRepository authRepository;

    @Override
    public Optional<User> findById(Long id) {
        return authRepository.findById(id);
    }
}
