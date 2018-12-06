package stifred.aoc18.sixth;

import org.junit.Test;
import stifred.aoc18.December;

import static org.junit.Assert.assertEquals;

public class SixthTest {
  private final Sixth sixth = new Sixth();

  @Test
  public void testFirstChallenge() {
    String input = "1, 1\n1, 6\n8, 3\n3, 4\n5, 5\n8, 9";
    String expected = "17";

    assertEquals(expected, sixth.firstChallenge(input));
  }

  @Test
  public void testSecondChallenge() {
    String input = "1, 1\n1, 6\n8, 3\n3, 4\n5, 5\n8, 9";
    String expected = "16";

    sixth.goal = 32;
    assertEquals(expected, sixth.secondChallenge(input));
  }
}
