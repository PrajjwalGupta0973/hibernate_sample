package com.prajjwal.hibernate_sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "Teacher")
@Data
@AllArgsConstructor
@ToString
@Table(name = "teacher_master")
@NamedQuery(name = "t.find", query = "From Teacher")
@NoArgsConstructor
@ApiModel(value = "Teacher Model Resource")
public class Teacher {

	@Id
	@GeneratedValue(generator = "teacherIdGenerator")
	@GenericGenerator(name = "teacherIdGenerator", strategy = "com.prajjwal.hibernate_sample.utils.idgenerators.TeacherIdGenerator", parameters = {
			@Parameter(name = "appendString", value = "Emp") })
	@ApiModelProperty(position = 2)
	private String id;

	@ApiModelProperty(position = 1, value = "The name of the teacher", example = "Naveen")
	@JsonProperty(value = "teacherName")
	private String name;

	@Transient
	@ApiModelProperty(hidden = true, position = 3)
	private String idAppender;

	@ApiModelProperty(position = 0)
	private int salary;

	@Column(name = "teacher_field")
	private String teacherField;

	public Teacher(String name, String idAppender) {
		this.name = name;
		this.idAppender = idAppender;
	}
}
