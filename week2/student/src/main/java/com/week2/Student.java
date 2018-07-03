package com.week2;

public class Student{
	private int id, year;
	private String firstName, lastName, branch;
	
	Student(String studentData[]){
		this.setId(Integer.parseInt(studentData[0]));
		this.setFirstName(studentData[1]);
		this.setLastName(studentData[2]);
		this.setBranch(studentData[3]);
		this.setYear(Integer.parseInt(studentData[4]));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
}
