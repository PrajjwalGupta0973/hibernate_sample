package com.prajjwal.hibernate_sample.service;

import java.util.List;

import com.prajjwal.hibernate_sample.domain.Student;

public interface StudentService {

	Student saveStudent(Student student);

	List<Student> filterStudent(String firstName, String lastName, Integer age, String password);
}
