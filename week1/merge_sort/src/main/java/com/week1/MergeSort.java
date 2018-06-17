package com.week1;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	
	int[] arr, temp;

	public String sortbyMergesort(String input) {
		StringBuilder result = new StringBuilder();
		
		try {
			arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
			temp = new int[arr.length];
			partition(0, arr.length - 1);
			
			for(int i: arr)
				result.append(i + " ");
		}
		catch(NumberFormatException e) {
			System.err.print("Invalid input");
		}
		
		return result.toString().trim();
	}
	
	private void partition(int low, int high) {
		int mid;
		
		if(low < high) {
			mid = low + (high - low) / 2;
			partition(low, mid);
			partition(mid + 1, high);
			mergeSortAlgo(low, mid, high);
		}
	}
	
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
	
	public static void main(String args[]) {
		Scanner sc = null;
		
		try {
			sc =  new Scanner(System.in);
			System.out.println("Enter all the numbers to be sorted in one line :");
			String input = sc.nextLine();
			
			MergeSort qs = new MergeSort();
			String output = qs.sortbyMergesort(input);
			
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
