package stifred.aoc18.thirteenth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Cart {
  private int x;
  private int y;
  private boolean goLeft = true;
  private boolean goAhead = true;
  private Direction direction;
  private final RailSet railSet;

  Cart(int x, int y, Direction direction, RailSet railSet) {
    this.x = x;
    this.y = y;
    this.direction = direction;
    this.railSet = railSet;
  }

  int x() {
    return x;
  }

  int y() {
    return y;
  }

  public Direction dir() {
    return direction;
  }

  void adjustDirection() {
    Rail current = railSet.railAt(x, y);

    if (current.isIntersection()) {
      direction = findNextChoice();
    } else {
      if (current.getChara() == '/') {
        if (direction.isVertical()) {
          direction = direction.right();
        } else {
          direction = direction.left();
        }
      } else if (current.getChara() == '\\') {
        if (direction.isHorizontal()) {
          direction = direction.right();
        } else {
          direction = direction.left();
        }
      }
    }
  }

  void tick() {
    x += direction.getDeltaX();
    y += direction.getDeltaY();
  }

  private Direction findNextChoice() {
    if (goLeft) {
      goLeft = false;
      return direction.left();
    }

    if (goAhead) {
      goAhead = false;
      return direction;
    }

    goLeft = true;
    goAhead = true;
    return direction.right();
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

  static List<Cart> crash2(List<Cart> carts) {
    Set<Point> points = new HashSet<>();

    Set<Point> intersections = new HashSet<>();
    for (var cart : carts) {
      if (!points.add(new Point(cart.x, cart.y))) {
        intersections.add(new Point(cart.x, cart.y));
      }
    }
    if (intersections.isEmpty()) {
      return carts;
    }

    return carts
        .stream()
        .filter(cart -> !intersections.contains(new Point(cart.x, cart.y)))
        .collect(Collectors.toList());
  }
}
