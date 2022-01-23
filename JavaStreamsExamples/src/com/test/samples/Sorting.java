package com.test.samples;

import java.util.Comparator;
import java.util.List;

import com.test.data.DataHub;
import com.test.models.Employee;

public class Sorting {

	public static void main(String[] args) {
		
		
		List<Employee> data = DataHub.getEmployeeDatas();
		System.out.println(data);
		data.sort(Comparator.comparing(Employee::getSalary).reversed());
		System.out.println("\n\n\t" + data);
		
		
		
		List<String> stringData = DataHub.getStringDatas();
		System.out.println(stringData);
		stringData.sort(Comparator.naturalOrder());
		System.out.println(stringData);
		stringData.sort(Comparator.reverseOrder());
		System.out.println(stringData);
	}
}
