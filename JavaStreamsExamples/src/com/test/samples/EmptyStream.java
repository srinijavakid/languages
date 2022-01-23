package com.test.samples;

import java.util.stream.Stream;

import com.test.models.Employee;

public class EmptyStream {
	public static void main(String[] args) {
		Stream<Stream<Employee>> test = Stream.empty();
		if(test.findAny()!=null) {
			System.out.println("hello");;
		}
			
	}

}

