package stifred.aoc18.eleventh;

class Matrix {
  private final int side;
  private final int[] sums;

  Matrix(int serial, int side) {
    this.side = side;

    sums = new int[side * side];
    int[] points = new int[side * side];
    for (int y = 0; y < side; y++) {
      for (int x = 0; x < side; x++) {
        points[(y * side) + x] = calculate(x, y, serial);
      }
    }

    for (int y = 0; y < side; y++) {
      for (int x = 0; x < side; x++) {
        int left = sumAt(x - 1, y);
        int above = sumAt(x, y - 1);
        int leftAbove = sumAt(x - 1, y - 1);
        int current = points[y * 300 + x];

        sums[((y) * 300) + (x)] = current + left + above - leftAbove;
      }
    }
  }

  Sum largestSumOfAll() {
    Sum theLargest = new Sum(0, 0, 0, 0);
    for (int oneSide = 1; oneSide <= side; oneSide++) {
      Sum newLargest = largestSum(oneSide);
      if (newLargest.value() >= theLargest.value()) {
        theLargest = newLargest;
      }
    }

    return theLargest;
  }

  Sum largestSum(int sumSide) {
    int xSum = 0;
    int ySum = 0;
    int largestSum = 0;

    int delta = sumSide - 1;
    for (int y = 0; y < side - sumSide; y++) {
      for (int x = 0; x < side - sumSide; x++) {
        int newSum = sum(x, y, x + delta, y + delta);
        if (newSum > largestSum) {
          xSum = x;
          ySum = y;
          largestSum = newSum;
        }
      }
    }

    return new Sum(xSum, ySum, sumSide, largestSum);
  }

  private int sum(int left, int top, int right, int bottom) {
    return sumAt(right, bottom)
        - sumAt(right, top - 1)
        - sumAt(left - 1, bottom)
        + sumAt(left - 1, top - 1);
  }

  private int sumAt(int x, int y) {
    if (x < 0 || y < 0) {
      return 0;
    }

    return sums[(y * side) + x];
  }

  private int calculate(int x, int y, int serial) {
    return ((((x + 10) * (serial + ((x + 10) * y))) / 100) % 10) - 5;
  }
}
