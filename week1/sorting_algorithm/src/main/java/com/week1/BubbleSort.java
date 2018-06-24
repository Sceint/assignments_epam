package com.week1;

import java.util.Arrays;

public class BubbleSort {
	
	public String sortbyBubblesort(String input) {
		StringBuilder result = new StringBuilder("");
		
		try {
			int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
			
			for(int i = 0; i < arr.length - 1; i++) {
				for(int j = i + 1; j < arr.length; j++) {
					if(arr[i] > arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
			
			for(int i: arr)
				result.append(i + " ");
		}
		catch(NumberFormatException e) {
			System.err.print("Invalid input");
		}
		
		return result.toString().trim();
	}
}
