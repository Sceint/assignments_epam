package com.week2;

import java.util.Comparator;

public class Sort_Student {
	
	private Comparator<Student> forFirstName, forLastName, forBranch, forId, forYear; //comparator objectReferences
	
	Sort_Student(){
		initializeComparators();
	}
	
	private void initializeComparators(){ //Initializes comparators
		forFirstName = new SortByFirstName();
		forLastName = new SortByLastName();
		forBranch = new SortByBranch();
		forId = new SortById();
		forYear = new SortByYear();
	}
	
	private class SortByFirstName implements Comparator<Student>{	//Comparator to sort by First Name
		public int compare(Student s1, Student s2) {
			return s1.getFirstName().compareTo(s2.getFirstName());
		}
	}
	
	private class SortByLastName implements Comparator<Student>{	//Comparator to sort by Last Name
		public int compare(Student s1, Student s2) {
			return s1.getLastName().compareTo(s2.getLastName());
		}
	}
	
	private class SortByBranch implements Comparator<Student>{	//Comparator to sort by Branch
		public int compare(Student s1, Student s2) {
			return s1.getBranch().compareTo(s2.getBranch());
		}
	}
	
	private class SortById implements Comparator<Student>{	//Comparator to sort by Id
		public int compare(Student s1, Student s2) {
			return s1.getId() - s2.getId();
		}
	}
	
	private class SortByYear implements Comparator<Student>{	//Comparator to sort by Year
		public int compare(Student s1, Student s2) {
			return s1.getYear() - s2.getYear();
		}
	}
	
	public Comparator<Student> getComparator(String comparatorName) {	//returns the suitable comparator
		switch(comparatorName) {
		case "byFirstName" : return forFirstName;
		
		case "byLastName" : return forLastName;
		
		case "byBranch" : return forBranch;
		
		case "byId" : return forId;
		
		case "byYear" : return forYear;
		
		default : return null;
		}
	}
}
