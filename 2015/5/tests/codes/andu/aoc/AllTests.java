package codes.andu.aoc;

import codes.andu.aoc.checker.ContainsVowelsTest;
import codes.andu.aoc.checker.DoesNotContainSubstringsTest;
import codes.andu.aoc.checker.HasARepeteadLetterWithAnotherLetterInBetweenTest;
import codes.andu.aoc.checker.HasMultipliedLettersTest;
import codes.andu.aoc.checker.HasMultipliedSubstringsTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ContainsVowelsTest.class, DoesNotContainSubstringsTest.class, HasARepeteadLetterWithAnotherLetterInBetweenTest.class, HasMultipliedLettersTest.class, HasMultipliedSubstringsTest.class, MainTest.class})
public class AllTests {}
