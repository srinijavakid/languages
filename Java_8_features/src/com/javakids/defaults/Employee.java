package com.javakids.defaults;

public interface Employee {

	void getWorkDone();

	default int getAge() {

		EmployeeDetails details = new EmployeeDetails("vas", 16, "Chennai");
		return details.age;
	}

	static EmployeeDetails getdata() {

		EmployeeDetails details = new EmployeeDetails("vas", 16, "Chennai");
		return details;
	}

}
