package com.test.samples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Find the duplicate in the given int array with only one & many duplicate
 * values
 * 
 * @author srini
 *
 */
public class FindDuplicateNumber {

	public static void main(String[] args) {

		int[] data = { 4, 2, 8, 1, 7, 6, 9, 3, 8, 0 };
		int[] manyDupdata = { 4, 2, 8, 1, 7, 6, 9, 3, 9, 0, 7, 2, 9 };

		System.out.println("Input Data: " + Arrays.toString(data));
		System.out.println(
				"Duplicate Value: " + (Arrays.stream(data).sum() - Arrays.stream(data).distinct().sum()) + "\n\n");
		System.out.println("Input Data with multiple duplicates: " + Arrays.toString(manyDupdata) + "\n\n");

		Set<Integer> uniqueSet = new HashSet<>();
		Set<Integer> dupSet = IntStream.of(manyDupdata).boxed().filter(n -> !uniqueSet.add(n))
				.collect(Collectors.toSet());

		System.out.println("Unique set values: " + uniqueSet);
		System.out.println("Duplicate set values: " + dupSet);
		System.out.println("Duplicate count: " + (manyDupdata.length - uniqueSet.size()));
		System.out.println("Duplicate Map with count: " + IntStream.of(manyDupdata).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
		
		
		
//				OUTPUT:
//		
//				Input Data: [4, 2, 8, 1, 7, 6, 9, 3, 8, 0]
//				Duplicate Value: 8
//
//
//				Input Data with multiple duplicates: [4, 2, 8, 1, 7, 6, 9, 3, 9, 0, 7, 2, 9]
//
//
//				Unique set values: [0, 1, 2, 3, 4, 6, 7, 8, 9]
//				Duplicate set values: [2, 7, 9]
//				Duplicate count: 4
//				Duplicate Map with count: {0=1, 1=1, 2=2, 3=1, 4=1, 6=1, 7=2, 8=1, 9=3}

	}

}
