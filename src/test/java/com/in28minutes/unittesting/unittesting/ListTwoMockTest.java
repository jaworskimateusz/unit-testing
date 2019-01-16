package com.in28minutes.unittesting.unittesting;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTwoMockTest {

	private List<Integer> list = mock(List.class);
	
	@Test
	public void size_basic() {
		when(list.size()).thenReturn(5);
		assertEquals(5, list.size());
	}
	
	@Test
	public void size_empty() {
		when(list.size()).thenReturn(0);
		assertEquals(0, list.size());
	}

}
