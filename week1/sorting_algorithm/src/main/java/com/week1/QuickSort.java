package com.week1;

import java.util.Arrays;

public class QuickSort {

	/*
	 * Method to sort the given input of numbers by Quick sort
	 * Parameters : 1 (single space separated numbers which are to be sorted)
	 * Return type : String (single space separated sorted numbers using Quick sort)
	 */
	public String sortbyQuicksort(String input) {
		int arr[];
		StringBuilder result = new StringBuilder("");
		
		try {
			arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray(); 
			
			arr = quickSortAlgo(arr, 0, arr.length - 1);
			
			for(int i: arr)
				result.append(i + " ");
		}
		catch(NumberFormatException e) { //Occurs when input is not specified correctly
			System.err.print("Invalid input"); 
		}
		
		return result.toString().trim();
	}
	
	/*
	 * Method which involves logic for Quick sort
	 * Parameters : 3 (Integer input array, low[initially 0], high[initially number of input numbers - 1])
	 * Return type : Integer array (Output of the algorithm)
	 */
	private int[] quickSortAlgo(int[] arrNew, int low, int high) {
		int i = low;
		int j = high;
		int pivot = arrNew[low + (high - low) / 2];
		
		while(i <= j) {
			while(arrNew[i] < pivot)
					i++;
			
			while(arrNew[j] > pivot)
				j--;
			
			if(i <= j) {
				int temp = arrNew[i];
				arrNew[i] = arrNew[j];
				arrNew[j] = temp;
				i++;
				j--;
			}
		}
		
		if (low < j)
			quickSortAlgo(arrNew, low, j);
        if (i < high)
        	quickSortAlgo(arrNew, i, high);
		
		return arrNew;
	}
}
