package stifred.aoc18.second.a;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoxIdTest {
  @Test
  public void testHasDuplicates() {
    BoxId boxId1 = new BoxId("abcdef");
    assertFalse(boxId1.hasDuplicates(2));
    assertFalse(boxId1.hasDuplicates(3));

    BoxId boxId2 = new BoxId("bababc");
    assertTrue(boxId2.hasDuplicates(2));
    assertTrue(boxId2.hasDuplicates(3));

    BoxId boxId3 = new BoxId("abbcde");
    assertTrue(boxId3.hasDuplicates(2));
    assertFalse(boxId3.hasDuplicates(3));

    BoxId boxId4 = new BoxId("abcccd");
    assertFalse(boxId4.hasDuplicates(2));
    assertTrue(boxId4.hasDuplicates(3));

    BoxId boxId5 = new BoxId("aabcdd");
    assertTrue(boxId5.hasDuplicates(2));
    assertFalse(boxId5.hasDuplicates(3));

    BoxId boxId6 = new BoxId("abcdee");
    assertTrue(boxId6.hasDuplicates(2));
    assertFalse(boxId6.hasDuplicates(3));

    BoxId boxId7 = new BoxId("ababab");
    assertFalse(boxId7.hasDuplicates(2));
    assertTrue(boxId7.hasDuplicates(3));
  }
}
