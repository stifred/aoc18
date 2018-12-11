package stifred.aoc18.eleventh;

import stifred.aoc18.December;

public class Eleventh implements December {
  @Override
  public String firstChallenge(String input) {
    int serial = Integer.parseInt(input);

    int record = 0;
    int x = 0;
    int y = 0;
    for (int xx = 0; xx < 298; xx++) {
      for (int yy = 0; yy < 298; yy++) {
        int sum = 0;
        for (int xxx = 0; xxx < 3; xxx++) {
          for (int yyy = 0; yyy < 3; yyy++) {
            sum += new PowerCell(xx + xxx, yy + yyy, serial).totalPower();
          }
        }

        if (sum > record) {
          x = xx;
          y = yy;
          record = sum;
        }
      }
    }

    return x + "," + y;
  }

  @Override
  public String secondChallenge(String input) {
    int serial = Integer.parseInt(input);

    int x = 0;
    int y = 0;
    int maxSize = 0;
    int record = 0;
    for (int size = 0; size < 300; size++) {
      for (int xx = 0; xx < 300 - size - 1; xx++) {
        for (int yy = 0; yy < 298 - size - 1; yy++) {
          int sum = 0;
          for (int xxx = 0; xxx < size; xxx++) {
            for (int yyy = 0; yyy < size; yyy++) {
              sum += new PowerCell(xx + xxx, yy + yyy, serial).totalPower();
            }
          }

          if (sum > record) {
            x = xx;
            y = yy;
            record = sum;
            maxSize = size;
          }
        }
      }
    }

    return x + "," + y + "," + maxSize;
  }
}
