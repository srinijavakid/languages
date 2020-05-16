package com.test.question.one.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for App
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void testAppForZero() {
		String printStarString = App.printStarString(0);
		if (printStarString.length() == 1) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	public void testAppForOne() {
		String printStarString = App.printStarString(1);
		if (printStarString.length() == 2) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	public void testAppForTwo() {
		String printStarString = App.printStarString(2);
		if (printStarString.length() == 4) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	public void testAppForThree() {
		String printStarString = App.printStarString(3);
		if (printStarString.length() == 8) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	public void testAppForFour() {
		String printStarString = App.printStarString(4);
		if (printStarString.length() == 16) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

	public void testAppForSeven() {
		String printStarString = App.printStarString(7);
		if (printStarString.length() == 128) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

}
