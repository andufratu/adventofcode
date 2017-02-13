package codes.andu.aoc.checker;

import junitparams.JUnitParamsRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;

public class DoesNotContainSubstringsTest {

	private final String ANY_MATCHING_STRING = "dadaffkdyx";
	private final String ANY_NON_MATCHING_STRING = "adassfkdsfjdsfkdxy";
	private final String[] AOC_SUBSTRINGS = {"ab", "cd", "pq", "xy"};

	private DoesNotContainSubstrings sut;

	@Before
	public void setUp() {
		sut = new DoesNotContainSubstrings(AOC_SUBSTRINGS);
	}

	@Test
	public void testEmptyStringMatches() {
		final boolean result = sut.matches("");

		Assert.assertTrue("Expected to return true for empty string, instead returned " + result, result);
	}

	@Test
	public void testReturnsFalseForStringContainingAnyOfTheSubstrings() {
		final boolean result = sut.matches(ANY_NON_MATCHING_STRING);

		Assert.assertFalse("Expected to return false for " + ANY_NON_MATCHING_STRING + ", instead returned " + result,
						   result);
	}

	@Test
	public void testReturnsTrueForStringContainingNoneOfTheSubstrings() {
		final boolean result = sut.matches(ANY_MATCHING_STRING);

		Assert.assertTrue("Expected to return false for " + ANY_MATCHING_STRING + ", instead returned " + result,
						   result);
	}
}
