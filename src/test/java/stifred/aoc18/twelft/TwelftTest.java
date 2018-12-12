package stifred.aoc18.twelft;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwelftTest {
  private static final Twelft twelft = new Twelft();

  @Test
  public void testFirst() {
    String input =
        "initial state: #..#.#..##......###...###\n"
            + "\n"
            + "...## => #\n"
            + "..#.. => #\n"
            + ".#... => #\n"
            + ".#.#. => #\n"
            + ".#.## => #\n"
            + ".##.. => #\n"
            + ".#### => #\n"
            + "#.#.# => #\n"
            + "#.### => #\n"
            + "##.#. => #\n"
            + "##.## => #\n"
            + "###.. => #\n"
            + "###.# => #\n"
            + "####. => #";

    assertEquals("325", twelft.firstChallenge(input));
  }
}
