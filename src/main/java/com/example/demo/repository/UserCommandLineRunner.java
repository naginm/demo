package com.example.demo.repository;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.user.User;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	private final UserRepository userRepository;
	
	public UserCommandLineRunner(UserRepository userRepository) {
		//super();
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Stream.of("Mahesh","Suguna","Sreesathvik").forEach(name -> {
			User user = new User(name, name.toLowerCase()+"@domain.com");
			userRepository.save(user);
		});
		userRepository.findAll().forEach(System.out::println);
	}
	

}
