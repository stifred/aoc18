package stifred.aoc18.tenth;

class Point {
  private final int x;
  private final int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  int getX() {
    return x;
  }

  int getY() {
    return y;
  }

  static Point from(String string) {
    String[] parts = string.split(",");
    int x = Integer.parseInt(parts[0].trim());
    int y = Integer.parseInt(parts[1].trim());
    return new Point(x, y);
  }
}

