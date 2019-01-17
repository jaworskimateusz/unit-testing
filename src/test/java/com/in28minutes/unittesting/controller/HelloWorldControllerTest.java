package com.in28minutes.unittesting.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.swing.text.AbstractDocument.Content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloWorldController.class)
public class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloWorld_basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/api/hello-world")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				//.andExpect(content().json("Hello World")) test failed because content is not JSON
				.andExpect(content().string("Hello World"))
				.andReturn();
		
		assertEquals("Hello World", result.getResponse().getContentAsString());
		
		// call  GET "/hello-world" application /json
		// verify "Hello World"
	}
}
