package stifred.aoc18.thirteenth;

import java.util.ArrayList;
import java.util.List;

class RailSet {
  private final int width;
  private final List<Rail> rails;
  private List<Cart> carts;

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

      // print();
    }

    return null;
  }

  Point findLastCartStanding() {
    int seconds = 0;
    while (seconds < Integer.MAX_VALUE) {

      seconds++;

      for (int i = 0; i < carts.size(); i++) {
        if (i < 0) {
          continue;
        }

        Cart cart = carts.get(i);

        int currSize = carts.size();
        carts = Cart.crash2(carts);
        if (carts.size() < currSize) {
          i += (carts.size() - currSize);

          if (carts.size() == 1) {
            Cart last = carts.get(0);
            return new Point(last.x(), last.y());
          }

          continue;
        }

        cart.adjustDirection();
        cart.tick();
      }
    }

    return null;
  }

  private void print() {
    int height = (rails.size() / width) + 1;
    for (int i = 0; i < height; i++) {
      StringBuilder builder = new StringBuilder();

      for (int j = 0; j < width; j++) {
        boolean hasCart = false;
        String chara = " ";
        for (Cart cart : carts) {
          if (cart.x() == j && cart.y() == i) {
            if (!hasCart) {
              chara = cart.dir().value();
              hasCart = true;
            } else {
              chara = "B";
            }
          }
        }

        if (hasCart) {
          builder.append(chara);
        } else {
          builder.append(railAt(j, i).getChara());
        }
      }

      System.out.println(builder.toString());
    }
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
