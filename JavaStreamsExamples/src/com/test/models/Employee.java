package com.test.models;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Employee {

	public int id;
	public String name;
	public double salary;
	public String designation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public static Predicate<Employee> getIdmorethanFive() {

		return p -> p.getId() > 5;
	}
	
	public static Predicate<Employee> getIdmorethanThousand() {

		return p -> p.getId() > 1000;
	}

	public static Predicate<Employee> getIdlessthanFive() {

		return p -> p.getId() < 5;
	}

	public static Predicate<Employee> getNameAshok() {

		return p -> p.name.equals("ashok");
	}
	
	public static Predicate<Employee> getSalaryAboveHundred() {

		return p -> p.getSalary() > 100;
	}

	public static Predicate<Employee> getIdmorethanFiveandSalryAboveThousand() {

		return p -> p.getId() > 5 && p.getSalary() > 1000;
	}

	public static Predicate<Employee> getIdlessthanFiveAndNameSam() {

		return p -> p.getId() < 5 && p.getName().equals("sam");
	}

	public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
		return employees.stream().filter(predicate).collect(Collectors.<Employee>toList());
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", designation=" + designation + "]";
	}

	public Employee(int id, String name, double salary, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public int compareTo(Employee argEmployee) {
		return name.compareTo(argEmployee.getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}
}