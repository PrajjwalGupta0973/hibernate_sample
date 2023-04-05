package com.prajjwal.hibernate_sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.prajjwal.hibernate_sample.enums.Role;

import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long role_id;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;

}
