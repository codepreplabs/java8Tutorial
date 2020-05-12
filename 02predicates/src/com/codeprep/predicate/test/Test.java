package com.codeprep.predicate.test;

import com.codeprep.predicate.Predicate;

public class Test {

	public static void main(String[] args) {
		
		Predicate<String> p1 = s -> s.length() < 20;
		System.out.println("no. of characters is less than 20 " + p1.test("Hello World!"));
		
		// chaining methods to add a and condtion
		Predicate<String> p2 = s -> s.length() > 5;
		Predicate<String> p3 = p1.and(p2);
		
		System.out.println("P3 for Hello " + p3.test("Hello"));
		System.out.println("P3 for Hello World " + p3.test("Hello World"));
		System.out.println("P3 for I am learning Java 8 " + p3.test("I am learning Java 8"));
		
		// chaining methods to add a or condition
		Predicate<String> p4 = p1.or(p2);
		
		System.out.println("P4 for Hello " + p4.test("Hello"));
		System.out.println("P4 for Hello World " + p4.test("Hello World"));
		System.out.println("P4 for I am learning Java 8 " + p4.test("I am learning Java 8"));
		
		//implementing a static method to check equality
		
		Predicate<String> p5 = Predicate.isEqualTo("Hello");
		
		System.out.println("P5 for Hello " + p5.test("Hello"));
		System.out.println("P5 for Hello World " + p5.test("Hello World"));
	}
}
