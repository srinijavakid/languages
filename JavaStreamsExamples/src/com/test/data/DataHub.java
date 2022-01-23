package com.test.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.models.Employee;

public class DataHub {
	public static List<Employee> getEmployeeArrayDatas() {

		List<Employee> employeeDatas = Arrays.asList(new Employee(1, "sam", 1460.00, "hr"),
				new Employee(7, "raghu", 1143.00, "watchman"), new Employee(3, "baskar", 8246.00, "manager"),
				new Employee(4, "ziera", 9399.00, "hr"), new Employee(5, "karthi", 43567.00, "lead"),
				new Employee(6, "ashok", 5555.00, "developer"), new Employee(2, "udhay", 6427.00, "architech"),
				new Employee(9, "tek", 8098.00, "hr"), new Employee(8, "ben", 3000.00, "lead"));

		return employeeDatas;
	}

	public static List<Employee> getEmployeeDatas() {

		List<Employee> employeeDatas = new ArrayList<Employee>();

		employeeDatas.add(new Employee(1, "sam", 1460.00, "hr"));
		employeeDatas.add(new Employee(10, "raghu", 1143.00, "watchman"));
		employeeDatas.add(new Employee(3, "baskar", 8246.00, "manager"));
		employeeDatas.add(new Employee(4, "ziera", 9399.00, "hr"));
		employeeDatas.add(new Employee(5, "karthi", 43567.00, "lead"));
		employeeDatas.add(new Employee(6, "ashok", 5555.00, "developer"));
		employeeDatas.add(new Employee(2, "udhay", 6427.00, "architech"));
		employeeDatas.add(new Employee(7, "jack", 43567.00, "lead"));
		employeeDatas.add(new Employee(9, "tek", 8098.00, "hr"));
		employeeDatas.add(new Employee(8, "ben", 3000.00, "lead"));

		return employeeDatas;
	}

	public static List<String> getStringDatas() {

		List<String> stList = Arrays.asList("Camel", "cat", "aslan", "rani", "king", "zebra", "ballon", "parrot",
				"Allahdin", "owl", "Xray");

		return stList;
	}

	public static List<Integer> getIntDatas() {

		List<Integer> intList = Arrays.asList(5, 98, 64, 35, 44, 66, 11, 55, 22, 46);
		return intList;

	}
}
