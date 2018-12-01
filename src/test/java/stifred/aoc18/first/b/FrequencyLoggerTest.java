package stifred.aoc18.first.b;

import org.junit.Test;
import stifred.aoc18.first.a.Frequency;

import static org.junit.Assert.*;

public class FrequencyLoggerTest {
  @Test
  public void testLogFrequency() {
    FrequencyLogger logger = new FrequencyLogger();

    // No duplicate in the beginning
    assertFalse(logger.hasDuplicate());

    logger.logFrequency(new Frequency(4));
    logger.logFrequency(new Frequency(6));
    logger.logFrequency(new Frequency(-3));

    // Still no duplicate
    assertFalse(logger.hasDuplicate());

    logger.logFrequency(new Frequency(11));
    logger.logFrequency(new Frequency(4));
    logger.logFrequency(new Frequency(6));

    // Now it should have a duplicate
    assertTrue(logger.hasDuplicate());

    // And the duplicate should be the *first* one
    assertEquals(4, logger.firstDuplicate().value());
  }
}