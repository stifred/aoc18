package stifred.aoc18.third.a;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClaimTest {
  @Test
  public void testFrom() {
    Claim testClaim = Claim.from("#250 @ 32,11: 20x30");

    assertEquals(250, testClaim.getId());
    assertEquals(600, testClaim.getPositions().size());
  }
}
