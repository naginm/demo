package com.example.demo.beer.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;
import com.example.demo.user.User;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		//return (List<User>) userRepository.findAll(); 
		List<User> userDetails = userRepository.findAll();
		userDetails.forEach(System.out::println);
		return userDetails;
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> findUserById(@RequestParam("id") Long id) {
		return userRepository.findById(id);
	}
	
	@PostMapping("/users")
	public void addUser(@Valid @RequestBody User user) {
		userRepository.save(user);
	}
	
}
