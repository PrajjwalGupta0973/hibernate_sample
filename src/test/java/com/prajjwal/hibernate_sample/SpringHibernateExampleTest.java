package com.prajjwal.hibernate_sample;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.prajjwal.hibernate_sample.service.PersonService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc when using MockMnvc
//@WebMvcTest(ControllerClassName.class) when only one controller to be tested (with MockMVC); No need to use @AutoConfigureMockMvc
public class SpringHibernateExampleTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

//	@Autowired
//	private MockMvc mockMvc;
	
	@MockBean
	private PersonService service;
	
	@Test
	@Disabled
	public void shouldAnswerWithTrue() {
		System.out.println("Hello");
		assertTrue(true);
	}
}
