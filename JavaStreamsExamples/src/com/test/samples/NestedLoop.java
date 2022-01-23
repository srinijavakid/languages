package com.test.samples;

import java.util.stream.IntStream;

public class NestedLoop {

	public static void main(String[] args) {
		IntStream.range(1, 6).forEach(i -> {
			IntStream.range(1, i).forEach(j -> System.out.println("*-->" + j));
			System.out.println("\n");
		});

//		IntStream.range(1, 6).forEach(i -> {
//			Set<String> collect = IntStream.range(1, i).mapToObj(j -> "*-->").collect(Collectors.toSet());
//			System.out.println(collect.toString());
//			System.out.println("\n");
//		});

	}
}
