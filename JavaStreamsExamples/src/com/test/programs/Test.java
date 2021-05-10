package com.test.programs;

import java.util.stream.Stream;

import com.test.models.Employee;

public class Test {
	public static void main(String[] args) {
		Stream<Stream<Employee>> test = Stream.empty();
		if(test.findAny()!=null) {
			System.out.println("hello");;
		}
			
	}

}

