package stifred.aoc18.eleventh;

import org.junit.Test;

import static org.junit.Assert.*;

public class EleventhTest {
  private final Eleventh eleventh = new Eleventh();

  @Test
  public void testFirst() {
    String input = "42";
    String expectedOutput = "21,61";

    assertEquals(expectedOutput, eleventh.firstChallenge(input));
  }

  @Test
  public void testSecond() {
    String input = "18";
    String expectedOutput = "90,269,16";

    assertEquals(expectedOutput, eleventh.secondChallenge(input));
  }
}