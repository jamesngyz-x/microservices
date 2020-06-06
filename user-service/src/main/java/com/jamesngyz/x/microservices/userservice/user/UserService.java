package com.jamesngyz.x.microservices.userservice.user;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

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
	
	List<User> getUsers() {
		return repository.findAll();
	}
}
