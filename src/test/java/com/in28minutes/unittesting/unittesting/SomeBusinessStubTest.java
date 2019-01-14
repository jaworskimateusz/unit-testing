package com.in28minutes.unittesting.unittesting;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.in28minutes.unittesting.unittesting.business.SomeBusinessImpl;
import com.in28minutes.unittesting.unittesting.data.SomeDataServiceStub;

public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub()); //here sth might talking to DB
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}
	
}
