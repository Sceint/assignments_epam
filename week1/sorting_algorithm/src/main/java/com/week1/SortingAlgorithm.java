package com.week1;

import java.util.Scanner;

public class SortingAlgorithm {
	
	/*
	 * Method to scan the input numbers that are to be sorted
	 * Parameters : 1 (Scanner object to read from Standard input)
	 * Return type : String (Scanned input data)
	 */
	private static String scanInput(Scanner sc) {
		
		System.out.println("Enter all the numbers to be sorted in one line (seperated by single space):");
		String input = sc.nextLine();
		
		return input;
	}
	
	public static void main(String args[]) {
		Scanner sc = null;
		
		try {
			sc =  new Scanner(System.in); //Scanner object for reading from Standard input i.e : System.in
			
			String input = "", output = "";
			
			while(true) {
				System.out.println("Sort using :\n1. Bubble Sort\n2. Merge Sort\n3. Quick Sort\n4. Exit\nEnter yor choice :");
				int choice = Integer.parseInt(sc.nextLine());

				switch(choice) {
					case 1: //Creates Bubble sort object and invokes the sortbyBubblesort method in the class.
						input = scanInput(sc);
						BubbleSort bs = new BubbleSort();
						output = bs.sortbyBubblesort(input);
						break;
					case 2: //Creates Merge sort object and invokes the sortbyMergesort method in the class.
						input = scanInput(sc);
						MergeSort ms = new MergeSort();
						output = ms.sortbyMergesort(input);
						break;
					case 3: //Creates Quick sort object and invokes the sortbyQuicksort method in the class.
						input = scanInput(sc);
						QuickSort qs = new QuickSort();
						output = qs.sortbyQuicksort(input);
						break;
					case 4: //Terminates the program with exit status 0
						System.exit(0);
					default: System.out.println("Wrong Input");
				}
				
				if(!output.equals("")) { 
					System.out.println("The sorted output is : " + output);
					output = "";
				}
			}
		}
		catch(NumberFormatException e) {
			System.err.print("Invalid input");
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
