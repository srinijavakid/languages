package com.test.programs;

import java.util.List;

import com.test.data.DataHub;
import com.test.models.Employee;

public class StreamConditions {

	public static void main(String[] args) {
		noneMatchCondition();
	}

	/**
	 * all the employee data in the list should satisfy
	 * 
	 * that is here all the employee salary is above 500 hence returned true
	 */
	public static void allMatchCondition() {

		List<Employee> data = DataHub.getEmployeeDatas();

		boolean allMatch = data.stream().allMatch(Employee.getSalaryAboveHundred());

		System.out.println("Result Employee salary all above 500:  " + allMatch);

	}

	/**
	 * if any data in the employee list satisfy conditions it return true
	 * 
	 */
	public static void anyMatchCondition() {

		List<Employee> data = DataHub.getEmployeeDatas();

		boolean anyMatch = data.stream().anyMatch(Employee.getIdlessthanFive());

		System.out.println("Result Employee id anything one is less than five:  " + anyMatch);

	}
	
	
	/**
	 *If nothing match the condition alone will retun true
	 */
	public static void noneMatchCondition() {

		List<Employee> data = DataHub.getEmployeeDatas();

		boolean noneMatch = data.stream().noneMatch(Employee.getIdmorethanThousand());

		System.out.println("Result Employee id anything one is less than five:  " + noneMatch);

	}

}
