package stifred.aoc18.eleventh;

import stifred.aoc18.December;

public class Eleventh implements December {
  private Matrix matrix;

  @Override
  public String firstChallenge(String input) {
    int serial = Integer.parseInt(input);

    return getOrMakeMatrix(serial).largestSum(3).render(false);
  }

  @Override
  public String secondChallenge(String input) {
    int serial = Integer.parseInt(input);

    return getOrMakeMatrix(serial).largestSumOfAll().render(true);
  }

  private Matrix getOrMakeMatrix(int serial) {
    return new Matrix(serial, 300);
  }
}
