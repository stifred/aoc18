package stifred.aoc18.second;

import org.junit.Test;
import stifred.aoc18.December;

import static org.junit.Assert.*;

public class SecondTest {
  private final December second = new Second();

  @Test
  public void testFirstChallenge() {
    String empty = "";
    assertEquals("0", second.firstChallenge(empty));

    String oneOfEach = "ababde\nabcccd";
    assertEquals("1", second.firstChallenge(oneOfEach));

    String twoOfEach = "aa\nbb\naaa\nbbb";
    assertEquals("4", second.firstChallenge(twoOfEach));
  }

  @Test
  public void testSecondChallenge() {
    String noMatch = "abcd\nabde";
    assertEquals("", second.secondChallenge(noMatch));

    String oneMatch = "bandana\nbanlana";
    assertEquals("banana", second.secondChallenge(oneMatch));

    String fromChallenge = "abcde\nfghij\nklmno\\npqrst\nfguij\naxcye\nwvxyz";
    assertEquals("fgij", second.secondChallenge(fromChallenge));
  }
}