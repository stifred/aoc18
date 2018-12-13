package stifred.aoc18.thirteenth;

import java.util.HashMap;
import java.util.Map;

enum Direction {
  LEFT("<", -1, 0),
  UP("^", 0, -1),
  RIGHT(">", 1, 0),
  DOWN("v", 0, 1);

  private static final Map<String, Direction> dirMap = new HashMap<>();

  static {
    for (var direction : values()) {
      dirMap.put(direction.value(), direction);
    }
  }

  private final String value;
  private final int deltaX;
  private final int deltaY;

  Direction(String value, int deltaX, int deltaY) {
    this.value = value;
    this.deltaX = deltaX;
    this.deltaY = deltaY;
  }

  String value() {
    return value;
  }

  public int getDeltaX() {
    return deltaX;
  }

  public int getDeltaY() {
    return deltaY;
  }

  Direction left() {
    switch (this) {
      case UP:
        return LEFT;
      case LEFT:
        return DOWN;
      case DOWN:
        return RIGHT;
      case RIGHT:
        return UP;
      default:
        return UP;
    }
  }

  Direction right() {
    switch (this) {
      case UP:
        return RIGHT;
      case RIGHT:
        return DOWN;
      case DOWN:
        return LEFT;
      case LEFT:
        return UP;
      default:
        return UP;
    }
  }

  static Direction of(String str) {
    return dirMap.get(str);
  }
}
