package com.prajjwal.hibernate_sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtTokenResponse {

	private String token;
}
