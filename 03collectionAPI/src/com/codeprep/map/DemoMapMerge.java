package com.codeprep.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codeprep.io.City;
import com.codeprep.io.Person;

public class DemoMapMerge {

	public static void main(String[] args) {
		
		Person person1 = new Person("Rob", "Stark", 30);
		List<Person> people1 = new ArrayList<>(Arrays.asList(person1));
		City city1 = new City("Winterfell");
		
		Map<City, List<Person>> map1 = new HashMap<>();
		map1.put(city1, people1);
		
		Person person2 = new Person("John", "Snow", 28);
		List<Person> people2 = new ArrayList<>(Arrays.asList(person2));
		
		Map<City, List<Person>> map2 = new HashMap<>();
		map2.put(city1, people2);
		
		System.out.println("map1: "+ map1);
		System.out.println("map2: "+ map2);
		System.out.println();
		
		//code to merge two maps
		
		map2.forEach((key, value) -> {
			map1.merge(key, value, (valueFromMap1, valueFromMap2) -> {
				valueFromMap1.addAll(valueFromMap2);
				return valueFromMap1;
			});
		});
		
		System.out.println("after merge: "+ map1);
	}

}
