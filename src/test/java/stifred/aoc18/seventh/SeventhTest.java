package stifred.aoc18.seventh;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SeventhTest {
  private final Seventh seventh = new Seventh();
  private final String input =
      "Step C must be finished before step A can begin.\n"
          + "Step C must be finished before step F can begin.\n"
          + "Step A must be finished before step B can begin.\n"
          + "Step A must be finished before step D can begin.\n"
          + "Step B must be finished before step E can begin.\n"
          + "Step D must be finished before step E can begin.\n"
          + "Step F must be finished before step E can begin.";

  @Test
  public void testFirst() {
    String output = seventh.firstChallenge(input);

    assertEquals("CABDFE", output);
  }

  @Test
  public void testSecond() {
    seventh.offset = 0;
    seventh.workerCount = 2;
    String output = seventh.secondChallenge(input);

    assertEquals("15", output);
  }
}
