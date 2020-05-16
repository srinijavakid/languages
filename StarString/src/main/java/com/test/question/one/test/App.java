package com.test.question.one.test;

import java.util.Scanner;
import java.util.stream.LongStream;

/**
 * This class is the solution to print the '*' character to the count of 2 power
 * input number
 * 
 * @author Srinivas
 *
 */
@SuppressWarnings("resource")
public class App {
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int input = reader.nextInt();

		printStarString(input);
	}

	/**
	 * Method to print the starts for the value of 2 power given number
	 * 
	 * @param inputValue
	 * @return
	 */
	public static String printStarString(int inputValue) {

		StringBuilder output = new StringBuilder();

		long powerValue = power(inputValue);

		LongStream.range(0, powerValue).forEach(i -> {
			output.append("*");
		});

		System.out.println(output.toString());

		return output.toString();
	}

	/**
	 * To find 2 power of given exponent number
	 * 
	 * @param exponent
	 * @return
	 */
	public static int power(int exponent)

	{
		if (exponent == 0)
			return 1;
		// base case;
		int temp = power(exponent / 2);
		if (exponent % 2 == 0)
			return temp * temp;
		else
			return (2 * temp * temp);
	}
}
