package stifred.aoc18.eleventh;

class PowerCell {
  private final int x;
  private final int y;
  private final int serial;

  PowerCell(int x, int y, int serial) {
    this.x = x;
    this.y = y;
    this.serial = serial;
  }

  int rackId() {
    return x + 10;
  }

  int powerLeverStart() {
    return rackId() * y;
  }

  int powerWithSerial() {
    return serial + powerLeverStart();
  }

  int multipliedWithRackIdAgain() {
    return rackId() * powerWithSerial();
  }

  int onlyTheHundreds() {
    return (multipliedWithRackIdAgain() / 100) % 10;
  }

  int totalPower() {
    return onlyTheHundreds() - 5;
  }
}
