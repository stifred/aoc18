package stifred.aoc18.ninth;

import org.junit.Test;

import static org.junit.Assert.*;

public class MarbleGameTest {
  @Test
  public void testGames() {
    MarbleGame game0 = new MarbleGame(9, 25);
    assertEquals(32, game0.play());

    MarbleGame game1 = new MarbleGame(10, 1618);
    assertEquals(8317, game1.play());

    MarbleGame game2 = new MarbleGame(13, 7999);
    assertEquals(146373, game2.play());

    MarbleGame game3 = new MarbleGame(17, 1104);
    assertEquals(2764, game3.play());

    MarbleGame game4 = new MarbleGame(21, 6111);
    assertEquals(54718, game4.play());

    MarbleGame game5 = new MarbleGame(30, 5807);
    assertEquals(37305, game5.play());
  }
}