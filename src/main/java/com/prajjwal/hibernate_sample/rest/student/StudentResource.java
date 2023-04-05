package com.prajjwal.hibernate_sample.rest.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prajjwal.hibernate_sample.domain.Student;
import com.prajjwal.hibernate_sample.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentResource {

	@Autowired
	StudentService studentService;

	@PostMapping("/v1/students")
	private ResponseEntity<Student> addNewStudent(@RequestBody Student student) {

		student = studentService.saveStudent(student);
		return ResponseEntity.ok(student);
	}

	@GetMapping("/v1/students")
	private ResponseEntity<List<Student>> filterStudents(@RequestParam(name = "fname", required = false) String fname,
			@RequestParam(name = "lname", required = false) String lname,
			@RequestParam(name = "age", required = false) Integer age,
			@RequestParam(name = "pass", required = false) String pass) {
		if (studentService == null) {
			System.out.println("yes");
		}
		List<Student> students = 
				studentService.filterStudent(fname, lname, 
						age, pass);
		return ResponseEntity.ok(students);
	}
}
