package com.test.programs;

import java.util.Comparator;
import java.util.List;

import com.test.data.DataHub;
import com.test.models.Employee;

public class Sorting {

	public static void main(String args[]) {
		sortComplexObjectByCompbarable();
	}

	/**
	 * Sort complex object using comparable
	 */
	public static void sortComplexObjectByCompbarable() {

		List<Employee> data = DataHub.getEmployeeDatas();

		System.out.println("Un sorted List  " + data);

		//data=data.stream().sorted().collect();

		System.out.println("Sorted by asc order  " + data);

	}

	/**
	 * Sort complex object using comparator
	 */
	public static void sortComplexObject() {

		List<Employee> data = DataHub.getEmployeeDatas();

		System.out.println("Un sorted List  " + data);

		data.sort(Comparator.comparing(Employee::getSalary));

		System.out.println("Sorted by asc order  " + data);

		data.sort(Comparator.comparing(Employee::getSalary).reversed());

		System.out.println("Sorted by desc order  " + data);
	}

	/**
	 * Sort complex object like below
	 * 
	 * This is optional only.
	 * 
	 * comparing method serves all the purpose, this is just an option.
	 * 
	 * Also we got comparingLong, comparingDouble too.
	 */
	public static void sortComplexObjectByInt() {

		List<Employee> data = DataHub.getEmployeeDatas();

		System.out.println("Un sorted List  " + data);

		data.sort(Comparator.comparingInt(Employee::getId));

		System.out.println("Sorted by asc order  " + data);

		data.sort(Comparator.comparingInt(Employee::getId).reversed());

		System.out.println("Sorted by desc order  " + data);
	}

	/**
	 * Sort normal String, Integer, Double using below way
	 */
	public static void sortStringValuesOtherWay() {

		List<String> stList = DataHub.getStringDatas();

		System.out.println("Un sorted List  " + stList);

		stList.sort(Comparator.comparing(String::valueOf));

		System.out.println("Sorted by asc order  " + stList);

		stList.sort(Comparator.comparing(String::valueOf).reversed());

		System.out.println("Sorted by desc order  " + stList);

	}

	/**
	 * Sort normal String, Integer, Double using below way
	 */
	public static void sortStringValuesNormalWay() {

		List<String> stList = DataHub.getStringDatas();

		System.out.println("Un sorted List  " + stList);

		stList.sort(Comparator.naturalOrder());

		System.out.println("Sorted by asc order  " + stList);

		stList.sort(Comparator.reverseOrder());

		System.out.println("Sorted by desc order  " + stList);

	}

}
