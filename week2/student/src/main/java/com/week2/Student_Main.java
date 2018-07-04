package com.week2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Student_Main {
	
	private static List<Student> studentObjList = null; //List to store student object
	
	public static void main(String[] args) throws IOException {
		Scanner sc = null;				//Scanner to read input
		File file = null;				//File object
		FileReader fileReader = null;	//FileReader to read a file
		BufferedReader br = null;		//BufferredReader to efficiently read a file
		
		try {
			studentObjList = new ArrayList<>();
			sc = new Scanner(System.in);
			
			System.out.print("Enter the file path and name to read : ");
			String filePath = sc.nextLine();	//Stores the file path
			
			file = new File(filePath);
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			
			String line = null;	//Used for storing a line of input from file
			int lineNumber = 0; //Used to keep track of number of line read
			while((line = br.readLine()) != null) {
				try {
					lineNumber++;
					studentObjList.add(new Student(line.split(",")));
				}
				catch(Exception e) {
					System.err.println("Invalid input line : " + lineNumber);
				}
			}
			
			Sort_Student sortStudentBy = new Sort_Student();	//Sort_Student object reference
			
			while(true) {
				List<Student> resultList = null;	//List which holds the result of search and sort
				System.out.print("1. Search and sort\n2. Sort\n3. Exit\nEnter you choice : ");
				int userChoice = Integer.parseInt(sc.nextLine());	//Used for storing users choice
				
				switch(userChoice) {
					case 1 : //For searching and sorting the students
						resultList = searchStudentList(studentObjList, sc);	//Gets the resultant search List
						sortStudent(resultList, sortStudentBy, sc);	//Sorts the list based on users choice
						System.out.println("Searched and sorted output : ");
						System.out.printf("%-12s%-12s%-12s%-12s%-12s\n", "Id", "First_Name", "Last_Name", "Branch", "Year");
						for(Student student : resultList)	//Iterates through each Student object in resultList and prints it.
							printstudentObject(student);
						break;
					case 2 :	//For sorting the students.
						resultList = studentObjList;
						sortStudent(resultList, sortStudentBy, sc);
						System.out.println("Sorted output : ");
						System.out.printf("%-12s%-12s%-12s%-12s%-12s\n", "Id", "First_Name", "Last_Name", "Branch", "Year");
						for(Student student : resultList)
							printstudentObject(student);
						break;
					case 3 : System.exit(0); //Exits the application.
						break;
					default : System.out.println("Invalid choice.");
				}
			}
		}
		catch(Exception e) {
			System.out.println("Invalid file name.");
			e.printStackTrace();
		}
		finally {	// Closing the opened resources
			if(sc != null)
				sc.close();
			if(br != null)
				br.close();
			if(fileReader != null)
				fileReader.close();
		}
	}
	
	private static List<Student> searchStudentList(List<Student> intialStudentList, Scanner sc) {
		System.out.print("Enter search term : ");
		String searchTerm = sc.nextLine();
		searchTerm = searchTerm.toLowerCase();
		
		List<Student> resultFromSearch= new ArrayList<>();
		
		for(Student student : studentObjList) {
			if(student.getFirstName().toLowerCase().indexOf(searchTerm) != -1 ||				//true if search term is present in First name
					student.getLastName().toLowerCase().indexOf(searchTerm) != -1 ||			//true if search term is present in Last name
					student.getBranch().toLowerCase().indexOf(searchTerm) != -1 ||				//true if search term is present Branch
					Integer.toString(student.getId()).toLowerCase().indexOf(searchTerm) != -1 ||//true if search term is present Id
					Integer.toString(student.getYear()).toLowerCase().indexOf(searchTerm) != -1)//true if search term is present Year
				resultFromSearch.add(student);
		}
		
		return resultFromSearch;	//returns the result set of student matching the search term
	}
	
	private static void sortStudent(List<Student> studentList, Sort_Student sortStudentBy, Scanner sc) {
		System.out.println("Sort output by\n1. First Name\n2. Last Name\n3. Branch\n4. Id\n5. Year");
		System.out.print("Your selection : ");
		int sortBySelection = Integer.parseInt(sc.nextLine());
		
		switch(sortBySelection) {
			case 1 : Collections.sort(studentList, sortStudentBy.getComparator("byFirstName")); //Sorts students by First name
				break;
			case 2 : Collections.sort(studentList, sortStudentBy.getComparator("byLastName"));	//Sorts students by Last name
				break;
			case 3 : Collections.sort(studentList, sortStudentBy.getComparator("byBranch"));	//Sorts students by Branch
				break;
			case 4 : Collections.sort(studentList, sortStudentBy.getComparator("byId"));		//Sorts students by Id
				break;
			case 5 : Collections.sort(studentList, sortStudentBy.getComparator("byYear"));		//Sorts students by Year
				break;
			default : System.out.println("Invalid selection.");
		}
	}
	
	private static void printstudentObject(Student student) {	//Prints the student object values
		System.out.printf("%-12s%-12s%-12s%-12s%-12s\n",student.getId(), student.getFirstName(), student.getLastName(), student.getBranch(), student.getYear());
	}
}
