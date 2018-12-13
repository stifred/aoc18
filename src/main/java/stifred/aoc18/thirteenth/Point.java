package stifred.aoc18.thirteenth;

class Point {
  private final int x;
  private final int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int hashCode() {
    return (y * 100_000) + x;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Point)) {
      return false;
    }

    Point other = (Point) obj;
    return other.x == x && other.y == y;
  }

  @Override
  public String toString() {
    return x + "," + y;
  }
}
