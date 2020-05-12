package com.codeprep.api;

import com.codeprep.function.Comparator;
import com.codeprep.io.Person;

public class Test {

	public static void main(String[] args) {

		Comparator<Person> cmp = Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName)
				.thenComparing(Person::getAge);

	}
}
