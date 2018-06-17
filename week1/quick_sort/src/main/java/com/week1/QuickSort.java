package com.week1;

import java.util.Arrays;
import java.util.Scanner;

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
			System.err.print("Invalid input");
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
	
	public static void main(String args[]) {
		Scanner sc = null;
		
		try {
			sc =  new Scanner(System.in);
			System.out.println("Enter all the numbers to be sorted in one line :");
			String input = sc.nextLine();
			
			QuickSort qs = new QuickSort();
			String output = qs.sortbyQuicksort(input);
			
			System.out.println("The sorted output is : " + output);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(sc != null)
				sc.close();
		}
	}
}
