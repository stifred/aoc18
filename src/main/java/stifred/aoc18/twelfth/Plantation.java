package stifred.aoc18.twelfth;

import java.util.ArrayList;
import java.util.List;

class Plantation {
  private final List<Pot> pots;
  private final List<Prospect> prospects;
  private Pot first;

  Plantation(List<Pot> pots, List<Prospect> prospects) {
    this.pots = pots;
    this.prospects = prospects;

    first = pots.get(0);
  }

  long applyGenerations(long count) {
    int sum = 0;

    int prevSum = 0;
    int currDiff = 0;
    int prevDiff = 0;
    for (int i = 0; i < count; i++) {
      sum = 0;

      Pot current = null;

      do {
        if (current == null) {
          current = first;
        } else {
          current = current.right();
        }

        boolean hasApplied = false;

        for (Prospect prospect : prospects) {
          if (current.apply(prospect)) {
            hasApplied = true;
            break;
          }
        }

        if (!hasApplied) {
          current.removePlant();
        }
      } while (current.hasRight());

      current = null;
      do {
        if (current == null) {
          current = first;
        } else {
          current = current.right();
        }

        current.commit();

        if (current.hasPlant()) {
          sum += current.index();
        }

      } while (current.hasRight());

      currDiff = sum - prevSum;
      prevSum = sum;

      if (currDiff == prevDiff) {
        return sum + ((count - i - 1) * prevDiff);
      }

      prevDiff = currDiff;
    }

    return sum;
  }

  static Plantation from(String string) {
    String[] lines = string.split("\n");
    char[] potChars = lines[0].substring(15).toCharArray();

    List<Pot> pots = new ArrayList<>();
    int currentIndex = -potChars.length;
    Pot last = new Pot(currentIndex - 1, false, null, null);
    for (int i = 0; i < potChars.length; i++) {
      Pot newPot = new Pot(currentIndex, false, last, null);
      last.addRight(newPot);
      pots.add(newPot);
      last = newPot;
      currentIndex++;
    }

    for (char potChar : potChars) {
      Pot newPot = new Pot(currentIndex, potChar == '#', last, null);
      last.addRight(newPot);
      pots.add(newPot);
      last = newPot;
      currentIndex++;
    }

    for (int i = 0; i < potChars.length; i++) {
      Pot newPot = new Pot(currentIndex, false, last, null);
      last.addRight(newPot);
      pots.add(newPot);
      last = newPot;
      currentIndex++;
    }

    List<Prospect> prospects = new ArrayList<>();
    for (int i = 2; i < lines.length; i++) {
      prospects.add(Prospect.from(lines[i]));
    }

    return new Plantation(pots, prospects);
  }
}
