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

  boolean hasOutside(int second) {
    for (Light light : lights) {
      Point pos = light.positionAt(second);
      int x = pos.getX();
      int y = pos.getY();

      if (x < 0 || x > 384 || y < 0 || y > 255) {
        return true;
      }
    }

    return false;
  }

  Optional<String> printAt(int seconds) {
    if (hasOutside(seconds)) {
      return Optional.empty();
    }

    List<Point> positions =
        lights.stream().map(light -> light.positionAt(seconds)).collect(Collectors.toList());

    int minX = positions.stream().mapToInt(Point::getX).min().orElse(0);
    int minY = positions.stream().mapToInt(Point::getY).min().orElse(0);
    int maxX = positions.stream().mapToInt(Point::getX).max().orElse(0);
    int maxY = positions.stream().mapToInt(Point::getY).max().orElse(0);

    int deltaX = maxX - minX;
    int deltaY = maxY - minY;

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
        builder.append(bools[x][y] ? "#" : " ");
      }
      builder.append("\n");
    }
    builder.append(seconds).append(" SECONDS").append("\n\n");

    return Optional.of(builder.toString());
  }
}
