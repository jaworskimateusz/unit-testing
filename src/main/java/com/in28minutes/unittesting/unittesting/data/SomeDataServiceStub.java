package com.in28minutes.unittesting.unittesting.data;

public class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {1, 2, 3};
	}

}
