package com.week1;

import java.util.Arrays;

public class QuickSort {

	public String sortbyQuicksort(String input) {
		
		int arr[];
		StringBuilder result = new StringBuilder();
		try {
			arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
			
			arr = quickSortAlgo(arr, 0, arr.length - 1);
			
			for(int i: arr)
				result.append(i + " ");
		}
		catch(NumberFormatException e) {
			System.err.print("Error in Conversion : ");
			e.printStackTrace();
		}
		
		return result.toString().trim();
	}
	
	private int[] quickSortAlgo(int[] arrNew, int low, int high) {
		int i = low;
		int j = high;
		int p = arrNew[low + (high - low) / 2];
		
		while(i <= j) {
			while(arrNew[i] < p)
					i++;
			
			while(arrNew[j] > p)
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
