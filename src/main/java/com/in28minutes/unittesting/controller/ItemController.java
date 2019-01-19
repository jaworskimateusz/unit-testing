package com.in28minutes.unittesting.controller;

import com.in28minutes.unittesting.business.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.unittesting.model.Item;

@RestController
@RequestMapping("/api")
public class ItemController {

	@Autowired
	private ItemBusinessService itemBusinessService;
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1,"Name",10,100);
	}

	@GetMapping("/business-item")
	public Item businessItem() {
		return itemBusinessService.retrieveHardcodedItem();
	}
	
}
