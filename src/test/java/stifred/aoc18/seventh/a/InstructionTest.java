package stifred.aoc18.seventh.a;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstructionTest {
  @Test
  public void testFrom() {
    String str = "Step C must be finished before step A can begin.";

    Instruction instruction = Instruction.from(str);

    assertEquals("C", instruction.getRequired());
    assertEquals("A", instruction.getTheStep());
  }
}