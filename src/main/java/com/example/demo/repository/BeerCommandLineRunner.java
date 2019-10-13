package com.example.demo.repository;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.beer.Beer;

@Component
public class BeerCommandLineRunner implements CommandLineRunner {

	public final BeerRepository beerRepository;
	
	public BeerCommandLineRunner(BeerRepository beerRepository) {
		this.beerRepository = beerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Stream.of("King fisher","Bacardi","Jack Daniel","colors light").forEach(name -> beerRepository.save(new Beer(name)));
		beerRepository.findAll().forEach(System.out::println);
	}

}
