package com.codeprep.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.codeprep.model.Person;
import com.codeprep.spliterator.PersonSpliterator;

public class TestSpliterator {

	public static void main(String[] args) {

		Path filePath = Paths.get("./file/people.txt");
		
		try(Stream<String> lines = Files.lines(filePath)){
			
			Spliterator<String> lineSpliterator = lines.spliterator();
			Spliterator<Person> peopleSpliterator = new PersonSpliterator(lineSpliterator);
			
			Stream<Person> people = StreamSupport.stream(peopleSpliterator, false);
			people.forEach(p -> System.out.println(p));
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
