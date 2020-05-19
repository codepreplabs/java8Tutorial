package com.codeprep.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStreamPatterns {

	public static void main(String[] args) {
		
		List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4);
		
		System.out.println("creating streams from stream() method in collection interface");
		Stream<Integer> stream1 = ints.stream();
		stream1.forEach(a -> System.out.println(a));
		System.out.println();
		
		System.out.println("creating streams using of() static method from Stream interface");
		Stream<Integer> stream2 = Stream.of(0, 1, 2, 3, 4);
		stream2.forEach(a -> System.out.println(a));
		System.out.println();
		
		System.out.println("streams using generate method which takes a supplier as parameter");
		Stream<String> stream3 = Stream.generate(() -> "one");
		stream3.limit(5).forEach((a) -> System.out.println(a));
		System.out.println();
		
		System.out.println("streams using ThreadLocalRandom");
		IntStream streamOfint = ThreadLocalRandom.current().ints();
		streamOfint.limit(5).forEach((a) -> System.out.println(a));
	}
}
