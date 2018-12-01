package stifred.aoc18.first;

import org.junit.Test;
import stifred.aoc18.December;

import static org.junit.Assert.*;

public class FirstTest {
  private final December first = new First();

  @Test
  public void testFirstChallenge() {
    String input1 = "";
    String input2 = "+5";
    String input3 = "+5\n-3\n+0\n+1\n";

    String output1 = first.firstChallenge(input1);
    String output2 = first.firstChallenge(input2);
    String output3 = first.firstChallenge(input3);

    assertEquals("0", output1);
    assertEquals("5", output2);
    assertEquals("3", output3);
  }
}