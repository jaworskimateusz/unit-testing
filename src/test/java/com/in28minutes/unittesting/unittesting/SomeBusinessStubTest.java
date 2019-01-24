package com.in28minutes.unittesting.unittesting;


import static org.junit.Assert.assertEquals;


import org.junit.Test;

import com.in28minutes.unittesting.unittesting.business.SomeBusinessImpl;
import com.in28minutes.unittesting.unittesting.data.SomeDataService;
//not good approach
class SomeDataServiceBasicStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {1, 2, 3};
	}

}

class SomeDataServiceEmptyStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}

}

public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceBasicStub()); //here sth might talking to DB
		assertEquals(6, business.calculateSumUsingDataService());
	}
	
}
