package codes.andu.aoc;

import java.util.LinkedList;
import java.util.List;

import codes.andu.aoc.checker.Checker;
import codes.andu.aoc.checker.ContainsVowels;
import codes.andu.aoc.checker.DoesNotContainSubstrings;
import codes.andu.aoc.checker.HasMultipliedLetters;

public class Main {

	private List<Checker> checkers;
	private List<String> strings;

	public Main(List<Checker> checkers, List<String> strings) {
		this.checkers = checkers;
		this.strings = strings;
	}

	public int countNiceStrings() {
		int nice = 0;

		for (String str : strings) {
			if (stringIsNice(str)) {
				nice++;
			}
		}

		return nice;
	}

	private boolean stringIsNice(String str) {
		boolean isNice = true;
		for (Checker checker : checkers) {
			if (!checker.matches(str)) {
				isNice = false;
				break;
			}
		}

		return isNice;
	}
}
