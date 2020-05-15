package com.codeprep.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codeprep.io.City;
import com.codeprep.io.Person;

public class DemoMapMethods {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Person person1 = new Person("John", "Snow", 28);
		Person person2 = new Person("Sansa", "Stark", 29);
		Person person3 = new Person("Ned", "Stark", 50);
		Person person4 = new Person("Rob", "Stark", 30);
		City city1 = new City("Winterfell");
		
		List<Person> people1 = new ArrayList<>(Arrays.asList(person1, person2, person3, person4));
		
		Map<City, List<Person>> cityToPersonMap = new HashMap<>();
		cityToPersonMap.put(city1, people1);
		
		Person person5 = new Person("Sersi", "Lanister", 30);
		Person person6 = new Person("Tywin", "Lanister", 70);
		City city2 = new City("Kings Landing");
		
		List<Person> people2 = new ArrayList<>(Arrays.asList(person5, person6));
		cityToPersonMap.put(city2, people2);
		
		//default value
		List<Person> result = cityToPersonMap.getOrDefault(new City("Dragons Stone"), Collections.EMPTY_LIST);
		System.out.println(result);
		
		Person person7 = new Person("Tywin", "Lanister", 70);
		City city3 = new City("Dorne");
		
		List<Person> people3 = new ArrayList<>(Arrays.asList(person7));
		
		//putIfAbsent()
//		cityToPersonMap.putIfAbsent(city3, new ArrayList<>());
//		cityToPersonMap.get(city3).add(person7);
//		System.out.println(cityToPersonMap.get(city3));
		
		//computeIfAbsent()
		cityToPersonMap.computeIfAbsent(city3, city -> new ArrayList<>()).add(person7);
		
	}
}
