package stifred.aoc18.third.a;

public class Position {
  private final int x;
  private final int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int hashCode() {
    return (x * 100000) + y;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Position)) {
      return false;
    }

    Position other = (Position) obj;

    return other.x == x && other.y == y;
  }

  @Override public String toString() {
    return String.format("%d,%d", x, y);
  }
}
