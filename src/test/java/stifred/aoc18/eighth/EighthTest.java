package stifred.aoc18.eighth;

import org.junit.Test;

import static org.junit.Assert.*;

public class EighthTest {
  private final Eighth eighth = new Eighth();

  @Test
  public void testFirst() {
    String input = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2";
    String expectedOutput = "138";

    assertEquals(expectedOutput, eighth.firstChallenge(input));
  }

  @Test
  public void testSecond() {
    String input = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2";
    String expectedOutput = "66";

    assertEquals(expectedOutput, eighth.secondChallenge(input));
  }
}