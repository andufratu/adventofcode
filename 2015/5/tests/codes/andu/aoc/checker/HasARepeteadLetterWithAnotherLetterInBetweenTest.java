package codes.andu.aoc.checker;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class HasARepeteadLetterWithAnotherLetterInBetweenTest {
	private HasARepeteadLetterWithAnotherLetterInBetween sut;

	@Before
	public void setUp() {
		sut = new HasARepeteadLetterWithAnotherLetterInBetween();
	}

	@Test
	@Parameters({"xyx", "abcdefeghi", "aaa"})
	public void testAoCExamples(String str) {
		final boolean result = sut.matches(str);

		Assert.assertTrue(result);
	}
}
