package codes.andu.aoc.checker;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ContainsVowelsTest {

	private static final int ANY_COUNT = 2;
	private static final int AOC_COUNT = 3;

	private static final String ANY_MATCHING_STRING = "sjairoecjdfdiuasdk";
	private static final String ANY_NON_MATCHING_STRING = "klqrdsddftre";

	@Test
	public void testItReturnsTrueForMatchingString() {
		final ContainsVowels sut = new ContainsVowels(ANY_COUNT);
		final boolean result = sut.matches(ANY_MATCHING_STRING);

		Assert.assertTrue("Expected to return true for '" + ANY_MATCHING_STRING + "', instead returned " + result,
						  result);
	}

	@Test
	public void testItReturnsFalseForMatchingStringLessVowelsThanRequired() {
		final ContainsVowels sut = new ContainsVowels(ANY_COUNT);
		final boolean result = sut.matches(ANY_NON_MATCHING_STRING);

		Assert.assertFalse("Expected to return false for '" + ANY_NON_MATCHING_STRING +
				   "', instead returned " + result, result);
	}

	@Test
	@Parameters({"aei", "xazegov", "aeiouaeiouaeiou"})
	public void testItMatchesAoCExamples(String str) {
		final ContainsVowels sut = new ContainsVowels(AOC_COUNT);
		final boolean result = sut.matches(str);

		Assert.assertTrue("Expected to return true for '" + str + "', instead returned " + result, result);
	}
}
