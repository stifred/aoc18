package stifred.aoc18.thirteenth;

import java.util.ArrayList;
import java.util.List;

class RailSet {
  private final int width;
  private final List<Rail> rails;
  private final List<Cart> carts;

  private RailSet(int width, List<Rail> rails, List<Cart> carts) {
    this.width = width;
    this.rails = rails;
    this.carts = carts;
  }

  Rail railAt(int x, int y) {
    if (x < 0 || x > width) {
      return new Rail(x, y, this, ' ');
    }
    if (y < 0 || (y * width) + x >= rails.size()) {
      return new Rail(x, y, this, ' ');
    }

    return rails.get((y * width) + x);
  }

  Point findFirstCrash() {
    int seconds = 0;
    while (seconds < Integer.MAX_VALUE) {
      Point crash = Cart.crash(carts);
      if (crash != null) {
        return crash;
      }

      seconds++;

      for (var cart : carts) {
        cart.adjustDirection();
      }

      for (var cart : carts) {
        cart.tick();
      }
    }

    return null;
  }

  static RailSet fromString(String input) {
    String[] lines = input.split("\n");
    int width = 0;

    // Workaround for removed trailing spaces - Thanks, Intellij
    for (String line : lines) {
      if (line.length() > width) {
        width = line.length();
      }
    }

    List<Rail> rails = new ArrayList<>();
    List<Cart> carts = new ArrayList<>();
    RailSet railSet = new RailSet(width, rails, carts);

    for (int y = 0; y < lines.length; y++) {
      String line = lines[y];
      for (int x = 0; x < line.length(); x++) {
        char point = line.charAt(x);
        char rail = point;
        switch (point) {
          case '^':
          case 'v':
            rail = '|';
          case '>':
          case '<':
            if (rail == point) {
              rail = '-';
            }
            carts.add(new Cart(x, y, Direction.of(String.valueOf(point)), railSet));
          default: // Nothing
        }

        rails.add(new Rail(x, y, railSet, rail));
      }
      for (int x = line.length(); x < width; x++) {
        rails.add(new Rail(x, y, railSet, ' '));
      }
    }

    return railSet;
  }
}
