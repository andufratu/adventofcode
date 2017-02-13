package codes.andu.aoc.checker;

public class HasMultipliedLetters implements Checker {

	private final int count;

	public HasMultipliedLetters(int count) {
		this.count = count;
	}

	@Override
	public boolean matches(String str) {
		boolean matches = false;

		if (str.length() > 0) {
			char prevChar = str.charAt(0);
			int count = 1;
			for (int i = 1; i < str.length(); i++) {
				char currentChar = str.charAt(i);
				if (prevChar == currentChar) {
					count++;
				} else {
					prevChar = currentChar;
				}

				if (count == this.count) {
					matches = true;
					break;
				}
			}
		}

		return matches;
	}

	@Override
	public final String toString() {
		return "HasMultipliedLetters with count=" + count;
	}
}
