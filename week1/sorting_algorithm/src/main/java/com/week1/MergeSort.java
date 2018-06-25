package com.week1;

import java.util.Arrays;

public class MergeSort {
	
	int[] arr, temp;

	
	/*
	 * Method to sort the given input of numbers by Merge sort
	 * Parameters : 1 (single space separated numbers which are to be sorted)
	 * Return type : String (single space separated sorted numbers using Merge sort)
	 */
	public String sortbyMergesort(String input) {
		StringBuilder result = new StringBuilder("");
		
		try {
			arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
			temp = new int[arr.length];
			partition(0, arr.length - 1);
			
			for(int i: arr)
				result.append(i + " ");
		}
		catch(NumberFormatException e) { //Occurs when input is not specified correctly
			System.err.print("Invalid input");
		}
		
		return result.toString().trim();
	}
	
	/*
	 * Method to partition array in low, mid and high
	 * Parameters : 2 (low[initially 0], high[initially number of input numbers - 1])
	 * Return type : void
	 */
	private void partition(int low, int high) {
		int mid;
		
		if(low < high) {
			mid = low + (high - low) / 2;
			partition(low, mid);
			partition(mid + 1, high);
			mergeSortAlgo(low, mid, high);
		}
	}
	
	/*
	 * Method which involves logic for Merge sort
	 * Parameters : 3 (Integer input array, low, high)
	 * Return type : Integer array (Output of the algorithm)
	 */
	private void mergeSortAlgo(int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int k = low;
			
		for(int x = low; x <= high; x++)
			temp[x] = arr[x];
		
		while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }
	}
}
