package com.test.samples;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.test.data.DataHub;
import com.test.models.Employee;

public class FilterExample {

	private static List<Employee> employeesList;

	public static void main(String[] args) {

		employeesList = DataHub.getEmployeeDatas();

		employeesList.stream()
		.filter(emp -> emp.getSalary() > 5000)
		.sorted(Comparator.comparing(Employee::getSalary))
		.collect(Collectors.toList())
		.forEach(emp -> System.out.println(emp.getSalary()));

	}

}
