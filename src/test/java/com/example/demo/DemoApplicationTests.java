package com.example.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc // annotation to automatically configure a "MockMvc" instance
public class DemoApplicationTests {

	@Autowired
	private MockMvc mvc; // MockMvc is a class provided by Spring that allows for testing Spring MVC controllers without needing to start an actual HTTP server

	@Test // indicates that this getHello() method is a test method
	public void getHello() throws Exception { // unit test that mocks the servlet request and response through your endpoint ("i.e. "/"). Performs a get request to "/"
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)) // accept(MediaType.APPLICATION_JSON) means that clients expects a response in JSON format
				.andExpect(status().isOk()) // checks if response has an HTTP status of 200 and has the greeting of "Greetings from Spring Boot!"
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}
}

// test