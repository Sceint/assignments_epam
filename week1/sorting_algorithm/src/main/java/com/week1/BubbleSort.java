package com.week1;

import java.util.Arrays;

public class BubbleSort {
	
	/*
	 * Method to sort the given input of numbers by Bubble sort algorithm
	 * Parameters : 1 (single space separated numbers which are to be sorted)
	 * Return type : String (single space separated sorted numbers using Bubble sort)
	 */
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
		catch(NumberFormatException e) { //Occurs when input is not specified correctly
			System.err.print("Invalid input");
		}
		
		return result.toString().trim();
	}
}
