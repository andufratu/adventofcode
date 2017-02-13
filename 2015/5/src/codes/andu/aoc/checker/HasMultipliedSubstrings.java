package codes.andu.aoc.checker;

public class HasMultipliedSubstrings implements Checker {
	private final int length;
	private final int count;

	public HasMultipliedSubstrings(int length, int count) {
		this.length = length;
		this.count = count;
	}

	public boolean matches(String str) {
		boolean matches = false;

		search:
		for (int i = 0; i < str.length() - length; i++) {
			String currentPair = str.substring(i, i + length);
			int count = 1;

			for (int j = i + length; j < str.length() - length + 1; j++) {
				String pair = str.substring(j, j + length);
				if (currentPair.equals(pair)) {
					count++;
				}

				if (count == this.count) {
					matches = true;
					break search;
				}
			}
		}

		return matches;
	}
}
