package com.prajjwal.hibernate_sample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prajjwal.hibernate_sample.domain.Student;

public interface StudentRepository extends MongoRepository<Student, String>{

}
