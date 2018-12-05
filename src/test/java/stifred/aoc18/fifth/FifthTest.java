package stifred.aoc18.fifth;

import org.junit.Test;
import stifred.aoc18.December;
import stifred.aoc18.fourth.Fourth;

import static org.junit.Assert.*;

public class FifthTest {
  private final December fifth = new Fifth();

  @Test
  public void testFirst() {
    String input = "dabAcCaCBAcCcaDA";
    String exp = Integer.toString("dabCBAcaDA".length());

    assertEquals(exp, fifth.firstChallenge(input));
  }

  @Test
  public void testSecond() {
    String input = "dabAcCaCBAcCcaDA";
    String exp = Integer.toString(4);

    assertEquals(exp, fifth.secondChallenge(input));
  }
}