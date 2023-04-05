package com.prajjwal.hibernate_sample.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.prajjwal.hibernate_sample.domain.Student;
import com.prajjwal.hibernate_sample.repository.StudentRepository;
import com.prajjwal.hibernate_sample.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> filterStudent(String firstName, String lastName, Integer age, String password) {
		Query query = new Query();
		List<Criteria> cAndList = new ArrayList<Criteria>(
				Arrays.asList(Criteria.where("age").is(age), Criteria.where("password").is(password)));
		query.addCriteria(new Criteria().andOperator(cAndList.toArray(new Criteria[cAndList.size()])));

		Criteria[] cORList = new Criteria[] { Criteria.where("firstName").is(firstName),
				Criteria.where("lastName").is(lastName) };
		Criteria cAnd = new Criteria().andOperator(cAndList.toArray(new Criteria[cAndList.size()]));
		Criteria cOr = new Criteria().orOperator(cORList);
		Criteria finalAnd = new Criteria().andOperator(cAnd, cOr);
		query.addCriteria(finalAnd);
		List<Student> filteredStudents = mongoTemplate.find(query, Student.class);
		return filteredStudents;
	}
}
