package stifred.aoc18.third;

import org.junit.Test;
import stifred.aoc18.December;

import static org.junit.Assert.assertEquals;

public class ThirdTest {
  private final December third = new Third();

  @Test
  public void testFirstChallenge() {
    String input = "#1 @ 1,3: 4x4\n#2 @ 3,1: 4x4\n#3 @ 5,5: 2x2";
    assertEquals("4", third.firstChallenge(input));
  }
}
