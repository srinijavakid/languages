package com.test.samples;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class Palindrome {

	public static void main(String[] args) {
		String pal = "abcxssxcba";
		AtomicBoolean val = new AtomicBoolean(true);
		IntStream.range(0, Math.round(pal.length()/2)).takeWhile(i -> val.get()).forEach(i -> {
			if (pal.charAt(i) != pal.charAt(pal.length() - (i + 1))) {
				val.set(false);
			}
		});
		System.out.println(val.get() ? "It is palindrome" : "It is not a palindrome");
	}
}
