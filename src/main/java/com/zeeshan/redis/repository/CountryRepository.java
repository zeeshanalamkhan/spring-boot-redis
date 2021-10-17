package com.zeeshan.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeeshan.redis.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

	public Country findFirstById(int id);

}
