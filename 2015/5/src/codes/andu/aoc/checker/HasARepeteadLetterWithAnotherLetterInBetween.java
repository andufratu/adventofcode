package codes.andu.aoc.checker;

public class HasARepeteadLetterWithAnotherLetterInBetween implements Checker {
	public boolean matches(String str) {
		boolean matches = false;

		char current = str.charAt(0);
		for (int i = 1; i < str.length() - 1; i++) {
			char next = str.charAt(i + 1);
			if (current == next) {
				matches = true;
				break;
			} else {
				current = str.charAt(i);
			}
		}

		return matches;
	}
}
