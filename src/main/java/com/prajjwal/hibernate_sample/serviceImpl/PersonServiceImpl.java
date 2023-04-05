package com.prajjwal.hibernate_sample.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prajjwal.hibernate_sample.domain.Person;
import com.prajjwal.hibernate_sample.domain.PersonJoin;
import com.prajjwal.hibernate_sample.repository.PersonRepository;
import com.prajjwal.hibernate_sample.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public List<Person> addNewPersons(List<Person> persons) {

		return personRepo.saveAll(persons);
	}

	@Override
	public Optional<Person> getById(String id, boolean myCacheCondition) {
		Person person = null;
		Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principle != null && principle instanceof Person) {
			person = (Person) principle;
			log.info("person authorities: {}", person.getAuthorities());
		} else {
			log.info("user: {}", principle);
		}

		System.out.println(passwordEncoder.encode("abcd"));
		simulateSlowService();
		return personRepo.findById(id);
	}

	private void simulateSlowService() {
		try {
			long time = 3000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public Person addOne(Person person) {
		return personRepo.save(person);
	}

	@Override
	public List<PersonJoin> testJoin() {
		return personRepo.getJoinedWithteacher();
	}
}
