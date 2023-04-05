package com.prajjwal.hibernate_sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;

import com.prajjwal.hibernate_sample.domain.Person;
import com.prajjwal.hibernate_sample.domain.PersonJoin;

public interface PersonService {

//	@PreAuthorize("hasAuthority('ROLE_PERSON')")
	List<Person> addNewPersons(List<Person> persons);

	@Cacheable(cacheNames = "personCache", condition = "#root.args[1]==true")
	Optional<Person> getById(String id, boolean myCacheCondition);

	Person addOne(Person person);

	List<PersonJoin> testJoin();
}
