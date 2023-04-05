package com.prajjwal.hibernate_sample.rest.person;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prajjwal.hibernate_sample.domain.Demo;
import com.prajjwal.hibernate_sample.domain.ExtendDemo;
import com.prajjwal.hibernate_sample.domain.Person;
import com.prajjwal.hibernate_sample.domain.PersonJoin;
import com.prajjwal.hibernate_sample.service.PersonService;

@RestController
@RequestMapping("/api")
@Validated
public class PersonController {

	private PersonService personService;

	private CacheManager chachManager;

	private Demo demo;

	@Autowired
	public PersonController(PersonService personService, CacheManager chachManager,
			@Qualifier("extendDemo") Demo demo) {
		super();
		this.personService = personService;
		this.chachManager = chachManager;
		this.demo = demo;
	}

	@PostMapping("/v1/persons")
	private ResponseEntity<List<Person>> addNewPersons(@RequestBody List<Person> persons) {
		if (personService == null) {
			System.out.println("yes");
		}
		persons = personService.addNewPersons(persons);
		return ResponseEntity.ok(persons);
	}

	@PostMapping("/v1/persons/one")
	private ResponseEntity<Person> addNewPerson(@Valid @RequestBody Person person) {
		return ResponseEntity.ok(personService.addOne(person));
	}

	@GetMapping("/v1/persons/{id}")
	public ResponseEntity<Optional<Person>> getById(@PathVariable("id") String id,
			@RequestParam("my-cache-condition") boolean myCacheCondition,
			@RequestParam("cache-manager-condition") boolean cacheManagerCondition) {
//		System.out.println(demo.getF1());
		if (cacheManagerCondition) {
			chachManager.getCache("personCache").clear();
		}
		return ResponseEntity.ok(personService.getById(id, myCacheCondition));
	}

	@GetMapping("/v1/test_join")
	public void testJoin() {
		List<PersonJoin> personJoins = personService.testJoin();

		for (PersonJoin personJoin : personJoins) {
			System.out.println(personJoin);
		}
	}
}
