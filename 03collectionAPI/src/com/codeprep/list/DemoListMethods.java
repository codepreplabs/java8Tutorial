package com.codeprep.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.codeprep.io.Person;

public class DemoListMethods {

	public static void main(String[] args) {
		
		Person person1 = new Person("John", "Snow", 28);
		Person person2 = new Person("Sansa", "Stark", 29);
		Person person3 = new Person("Ned", "Stark", 50);
		Person person4 = new Person("Rob", "Stark", 30);
		
		List<Person> people = new ArrayList<>(Arrays.asList(person1, person2, person3, person4));
		
		// using lambda expressions
		people.forEach(p -> System.out.println(p));
		
		System.out.println();
		//using method references
		people.forEach(System.out::println);
		
		System.out.println();
		// sorting a list
		people.sort(Comparator.comparing(Person::getAge));
		people.forEach(System.out::println);
		
		System.out.println();
		// sorting a list
		people.sort(Comparator.comparing(Person::getAge).reversed());
		people.forEach(System.out::println);
		
		System.out.println();
		people.removeIf(p -> p.getAge() > 30);
		people.forEach(System.out::println);
		
		System.out.println();
		people.replaceAll(p -> new Person(p.getFirstName().toUpperCase(), p.getLastName(), p.getAge()));
		people.forEach(System.out::println);
	}
}
