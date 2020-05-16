package com.javakids.defaults;

/**
 * This is an wrapper class to test the scenario
 * 
 * @author srini
 *
 */
public class Controller {

	public static void main(String[] args) {

		DataAccess data = new DataAccess();

		System.out.println(data.getAge());

		System.out.println(data.getDetails());
	}

}
