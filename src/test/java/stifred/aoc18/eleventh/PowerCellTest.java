package stifred.aoc18.eleventh;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerCellTest {
  @Test
  public void testAll() {
    PowerCell powerCell = new PowerCell(3, 5, 8);

    assertEquals(13, powerCell.rackId());
    assertEquals(65, powerCell.powerLeverStart());
    assertEquals(73, powerCell.powerWithSerial());
    assertEquals(949, powerCell.multipliedWithRackIdAgain());
    assertEquals(9, powerCell.onlyTheHundreds());
    assertEquals(4, powerCell.totalPower());
  }
}