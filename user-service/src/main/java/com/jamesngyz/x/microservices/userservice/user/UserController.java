package com.jamesngyz.x.microservices.userservice.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private final UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@PostMapping(path = "/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) {
		User createdUser = service.createUser(request);
		return ResponseEntity.created(URI.create(createdUser.getId().toString())).body(createdUser);
	}
	
	@GetMapping(path = "/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = service.getUsers();
		return ResponseEntity.ok(users);
	}
	
}
