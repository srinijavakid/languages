package com.test.programs;

import java.util.List;
import java.util.stream.Collectors;

import com.test.data.DataHub;
import com.test.models.Employee;

public class StreamFiltersAndPredicates {

	public static void main(String[] args) {
		employeeFilters();
	}

	/**
	 * Normal int filter
	 */
	public static void intFilter() {

		List<Integer> intDatas = DataHub.getIntDatas();

		System.out.println(intDatas.stream().filter(p -> p > 50).collect(Collectors.toList()));
	}

	/**
	 * Normal String filter
	 */
	public static void stringFilter() {

		List<String> intDatas = DataHub.getStringDatas();

		System.out.println(intDatas.stream().filter(p -> p.equals("cat")).collect(Collectors.toList()));
	}

	/**
	 * Normal complex Object filter conditions
	 */
	public static void employeeFilters() {

		List<Employee> data = DataHub.getEmployeeDatas();

		System.out.println(data.stream().filter(p -> p.getName().equals("sam")).collect(Collectors.toList()));
	}

	/**
	 * I have defined predicates in employee objects itself And returned a filer
	 * list by passing desired predicates. It will be now open for all who uses this
	 * employee class
	 */
	public static void filterComplexDataUsingPredicate() {

		List<Employee> data = DataHub.getEmployeeDatas();
		System.out.println(Employee.filterEmployees(data, Employee.getIdmorethanFive()));
		System.out.println(Employee.filterEmployees(data, Employee.getIdlessthanFiveAndNameSam()));
		System.out.println(Employee.filterEmployees(data, Employee.getIdmorethanFiveandSalryAboveThousand()));

	}

}
