package codes.andu.aoc.checker;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class HasMultipliedLettersTest {

	private final int ANY_COUNT = 3;
	private final int AOC_COUNT = 2;

	private final String ANY_NON_MATCHING_STRING = "aagtrfj4#x2sfs";

	private HasMultipliedLetters sut;

	@Before
	public void setUp() {
		sut = new HasMultipliedLetters(ANY_COUNT);
	}

	@Test
	public void testItReturnsFalseForEmptyString() {
		final boolean result = sut.matches("");

		Assert.assertFalse("Expected to return false for empty string, instead returned " + result, result);
	}

	@Test
	public void testItReturnsFalseForNonMatchingString() {
		final boolean result = sut.matches(ANY_NON_MATCHING_STRING);

		Assert.assertFalse("Expected to return false for " + ANY_NON_MATCHING_STRING + " and " +
						   ANY_COUNT + " count, instead returned " + result, result);
	}

	@Test
	@Parameters({"xx", "abcdde", "aabbccdd"})
	public void testAocExamples(String str) {
		sut = new HasMultipliedLetters(AOC_COUNT);
		final boolean result = sut.matches(str);

		Assert.assertTrue("Expected to return true for " + str + ", instead retured " + result, result);
	}
}
