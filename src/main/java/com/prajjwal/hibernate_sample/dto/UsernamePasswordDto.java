package com.prajjwal.hibernate_sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UsernamePasswordDto {

	@JsonProperty(value = "user_name")
	private String userName;
	@JsonProperty(value = "password")
	private String password;
}
