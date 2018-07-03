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
	
	private static List<Student> studentObjList = null;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = null;
		File file = null;
		FileReader fileReader = null;
		BufferedReader br = null;
		
		try {
			studentObjList = new ArrayList<>();
			sc = new Scanner(System.in);
			
			System.out.print("Enter the file path and name to read : ");
			String filePath = sc.nextLine();
			
			file = new File(filePath);
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			
			String line = null;
			int lineNumber = 0;
			while((line = br.readLine()) != null) {
				try {
					lineNumber++;
					studentObjList.add(new Student(line.split(",")));
				}
				catch(Exception e) {
					System.err.println("Invalid input line : " + lineNumber);
				}
			}
			
			Sort_Student sortStudentBy = new Sort_Student();
			
			while(true) {
				List<Student> resultList = null;
				System.out.print("1. Search and sort\n2. Sort\n3. Exit\nEnter you choice : ");
				int userChoice = Integer.parseInt(sc.nextLine());
				
				switch(userChoice) {
					case 1 : 
						resultList = searchStudentList(studentObjList, sc);
						sortStudent(resultList, sortStudentBy, sc);
						System.out.println("Searched and sorted output : ");
						System.out.printf("%-12s%-12s%-12s%-12s%-12s\n", "Id", "First Name", "Last Name", "Branch", "Year");
						for(Student student : resultList)
							printstudentObject(student);
						break;
					case 2 :
						resultList = studentObjList;
						sortStudent(resultList, sortStudentBy, sc);
						System.out.println("Sorted output : ");
						System.out.printf("%-12s%-12s%-12s%-12s%-12s\n", "Id", "First Name", "Last Name", "Branch", "Year");
						for(Student student : resultList)
							printstudentObject(student);
						break;
					case 3 : System.exit(0);
						break;
					default : System.out.println("Invalid choice.");
				}
			}
		}
		catch(Exception e) {
			System.out.println("Invalid file name.");
			e.printStackTrace();
		}
		finally {
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
			if(student.getFirstName().toLowerCase().indexOf(searchTerm) != -1 ||
					student.getLastName().toLowerCase().indexOf(searchTerm) != -1 ||
					student.getBranch().toLowerCase().indexOf(searchTerm) != -1 ||
					Integer.toString(student.getId()).toLowerCase().indexOf(searchTerm) != -1 ||
					Integer.toString(student.getYear()).toLowerCase().indexOf(searchTerm) != -1)
				resultFromSearch.add(student);
		}
		
		return resultFromSearch;
	}
	
	private static void sortStudent(List<Student> studentList, Sort_Student sortStudentBy, Scanner sc) {
		System.out.println("Sort output by\n1. First Name\n2. Last Name\n3. Branch\n4. Id\n5. Year");
		System.out.print("Your selection : ");
		int sortBySelection = Integer.parseInt(sc.nextLine());
		
		switch(sortBySelection) {
			case 1 : Collections.sort(studentList, sortStudentBy.getComparator("byFirstName"));
				break;
			case 2 : Collections.sort(studentList, sortStudentBy.getComparator("byLastName"));
				break;
			case 3 : Collections.sort(studentList, sortStudentBy.getComparator("byBranch"));
				break;
			case 4 : Collections.sort(studentList, sortStudentBy.getComparator("byId"));
				break;
			case 5 : Collections.sort(studentList, sortStudentBy.getComparator("byYear"));
				break;
			default : System.out.println("Invalid selection.");
		}
	}
	
	private static void printstudentObject(Student student) {
		System.out.printf("%-12s%-12s%-12s%-12s%-12s\n",student.getId(), student.getFirstName(), student.getLastName(), student.getBranch(), student.getYear());
	}
}
