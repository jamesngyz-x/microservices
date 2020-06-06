package com.jamesngyz.x.microservices.userservice.user;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    User createUser(CreateUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setId(UUID.randomUUID());
        return repository.save(user);
    }
}
