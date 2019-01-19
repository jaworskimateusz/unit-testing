package com.in28minutes.unittesting.controller;

import com.in28minutes.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	public void dummyItem_basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/api/dummy-item")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\n" +
						"    \"id\": 1,\n" +
						"    \"name\": \"Name\",\n" +
						"    \"price\": 10,\n" +
						"    \"quantity\": 100\n" +
						"}"))
				.andReturn();
	}

	@Test
	public void itemFromBusinessService_basic() throws Exception {
		when(businessService.retrieveHardcodedItem()).thenReturn(
				new Item(2,"Gun", 1200, 100)
		);
		RequestBuilder request = MockMvcRequestBuilders
				.get("/api//business-item")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON);
		System.out.println(request);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id: 2, name: Gun, price: 1200, quantity: 100}"))
				.andReturn();
	}
}
