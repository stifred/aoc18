package stifred.aoc18.sixth.a;

import java.util.List;
import java.util.Objects;

public class Point {
  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Point findClosest(List<Point> others) {
    return findClosest(others, -1);
  }

  public Point findClosest(List<Point> others, int maxSum) {
    Point closest = null;
    int lowestDistance = 10000000;
    boolean equal = false;
    int total = 0;

    for (Point point : others) {
      int distance = findManhattanDistanceTo(point);
      total += distance;

      if (distance == lowestDistance) {
        equal = true;
      } else if (distance < lowestDistance) {
        closest = point;
        lowestDistance = distance;
        equal = false;
      }
    }

    if (equal || (maxSum > 0 && total > maxSum)) {
      return null;
    }

    return closest;
  }

  private int findManhattanDistanceTo(Point other) {
    return Math.abs(x - other.x) + Math.abs(y - other.y);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point point = (Point) o;
    return x == point.x && y == point.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  public static Point max(List<Point> all) {
    int x = all.stream().mapToInt(Point::getX).max().orElse(0);
    int y = all.stream().mapToInt(Point::getY).max().orElse(0);

    return new Point(x, y);
  }

  public static Point from(String string) {
    String[] parts = string.split(",");
    int x = Integer.parseInt(parts[0].trim());
    int y = Integer.parseInt(parts[1].trim());

    return new Point(x, y);
  }
}
