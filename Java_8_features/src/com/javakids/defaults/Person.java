package com.javakids.defaults;

public interface Person {

	void getPersonalDetails();

	default int getAge() {

		PersonDetails details = new PersonDetails("srini", 33, "Chennai", 1000);
		return details.age;
	}
	
	//int getAge();

}
