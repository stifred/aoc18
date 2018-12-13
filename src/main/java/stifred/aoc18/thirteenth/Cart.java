package stifred.aoc18.thirteenth;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Cart {
  private int x;
  private int y;
  private boolean goLeft = false;
  private boolean goAhead = false;
  private Direction direction;
  private final RailSet railSet;

  Cart(int x, int y, Direction direction, RailSet railSet) {
    this.x = x;
    this.y = y;
    this.direction = direction;
    this.railSet = railSet;
  }

  void adjustDirection() {
    Rail current = railSet.railAt(x, y);

    if (current.isIntersection()) {
      int health = 5;
      while (health > 0) {
        direction = findNextChoice();
        if (current.canGo(direction)) {
          break;
        }
        health--;
      }
    } else {
      if (current.canGo(direction)) {
        return;
      }

      for (Direction dir : Direction.values()) {
        if (current.canGo(dir)) {
          direction = dir;
          return;
        }
      }
    }
  }

  void tick() {
    x += direction.getDeltaX();
    y += direction.getDeltaY();
  }

  Direction findNextChoice() {
    if (goLeft) {
      goLeft = false;
      return direction.left();
    }

    if (goAhead) {
      goAhead = false;
      return direction.left();
    }

    goLeft = true;
    goAhead = true;
    return direction.left();
  }

  static Point crash(List<Cart> carts) {
    Set<Point> points = new HashSet<>();

    for (var cart : carts) {
      if (!points.add(new Point(cart.x, cart.y))) {
        return new Point(cart.x, cart.y);
      }
    }

    return null;
  }
}
