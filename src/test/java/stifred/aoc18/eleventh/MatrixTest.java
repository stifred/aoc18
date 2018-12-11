package stifred.aoc18.eleventh;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
  @Test
  public void testLargestSum() {
    Matrix matrix = new Matrix(18, 300);
    Sum actualSum = matrix.largestSum(3);
    String expectedStr = "33,45";

    assertEquals(expectedStr, actualSum.render(false));
  }

  @Test
  public void testLargestSumOfAll() {
    Matrix matrix = new Matrix(42, 300);
    Sum actualSum = matrix.largestSumOfAll();
    String expectedStr = "232,251,12";

    assertEquals(expectedStr, actualSum.render(true));
  }
}