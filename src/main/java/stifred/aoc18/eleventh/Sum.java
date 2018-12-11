package stifred.aoc18.eleventh;

class Sum {
  private final int x;
  private final int y;
  private final int side;
  private final int value;

  Sum(int x, int y, int side, int value) {
    this.x = x;
    this.y = y;
    this.side = side;
    this.value = value;
  }

  int value() {
    return value;
  }

  String render(boolean withSide) {
    StringBuilder builder = new StringBuilder()
        .append(x)
        .append(",")
        .append(y);

    if (withSide) {
      builder.append(",").append(side);
    }

    return builder.toString();
  }
}
