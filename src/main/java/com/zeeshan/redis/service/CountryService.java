package com.zeeshan.redis.service;

import java.util.List;

import com.zeeshan.redis.model.Country;

public interface CountryService {

	public List<Country> getAllCountry();

	public Country save(Country country);

	public List<Country> deleteCountryById(int id);

	public Country findbyId(int id);

}
