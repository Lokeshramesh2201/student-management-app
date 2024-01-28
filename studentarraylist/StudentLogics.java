package com.qsp.m7.studentarraylist;

import java.util.ArrayList;


public class StudentLogics {
	ArrayList students = new ArrayList();
	private static int count = 0;
	
	
	public static int getCount() {
		return count;
	}
	public void addStudents(Student student) {
		students.add(student);
		count++;
		System.out.println("Student Details are added");
	}
	public void displayStudent() {
		if(count!=0) {
		for(int i=0;i<students.size();i++) {
			System.out.println(students.get(i) + " is present ");
		}
		}
		else
		{
			System.out.println("No Students are added");
		}
		
	}
	public void searchStudentById(int sId) {
		
		for (int i = 0; i < students.size(); i++) {
			Student s = (Student)students.get(i);
			if(s.getsId()==sId) {
				System.out.println("Student with the id "+ sId + " is present ");
				return;
			}
			
		}
		System.out.println("Student with the id " + sId + " is not available ");
	}
	public void searchStudentByName(String sName) {
		boolean flag = true;
		for (int i = 0; i < students.size(); i++) {
			Student s = (Student)students.get(i);
			if(s.getsName().equalsIgnoreCase(sName)) {
				System.out.println("Student with the name "+ sName + " is present ");
				flag = false;
			}
			
		}
		if(flag) {
			System.out.println("Student with the name " + sName + " is not available ");
		}
	}
public void removeStudentById(int sId) {
		
		for (int i = 0; i < students.size(); i++) {
			Student s = (Student)students.get(i);
			if(s.getsId()==sId) {
				System.out.println("Student with the id "+ sId + " is removed from the database");
				students.remove(s);
				count--;
				return;
			}
			
		}
		System.out.println("Student with the id " + sId + " is not available ");
	}
	public void removeStudentByName(String sName) {
		boolean flag = true;
		for (int i = 0; i < students.size(); i++) {
			Student s = (Student)students.get(i);
			if(s.getsName().equalsIgnoreCase(sName)) {
				System.out.println("Student with the name "+ sName + " is removed from the database ");
				students.remove(s);
				count--;
				flag = false;
			}
			
		}
		if(flag) {
			System.out.println("Book with the name " + sName + " is not available ");
		}
	}
}
