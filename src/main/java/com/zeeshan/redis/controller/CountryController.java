package com.zeeshan.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zeeshan.redis.model.Country;
import com.zeeshan.redis.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@PostMapping(value = "/save")
	public ResponseEntity<Country> save(@RequestBody Country country) {
		return new ResponseEntity<Country>(countryService.save(country), HttpStatus.CREATED);
	}

	@GetMapping(value = "/findById")
	public ResponseEntity<Country> findById(@RequestParam Integer id) throws RuntimeException {
		return new ResponseEntity<Country>(countryService.findbyId(id), HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteById")
	public ResponseEntity<List<Country>> deleteById(@RequestParam Integer id) throws RuntimeException {
		return new ResponseEntity<List<Country>>(countryService.deleteCountryById(id), HttpStatus.OK);
	}

	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Country>> findAll() {
		return new ResponseEntity<List<Country>>(countryService.getAllCountry(), HttpStatus.OK);
	}

}
