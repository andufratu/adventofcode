package codes.andu.aoc.checker;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class HasMultipliedSubstringsTest {
	private final int AOC_PAIR_COUNT = 2;
	private final int AOC_PAIR_LENGTH = 2;

	private HasMultipliedSubstrings sut;

	@Before
	public void setUp() {
		sut = new HasMultipliedSubstrings(AOC_PAIR_LENGTH, AOC_PAIR_COUNT);
	}

	@Test
	@Parameters({"uurcxstgmygtbstg", "qjhvhtzxzqqjkmpb", "xxyxx"})
	public void testItReturnsTrueForMatchingString(String str) {
		final boolean result = sut.matches(str);

		Assert.assertTrue("Expected to return true for " + str + ", instead it returned " + result, result);
	}

	@Test
	@Parameters({"ieodomkazucvgmuy"})
	public void testItReturnsFalseForNonMatchingString(String str) {
		final boolean result = sut.matches(str);

		Assert.assertFalse("Expected to return false for " + str + ", instead it returned " + result, result);
	}

	@Test
	@Parameters({"xyxy", "aabcdefgaa"})
	public void testAoCExamples(String str) {
		final boolean result = sut.matches(str);

		Assert.assertTrue("Expected to return true for " + str + ", instead it returned " + result, result);
	}
}
