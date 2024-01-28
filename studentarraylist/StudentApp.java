package com.qsp.m7.studentarraylist;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentApp {

	static StudentLogics sl = new StudentLogics();
	static {
		System.out.println("Welcome to Student Database..!!");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		selectOption(sc);

	}

	public static void selectOption(Scanner sc) {
		boolean repeat = true;

		while (repeat) {
			try {
				System.out.println("Select an option");
				System.out.println("___________________");
				System.out.println("1) To Add Students");
				System.out.println("2) To Display Students");
				System.out.println("3) To Search Students");
				System.out.println("4) To Remove Students");
				System.out.println("5) To Exit the app");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1: addStudent(sc); break;
				case 2 : sl.displayStudent();break;
				case 3 : searchStudent(sc); break;
				case 4 : deleteStudent(sc); break;
				case 5 : repeat = false; break;
				default: System.out.println("Invalid Selection");
				
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Inputs");
				sc.nextLine();
			}

		}
		System.out.println("Thank You....!!!!!");

	}

	private static void addStudent(Scanner sc) {
		System.out.println("Enter the Student id");int id=sc.nextInt();sc.nextLine();
		System.out.println("Enter the Student name");String name=sc.nextLine();
		System.out.println("Enter the Student age");byte age=sc.nextByte();sc.nextLine();
		
		Student student = new Student(id, name, age);
		sl.addStudents(student);
	}

	private static void searchStudent(Scanner sc) {
		boolean repeat = true;

		if (StudentLogics.getCount() != 0) {
			while (repeat) {
				try {
					System.out.println("Select an option for searching");
					System.out.println("________________________________");
					System.out.println("1) Searching based on id");
					System.out.println("2) Searching based on Name");
					System.out.println("3) To go to Previous menu");
					int choice = sc.nextInt(); 
					sc.nextLine();
					switch (choice) {
					case 1:
						System.out.println("Enter the id ");
						sl.searchStudentById(sc.nextInt());
						break;
					case 2:
						System.out.println("Enter the name ");
						sl.searchStudentByName(sc.nextLine());
						break;
					
					case 3 : repeat = false; break;
					default:
						System.out.println("Invalid Selection");
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input");sc.nextLine();
				}
			}

		} else {
			System.out.println("There are no Students present");
		}
	}
	private static void deleteStudent(Scanner sc ) {
		boolean repeat = true;

		if (StudentLogics.getCount() != 0) {
			while (repeat) {
				try {
					System.out.println("Select an option for Deleting");
					System.out.println("________________________________");
					System.out.println("1) Deleting based on id");
					System.out.println("2) Deleting based on Name");
					System.out.println("3) To go back");
					int choice = sc.nextInt(); sc.nextLine();
					switch (choice) {
					case 1:
						System.out.println("Enter the id ");
						sl.removeStudentById(sc.nextInt());
						break;
					case 2:
						System.out.println("Enter the name ");
						sl.removeStudentByName(sc.nextLine());
						break;
					
					case 3 :
						repeat = false;
						break;
					default:
						System.out.println("Invalid Selection");
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid Input");sc.nextLine();
				}
			}

		} else {
			System.out.println("There are no Students present");
		}
	}

}



