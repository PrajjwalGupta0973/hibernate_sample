package com.prajjwal.hibernate_sample.domain;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("student")
@Data
public class Student {

	@Id
	private String id;
	@NotBlank(message = "First Name is mandatory")
	private String firstName;
	private String lastName;
	private int age;
	private String password;
	private String studentField;
}
