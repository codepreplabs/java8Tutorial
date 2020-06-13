package com.codeprep.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

import com.codeprep.model.Person;

public class PersonSpliterator implements Spliterator<Person> {

	private Spliterator<String> lineSpliterator;
	private String name;
	private int age;
	private String city;

	public PersonSpliterator(Spliterator<String> lineSpliterator) {
		super();
		this.lineSpliterator = lineSpliterator;
	}

	public PersonSpliterator() {
	}

	public boolean tryAdvance(Consumer<? super Person> action) {

		if (this.lineSpliterator.tryAdvance(line -> this.name = line)
				&& this.lineSpliterator.tryAdvance(line -> this.age = Integer.parseInt(line))
				&& this.lineSpliterator.tryAdvance(line -> this.city = line)) {
			Person p = new Person(name, age, city);
			action.accept(p);
			return true;
		}else {
			return false;
		}
	}

	public Spliterator<Person> trySplit() {
		return null;
	}

	public long estimateSize() {
		return lineSpliterator.estimateSize() / 3;
	}

	public int characteristics() {
		return lineSpliterator.characteristics();
	}

}
