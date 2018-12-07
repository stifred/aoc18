package stifred.aoc18.seventh.a;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstructionSetTest {
  @Test
  public void testGetTime() {
    InstructionSet set1 = new InstructionSet("A");
    assertEquals(61, set1.getTime(60));

    InstructionSet set2 = new InstructionSet("T");
    assertEquals(80, set2.getTime(60));
  }
}
