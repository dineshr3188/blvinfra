package com.example.demo.controller;

import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.User;

@RestController
@RequestMapping("api/v1/")
public class UserController extends UserServiceImpl {

	@GetMapping("/users")
	public Collection<User> getAllUsers(){
		return findAll();
	}
	
	@PostMapping("/user/create")
	public User createUser(@RequestBody User user) {
		return saveorUpdate(user);
		
	}
	
	
}
