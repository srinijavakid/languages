package com.test.samples;

public class SwapTwoNumbers {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		System.out.println("Before swap a= " + a + " b= " + b);

		// type 1 using temp obj
//		int temp = 0;
//		temp = a;
//		a = b;
//		b = temp;

		// type 2 without temp obj
		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println("Before swap a= " + a + " b= " + b);
	}

}
