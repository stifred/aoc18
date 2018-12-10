package stifred.aoc18.tenth;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Board {
  private int record = 1000000;

  private final List<Light> lights;

  Board(List<Light> lights) {
    this.lights = lights;
  }

  Optional<String> printAt(int seconds) {
    List<Point> positions =
        lights.stream().map(light -> light.positionAt(seconds)).collect(Collectors.toList());

    int minX = positions.stream().mapToInt(Point::getX).min().orElse(0);
    int minY = positions.stream().mapToInt(Point::getY).min().orElse(0);
    int maxX = positions.stream().mapToInt(Point::getX).max().orElse(0);
    int maxY = positions.stream().mapToInt(Point::getY).max().orElse(0);

    int deltaX = maxX - minX;
    int deltaY = maxY - minY;

    if (deltaX > 384 && deltaY > 255) {
      return Optional.empty();
    }

    if (deltaY != 9) {
      return Optional.empty();
    }

    boolean[][] bools = new boolean[deltaX + 1][deltaY + 1];
    for (Point position : positions) {
      bools[position.getX() - minX][position.getY() - minY] = true;
    }

    StringBuilder builder = new StringBuilder();
    for (int y = 0; y <= deltaY; y++) {
      for (int x = 0; x <= deltaX; x++) {
        builder.append(bools[x][y] ? "X" : " ");
      }
      builder.append("\n");
    }

    return Optional.of(builder.toString());
  }
}
