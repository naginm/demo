package com.example.demo.beer.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beer.Beer;
import com.example.demo.repository.BeerRepository;

@RestController
public class BeerController {

	private BeerRepository beerRepository;

	public BeerController(BeerRepository beerRepository) {
		super();
		this.beerRepository = beerRepository;
	}
	
	@GetMapping("/good-beers")
	@CrossOrigin(origins="http://localhost:4200")
	public Collection<Beer> getGoodBeers() {
		return beerRepository.findAll().stream().filter(this::isGreat).collect(Collectors.toList());
		//return null;
	}
	
	private boolean isGreat(Beer beer) {
		
		return !beer.getName().equals("colors light") && !beer.getName().equals("King fisher");
	}
}
