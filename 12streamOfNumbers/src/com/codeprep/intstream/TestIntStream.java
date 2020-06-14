package com.codeprep.intstream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class TestIntStream {

	public static void main(String[] args) {

		try {
			Set<String> shakesphearsWords = Files.lines(Paths.get("./files/words.shakespeare.txt"))
					.map(word -> word.toLowerCase()).collect(Collectors.toSet());
			Set<String> validScrabbleWords = Files.lines(Paths.get("./files/ospd.txt")).map(word -> word.toLowerCase())
					.collect(Collectors.toSet());

			System.out.println(shakesphearsWords.size());
			System.out.println(validScrabbleWords.size());

			final int[] scrabbleENScore = {
					// a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z
					1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };

			Function<String, Integer> score = word -> word.chars().map(letter -> scrabbleENScore[letter - 'a']).sum();

			ToIntFunction<String> intScore = word -> word.chars().map(letter -> scrabbleENScore[letter - 'a']).sum();

			System.out.println("score for hello : " + intScore.applyAsInt("hello"));
			
			String bestWord = shakesphearsWords.stream()
					.filter(word -> validScrabbleWords.contains(word))
					.max(Comparator.comparing(score))
					.get();
			
			System.out.println(bestWord);
			
			IntSummaryStatistics statistics = shakesphearsWords.stream()
			.filter(validScrabbleWords :: contains)
			.mapToInt(intScore)
			.summaryStatistics();
			
			System.out.println(statistics);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
