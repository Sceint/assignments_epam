package com.week2;

import java.util.Comparator;

public class Sort_Student {
	
	private Comparator<Student> forFirstName, forLastName, forBranch, forId, forYear;
	
	Sort_Student(){
		forFirstName = new SortByFirstName();
		forLastName = new SortByLastName();
		forBranch = new SortByBranch();
		forId = new SortById();
		forYear = new SortByYear();
	}
	
	private class SortByFirstName implements Comparator<Student>{
		public int compare(Student s1, Student s2) {
			return s1.getFirstName().compareTo(s2.getFirstName());
		}
	}
	
	private class SortByLastName implements Comparator<Student>{
		public int compare(Student s1, Student s2) {
			return s1.getLastName().compareTo(s2.getLastName());
		}
	}
	
	private class SortByBranch implements Comparator<Student>{
		public int compare(Student s1, Student s2) {
			return s1.getBranch().compareTo(s2.getBranch());
		}
	}
	
	private class SortById implements Comparator<Student>{
		public int compare(Student s1, Student s2) {
			return s1.getId() - s2.getId();
		}
	}
	
	private class SortByYear implements Comparator<Student>{
		public int compare(Student s1, Student s2) {
			return s1.getYear() - s2.getYear();
		}
	}
	
	public Comparator<Student> getComparator(String comparatorName) {
		if(comparatorName.equals("byFirstName"))
			return forFirstName;
		else if(comparatorName.equals("byLastName"))
			return forLastName;
		else if(comparatorName.equals("byBranch"))
			return forBranch;
		else if(comparatorName.equals("byId"))
			return forId;
		else if(comparatorName.equals("byYear"))
			return forYear;
		else
			return null;
	}
}
