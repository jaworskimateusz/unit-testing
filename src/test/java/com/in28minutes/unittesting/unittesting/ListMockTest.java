package com.in28minutes.unittesting.unittesting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

public class ListMockTest {

	List<String> mock = mock(List.class);
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("zero");
		assertEquals("zero", mock.get(0));
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("zero");
		assertEquals("zero", mock.get(0));
	}
	
	@Test
	public void verificationBasics() {
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}
	
	@Test
	public void multipleArgumentCapturing() {
		//SUT
		mock.add("Matt");
		mock.add("Jack");
		
		//VERIFY
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture()); //verify() method check is something is called once; if more -> I need to use verify(object, times(2))
		assertEquals("Matt", captor.getAllValues().get(0));
		assertEquals("Jack", captor.getAllValues().get(1));
	}
	
	@Test
	public void spying() {
		/*
		ArrayList arrayListMock = mock(ArrayList.class);
		arrayListMock.get(0);	//null
		arrayListMock.size(); 	//0
		arrayListMock.add("Electronic");
		arrayListMock.add("Electrotechnics");
		System.out.println(arrayListMock.size()); //0 A mock does not retain behaviour of the original class
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size()); //5
		*/
		
		ArrayList arrayListSpy = spy(ArrayList.class);
		//arrayListSpy.get(0);	throws exception
		System.out.println(arrayListSpy.size()); 	//0
		arrayListSpy.add("Electronic");
		arrayListSpy.add("Electrotechnics");
		System.out.println(arrayListSpy.size()); //0 A spy retains behavior (code) of the original class
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size()); //5
		verify(arrayListSpy).add("Electronic"); //success test
		verify(arrayListSpy).add("Maths"); //failed test
	}
	
	
	
}
