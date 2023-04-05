package com.prajjwal.hibernate_sample.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prajjwal.hibernate_sample.domain.Person;
import com.prajjwal.hibernate_sample.domain.PersonJoin;

public interface PersonRepository extends JpaRepository<Person, String> {

	Optional<Person> findByFirstName(String firstName);

	@Query(value = "select p.person_field, s.teacher_field from person p "
			+ "join teacher_field s on p.person_field = s.teacher_field", nativeQuery = true)
	List<PersonJoin> getJoinedWithteacher();
}
