package stifred.aoc18.fourteenth;

import org.junit.Test;

import static org.junit.Assert.*;

public class FourteenthTest {
  private final Fourteenth fourteenth = new Fourteenth();

  @Test
  public void testFirst() {
    String after5 = "0124515891";
    String after9 = "5158916779";
    String after18 = "9251071085";
    String after2018 = "5941429882";
    assertEquals(after5, fourteenth.firstChallenge("5"));
    assertEquals(after9, fourteenth.firstChallenge("9"));
    assertEquals(after18, fourteenth.firstChallenge("18"));
    assertEquals(after2018, fourteenth.firstChallenge("2018"));
  }

  @Test
  public void testSecond() {
    String after5 = "5";
    String after9 = "9";
    String after18 = "18";
    String after2018 = "2018";
    assertEquals(after5, fourteenth.secondChallenge("01245"));
    assertEquals(after9, fourteenth.secondChallenge("51589"));
    assertEquals(after18, fourteenth.secondChallenge("92510"));
    assertEquals(after2018, fourteenth.secondChallenge("59414"));
  }
}