package stifred.aoc18.thirteenth;

import static stifred.aoc18.thirteenth.Direction.*;

class Rail {
  private final int x;
  private final int y;
  private final RailSet railSet;
  private final char chara;

  Rail(int x, int y, RailSet railSet, char chara) {
    this.x = x;
    this.y = y;
    this.railSet = railSet;
    this.chara = chara;
  }

  Rail go(Direction direction) {
    return railSet.railAt(x + direction.getDeltaX(), y + direction.getDeltaY());
  }

  boolean isIntersection() {
    int dirs = 0;
    for (Direction direction : Direction.values()) {
      if (canGo(direction)) {
        dirs++;
      }
    }

    return dirs > 2;
  }

  boolean canGo(Direction direction) {
    if (chara == '+') {
      return true;
    }

    if (chara == '|' && (direction == UP || direction == DOWN)) {
      return true;
    }

    if (chara == '-' && (direction == LEFT || direction == RIGHT)) {
      return true;
    }

    Rail left = go(LEFT);
    Rail up = go(UP);
    Rail right = go(RIGHT);
    Rail down = go(DOWN);
    if (chara == '/' && down.chara == '|' && right.chara == '-') {
      return direction == DOWN || direction == RIGHT;
    }
    if (chara == '/' && up.chara == '|' && left.chara == '-') {
      return direction == UP || direction == LEFT;
    }
    if (chara == '\\' && up.chara == '|' && right.chara == '-') {
      return direction == UP || direction == RIGHT;
    }
    if (chara == '\\' && down.chara == '|' && left.chara == '-') {
      return direction == DOWN || direction == LEFT;
    }

    return false;
  }
}
