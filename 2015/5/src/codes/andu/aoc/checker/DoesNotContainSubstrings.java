package codes.andu.aoc.checker;

public class DoesNotContainSubstrings implements Checker {

	private final String[] substrings;

	public DoesNotContainSubstrings(String[] substrings) {
		this.substrings = substrings;
	}

	public boolean matches(String str) {
		boolean matches = true;

		for (String substr : substrings) {
			if (str.indexOf(substr) != -1) {
				matches = false;
			}
		}

		return matches;
	}
}
