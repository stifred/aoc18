package stifred.aoc18.twelfth;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwelfthTest {
  private static final Twelfth twelft = new Twelfth();

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
