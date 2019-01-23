package com.in28minutes.unittesting.unittesting.business;

import java.util.Arrays;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService someDataService;

	public int calculateSum(int [] data) {

		/*
		int sum = 0;
		for(int value : data) {
			sum += value;
		}
		return sum;
		*/

		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}
	
	public int calculateSumUsingDataService() {
		return Arrays.stream(someDataService.retrieveAllData()).reduce(Integer::sum).orElse(0);
	}

	public SomeDataService getSomeDataService() {
		return someDataService;
	}

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}
	
}
