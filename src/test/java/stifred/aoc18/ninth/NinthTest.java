package stifred.aoc18.ninth;

import org.junit.Test;

import static org.junit.Assert.*;

public class NinthTest {
  private final Ninth ninth = new Ninth();

  @Test
  public void testFirst() {
    String input = "10 players; last marble is worth 1618 points:";
    assertEquals("8317", ninth.firstChallenge(input));
  }
}