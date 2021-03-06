package stifred.aoc18.thirteenth;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThirteenthTest {
  private final Thirteenth thirteenth = new Thirteenth();

  @Test
  public void testFirst() {
    String input =
        "/->-\\        \n"
            + "|   |  /----\\\n"
            + "| /-+--+-\\  |\n"
            + "| | |  | v  |\n"
            + "\\-+-/  \\-+--/\n"
            + "  \\------/ ";
    String output = "7,3";

    assertEquals(output, thirteenth.firstChallenge(input));
  }

  @Test
  public void testSecond() {
    String input =
        "/>-<\\  \n"
            + "|   |  \n"
            + "| /<+-\\\n"
            + "| | | v\n"
            + "\\>+</ |\n"
            + "  |   ^\n"
            + "  \\<->/";

    String output = "6,4";
    assertEquals(output, thirteenth.secondChallenge(input));
  }
}
