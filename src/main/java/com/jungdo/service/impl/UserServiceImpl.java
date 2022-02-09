package com.jungdo.service.impl;

import com.jungdo.entity.User;
import com.jungdo.repository.AuthRepository;
import com.jungdo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AuthRepository authRepository;

    @Override
    public Optional<User> findById(Long id) {
        return authRepository.findById(id);
    }
}
