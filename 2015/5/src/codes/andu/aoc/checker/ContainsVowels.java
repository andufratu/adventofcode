package codes.andu.aoc.checker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContainsVowels implements Checker {

	private final String VOWELS = "aeiouAEIOU";
	private final int count;

	public ContainsVowels(int count) {
		this.count = count;
	}

	@Override
	public final boolean matches(String str) {
		final Matcher matcher = Pattern.compile("[" + VOWELS + "]").matcher(str);
		boolean matches = false;

		int i = 0;
		while (matcher.find()) {
			if (++i >= count) {
				matches = true;
				break;
			}
		}

		return matches;
	}

	@Override
	public final String toString() {
		return "ContainsVowels with count=" + count;
	}
}
