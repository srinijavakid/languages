package com.test.samples;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * Find the missing number in unsorted array with duplicate values
 * 
 * @author srini
 *
 */
public class MissingNumber {

	public static void main(String[] args) {

		int[] data = { 4, 2, 8, 1, 7, 6, 9, 3, 8, 4, 0 };

		// 1,2,3,4,6,7,8,9

		IntSummaryStatistics statistics = Arrays.stream(data).distinct().sorted().summaryStatistics();

		long max = statistics.getMax();
		long min = statistics.getMin();

		long missing = max * (max + 1) / 2 - min * (min - 1) / 2 - statistics.getSum();

		System.out.println(missing); // output : 5
	}

}
