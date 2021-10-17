package com.zeeshan.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zeeshan.redis.model.Country;
import com.zeeshan.redis.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	private static final String REDIS_CACHE_VALUE = "country";
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public List<Country> getAllCountry() {
		return countryRepository.findAll();
	}

	@Override
	@CachePut(value = REDIS_CACHE_VALUE, key = "#country.id")
	public Country save(Country country) {
		Country country1 = countryRepository.save(country);
		return country1;
	}

	@Override
	@CacheEvict(value = REDIS_CACHE_VALUE, key = "#id")
	public List<Country> deleteCountryById(int id) {
		countryRepository.deleteById(id);
		return countryRepository.findAll();
	}

	@Override
	@Cacheable(value = REDIS_CACHE_VALUE, key = "#id")
	public Country findbyId(int id) {
		return countryRepository.findFirstById(id);
	}

}
