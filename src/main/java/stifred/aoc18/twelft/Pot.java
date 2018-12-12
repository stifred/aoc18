package stifred.aoc18.twelft;

class Pot {
  private final int index;
  private boolean hasPlant;
  private boolean nextState;
  private boolean hasRight;
  private Pot left;
  private Pot right;

  Pot(int index, boolean hasPlant, Pot left, Pot right) {
    this.index = index;
    this.hasPlant = hasPlant;
    this.left = left;
    this.right = right;
    this.hasRight = right != null;
  }

  Pot left() {
    if (left == null) {
      left = new Pot(index - 1, false, null, this);
    }

    return left;
  }

  boolean hasRight() {
    return hasRight;
  }

  Pot right() {
    if (right == null) {
      right = new Pot(index + 1, false, this, null);
    }

    return right;
  }

  void addRight(Pot pot) {
    right = pot;
    right.left = this;
    this.hasRight = true;
  }

  void removePlant() {
    nextState = false;
  }

  boolean apply(Prospect prospect) {
    boolean doesApply = prospect.doesApplyTo(this);

    if (doesApply) {
      this.nextState = prospect.nextGeneration();
    }

    return doesApply;
  }

  int index() {
    return index;
  }

  void commit() {
    hasPlant = nextState;
    hasRight = right != null;
  }

  boolean hasPlant() {
    return hasPlant;
  }
}
