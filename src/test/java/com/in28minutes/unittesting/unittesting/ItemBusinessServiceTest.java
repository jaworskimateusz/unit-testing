package com.in28minutes.unittesting.unittesting;


import com.in28minutes.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.model.Item;
import com.in28minutes.unittesting.unittesting.business.SomeBusinessImpl;
import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

	@InjectMocks
	private ItemBusinessService itemBusinessService;
	
	@Mock
	private ItemRepository itemRepository = mock(ItemRepository.class);
	
	@Test
	public void findAll_basic() {
		when(itemRepository.findAll()).thenReturn(java.util.Arrays.asList(
				new Item(1,"Gun", 1200, 10),
				new Item(2,"Screen", 2100, 10)));
		List<Item> items = itemBusinessService.retrieveAllItems();
		assertEquals(12000,items.get(0).getValue());
		assertEquals(21000,items.get(1).getValue());
	}

	
}
