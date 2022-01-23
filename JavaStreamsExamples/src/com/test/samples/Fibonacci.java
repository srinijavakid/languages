package com.test.samples;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Fibonacci {

	public static void main(String[] args) {
		AtomicInteger a = new AtomicInteger(0);
		AtomicInteger b = new AtomicInteger(0);
		AtomicInteger c = new AtomicInteger(1);

		IntStream.range(0, 10).forEach(i -> {
			a.set(b.get());
			b.set(c.get());
			c.set(a.get() + b.get());
			System.out.println(a);
		});
	}

}
