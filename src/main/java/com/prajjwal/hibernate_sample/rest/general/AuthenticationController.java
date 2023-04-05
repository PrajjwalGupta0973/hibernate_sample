package com.prajjwal.hibernate_sample.rest.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prajjwal.hibernate_sample.domain.Person;
import com.prajjwal.hibernate_sample.dto.JwtTokenResponse;
import com.prajjwal.hibernate_sample.dto.UsernamePasswordDto;
import com.prajjwal.hibernate_sample.serviceImpl.CustomUserDetailsService;
import com.prajjwal.hibernate_sample.utils.jwt.JwtTokenUtil;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@PostMapping("/v1/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UsernamePasswordDto user) throws Exception {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect user name or password" + e);
		}
		Person userDetails = (Person) customUserDetailsService
				.loadUserByUsername(user.getUserName());
		String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtTokenResponse(jwt));
	}
}
