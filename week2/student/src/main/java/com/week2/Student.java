package com.week2;

public class Student{
	private int id, year;
	private String firstName, lastName, branch;
	
	Student(String studentData[]){	//Sets data to student object
		this.setId(Integer.parseInt(studentData[0]));
		this.setFirstName(studentData[1]);
		this.setLastName(studentData[2]);
		this.setBranch(studentData[3]);
		this.setYear(Integer.parseInt(studentData[4]));
	}

	public int getId() {	//returns Id
		return id;
	}

	public void setId(int id) {	//sets Id
		this.id = id;
	}

	public int getYear() {	//returns Year
		return year;
	}

	public void setYear(int year) {	//sets Year
		this.year = year;
	}

	public String getFirstName() {	//returns First name
		return firstName;
	}

	public void setFirstName(String firstName) {	//sets First name
		this.firstName = firstName;
	}

	public String getLastName() {	//returns Last name
		return lastName;
	}

	public void setLastName(String lastName) {	//sets Last name
		this.lastName = lastName;
	}

	public String getBranch() {	//returns Branch
		return branch;
	}

	public void setBranch(String branch) {	//sets Branch
		this.branch = branch;
	}
}
