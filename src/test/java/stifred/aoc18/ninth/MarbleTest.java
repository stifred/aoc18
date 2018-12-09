package stifred.aoc18.ninth;

import org.junit.Test;

import static org.junit.Assert.*;

public class MarbleTest {
  @Test
  public void testAll() {
    Marble left = new Marble(25);
    Marble right = left.addRight(40);

    assertEquals(right, left.right(1));
    assertEquals(right.left(2), right);
    assertEquals(40, right.pop());
    assertEquals(left, left.left(1));
    assertEquals(left, left.left(100));
    assertEquals(left, left.right(1));
    assertEquals(left, left.right(100));
  }
}