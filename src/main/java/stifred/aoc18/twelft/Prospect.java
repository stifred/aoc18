package stifred.aoc18.twelft;

class Prospect {
  private final boolean left2;
  private final boolean left1;
  private final boolean current;
  private final boolean right1;
  private final boolean right2;
  private final boolean next;

  private Prospect(
      boolean left2, boolean left1, boolean current, boolean right1, boolean right2, boolean next) {
    this.left2 = left2;
    this.left1 = left1;
    this.current = current;
    this.right1 = right1;
    this.right2 = right2;
    this.next = next;
  }

  boolean doesApplyTo(Pot currentPot) {
    Pot left = currentPot.left();
    Pot right = currentPot.right();

    return left.left().hasPlant() == left2
        && left.hasPlant() == left1
        && current == currentPot.hasPlant()
        && right.hasPlant() == right1
        && right.right().hasPlant() == right2;
  }

  boolean nextGeneration() {
    return next;
  }

  static Prospect from(String string) {
    boolean[] booleans = new boolean[6];
    int current = 0;
    for (char chr : string.toCharArray()) {
      if (chr == '#') {
        booleans[current] = true;
        current++;
      } else if (chr == '.') {
        booleans[current] = false;
        current++;
      }
    }

    return new Prospect(
        booleans[0], booleans[1], booleans[2], booleans[3], booleans[4], booleans[5]);
  }
}
