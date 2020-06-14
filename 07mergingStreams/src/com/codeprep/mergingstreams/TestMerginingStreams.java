package com.codeprep.mergingstreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TestMerginingStreams {
	
	public static void main(String[] args) {
		
		try(Stream<String> lines1 = Files.lines(Paths.get("./files/TomSawyer_01.txt"));
				Stream<String> lines2 = Files.lines(Paths.get("./files/TomSawyer_02.txt"));
				Stream<String> lines3 = Files.lines(Paths.get("./files/TomSawyer_03.txt"));
				Stream<String> lines4 = Files.lines(Paths.get("./files/TomSawyer_04.txt"));){
			
			//merging streams using Stream.of()
			Stream<Stream<String>> streamOfStreams = Stream.of(lines1, lines2, lines3, lines4);
			
			//faltenning in to a single stream using flatmap() method
			Stream<String> streamOfLines = streamOfStreams.flatMap(Function.identity());
			
//			System.out.println(streamOfLines.count());
			
			//extracting a stream of words from lines
			Function<String, Stream<String>> linesSplitter = line -> Pattern.compile(" ").splitAsStream(line);
			Stream<String> streamOfWords = streamOfLines.flatMap(linesSplitter)
					.map(word -> word.toLowerCase())
					.distinct();
			
			System.out.println(streamOfWords.count());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
