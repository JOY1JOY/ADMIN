package com.manager.www.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.manager.www.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{
	
	public List<Person> findByEmail(String email);
	
}
