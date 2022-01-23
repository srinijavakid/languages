package com.test.samples;

import java.util.Map;
import java.util.stream.Collectors;

public class GroupCharsInString {

	public static void main(String[] args) {
		String test = "HelloWorldWelcomeToJava";

		Map<String, Long> collect = test.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
		System.out.println(collect);
	}

}
