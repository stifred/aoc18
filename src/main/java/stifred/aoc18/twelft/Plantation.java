package stifred.aoc18.twelft;

import java.util.ArrayList;
import java.util.List;

class Plantation {
  private final List<Pot> pots;
  private final List<Prospect> prospects;

  Plantation(List<Pot> pots, List<Prospect> prospects) {
    this.pots = pots;
    this.prospects = prospects;
  }

  long applyGenerations(int count) {
    long sum = 0;

    for (int i = 0; i < count; i++) {
      for (Pot pot : pots) {
        for (Prospect prospect : prospects) {
          pot.apply(prospect);
        }
      }

      sum += countPlants();
    }

    return sum;
  }

  private long countPlants() {
    return pots.stream().filter(Pot::hasPlant).count();
  }

  static Plantation from(String string) {
    String[] lines = string.split("\n");
    char[] potChars = lines[0].substring(15).toCharArray();

    List<Pot> pots = new ArrayList<>();
    Pot last = null;
    for (char ignored : potChars) {
      Pot newPot = new Pot(false, last, null);
      if (last != null) {
        last.addRight(newPot);
      }
      pots.add(newPot);
      last = newPot;
    }

    for (char potChar : potChars) {
      Pot newPot = new Pot(potChar == '#', last, null);
      last.addRight(newPot);
      pots.add(newPot);
      last = newPot;
    }

    for (char ignored : potChars) {
      Pot newPot = new Pot(false, last, null);
      last.addRight(newPot);
      pots.add(newPot);
      last = newPot;
    }

    List<Prospect> prospects = new ArrayList<>();
    for (int i = 2; i < lines.length; i++) {
      prospects.add(Prospect.from(lines[i]));
    }

    return new Plantation(pots, prospects);
  }
}
