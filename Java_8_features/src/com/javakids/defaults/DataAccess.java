package com.javakids.defaults;

/**
 * 
 * Data layer to get details from both the interfaces
 * 
 * Error will be thrown as get age is default in both the interfaces
 * 
 * try to remove the overridden method of getage below in this class and try
 * 
 * @author srini
 *
 */
public class DataAccess implements Employee, Person {

	@Override
	public void getPersonalDetails() {
		System.out.println("Got person Details");
	}

	@Override
	public void getWorkDone() {
		System.out.println("Work Completed");

	}

	@Override
	public int getAge() {
		
		// we can call the default interface method also in this below way.
		Person.super.getAge();
		return Employee.super.getAge();
	}
	
	public EmployeeDetails getDetails() {
		// to call the static methods in interface
		return Employee.getdata();
	}

}
