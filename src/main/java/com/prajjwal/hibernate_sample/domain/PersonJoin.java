package com.prajjwal.hibernate_sample.domain;

import javax.persistence.Column;

//@Entity
public class PersonJoin {

	@Column(name = "teacher_field")
	private String teacherField;
	@Column(name = "person_field")
	private String personField;

	public String getTeacherField() {
		return teacherField;
	}

	public void setTeacherField(String teacherField) {
		this.teacherField = teacherField;
	}

	public String getPersonField() {
		return personField;
	}

	public void setPersonField(String personField) {
		this.personField = personField;
	}

}
