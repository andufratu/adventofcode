package codes.andu.aoc;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import codes.andu.aoc.checker.Checker;
import codes.andu.aoc.checker.ContainsVowels;
import codes.andu.aoc.checker.DoesNotContainSubstrings;
import codes.andu.aoc.checker.HasARepeteadLetterWithAnotherLetterInBetween;
import codes.andu.aoc.checker.HasMultipliedLetters;
import codes.andu.aoc.checker.HasMultipliedPairs;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	private final String[] AOC_EXAMPLE_SUBSTRINGS = {"ab", "cd", "pq", "xy"};

	private final List<Checker> AOC_FIRST_EXAMPLE_CHECKERS = new LinkedList<Checker>() {{
			add(new ContainsVowels(3));
			add(new HasMultipliedLetters(2));
			add(new DoesNotContainSubstrings(AOC_EXAMPLE_SUBSTRINGS));
		}};

	private final List<Checker> AOC_SECOND_EXAMPLE_CHECKERS = new LinkedList<Checker>() {{
			add(new HasMultipliedPairs(2, 2));
			add(new HasARepeteadLetterWithAnotherLetterInBetween());
		}};

	private final List<String> AOC_EXAMPLE_STRINGS = new LinkedList<String>() {{
			add("ugknbfddgicrmopn");
			add("aaa");
			add("jchzalrnumimnmhp");
			add("haegwjzuvuyypxyu");
			add("dvszwmarrgswjxmb");
		}};

	@Test
	public void testAoCExample() {
		Main main = new Main(AOC_FIRST_EXAMPLE_CHECKERS, AOC_EXAMPLE_STRINGS);

		Assert.assertEquals("Expected the number of nice strings to be 2", 2, main.countNiceStrings());
	}

	@Test
	public void testFirstAoCPuzzle() {
		List<String> strings = new LinkedList<String>();
		try {
			FileInputStream fs = new FileInputStream("aoc.txt");
			DataInputStream in = new DataInputStream(fs);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str;
			while ((str = br.readLine()) != null) {
				strings.add(str);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File aoc.txt not found");
		} catch (IOException ex) {
			System.out.println("IO Exception: " + ex.getMessage());
		}
		int count = new Main(AOC_FIRST_EXAMPLE_CHECKERS, strings).countNiceStrings();

		Assert.assertEquals("Expected the nice strings in the puzzle input to be 258, instead it was " + count,
							258, count);
	}

	@Test
	public void testSecondAoCPuzzle() {
		List<String> strings = new LinkedList<String>();
		try {
			FileInputStream fs = new FileInputStream("aoc.txt");
			DataInputStream in = new DataInputStream(fs);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str;
			while ((str = br.readLine()) != null) {
				strings.add(str);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File aoc.txt not found");
		} catch (IOException ex) {
			System.out.println("IO Exception: " + ex.getMessage());
		}
		int count = new Main(AOC_SECOND_EXAMPLE_CHECKERS, strings).countNiceStrings();

		Assert.assertEquals("Expected the nice strings in the puzzle input to be 53, instead it was " + count,
							53, count);
	}
}
