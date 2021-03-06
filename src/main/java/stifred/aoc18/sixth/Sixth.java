package stifred.aoc18.sixth;

import stifred.aoc18.December;
import stifred.aoc18.sixth.a.Area;
import stifred.aoc18.sixth.a.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sixth implements December {
  int goal = 10000;

  @Override
  public String firstChallenge(String input) {
    List<Point> areaPoints =
        Arrays.stream(input.split("\n")).map(Point::from).collect(Collectors.toList());

    Point max = Point.max(areaPoints);
    int xMax = max.getX();
    int yMax = max.getY();
    List<Point> allPoints = new ArrayList<>();
    for (int x = 0; x < xMax; x++) {
      for (int y = 0; y < yMax; y++) {
        allPoints.add(new Point(x, y));
      }
    }

    int maxSize = 0;
    for (Point areaPoint : areaPoints) {
      List<Point> closest =
          allPoints
              .stream()
              .filter(p -> areaPoint.equals(p.findClosest(areaPoints)))
              .collect(Collectors.toList());

      Area area = new Area(areaPoint, max, closest);

      if (!area.isInfinite() && area.getSize() > maxSize) {
        maxSize = area.getSize();
      }
    }

    return Integer.toString(maxSize);
  }

  @Override
  public String secondChallenge(String input) {
    List<Point> areaPoints =
        Arrays.stream(input.split("\n")).map(Point::from).collect(Collectors.toList());

    Point max = Point.max(areaPoints);
    int xMax = max.getX();
    int yMax = max.getY();
    int size = 0;
    boolean foundStart = false;
    for (int x = 0; x < xMax; x++) {
      boolean foundAny = false;

      for (int y = 0; y < yMax; y++) {
        if (Point.checkDistanceSum(x, y, areaPoints, goal)) {
          size++;
          foundAny = true;
          foundStart = true;
        }
      }

      if (!foundAny && foundStart) {
        break;
      }
    }

    return Integer.toString(size);
  }
}
