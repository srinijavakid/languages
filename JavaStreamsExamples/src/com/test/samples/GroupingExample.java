package com.test.samples;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.test.data.DataHub;
import com.test.models.Employee;

public class GroupingExample {

	private static List<Employee> employeesList;

	public static void main(String[] args) {

		employeesList = DataHub.getEmployeeDatas();

		Map<String, Long> collect = employeesList.stream()
				.collect(Collectors.groupingBy(Employee::getDesignation,Collectors.counting()));
		System.out.println(collect);

	}

}
