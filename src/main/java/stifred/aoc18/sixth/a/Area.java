package stifred.aoc18.sixth.a;

import java.util.List;

public class Area {
  private final Point closestTo;
  private final Point max;
  private final List<Point> points;

  public Area(Point closestTo, Point max, List<Point> points) {
    this.closestTo = closestTo;
    this.max = max;
    this.points = points;
  }

  public boolean isInfinite() {
    return points
        .stream()
        .anyMatch(
            p ->
                p.getX() == 0 || p.getY() == 0 || p.getX() == max.getX() || p.getY() == max.getY());
  }

  public int getSize() {
    return points.size();
  }
}
