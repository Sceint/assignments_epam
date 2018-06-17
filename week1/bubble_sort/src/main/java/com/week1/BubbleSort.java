package com.week1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class BubbleSort {
	
	public String sortbyBubblesort(String input) {
		StringBuilder result = new StringBuilder();
		
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
	
	public static void main(String args[]) {
		Scanner sc = null;
		
		try {
			sc =  new Scanner(System.in);
			System.out.println("Enter all the numbers to be sorted in one line :");
			String input = sc.nextLine();
			
			BubbleSort qs = new BubbleSort();
			String output = qs.sortbyBubblesort(input);
			
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
