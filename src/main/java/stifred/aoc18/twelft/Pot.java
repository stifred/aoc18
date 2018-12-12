package stifred.aoc18.twelft;

class Pot {
  private boolean hasPlant;
  private Pot left;
  private Pot right;

  Pot(boolean hasPlant, Pot left, Pot right) {
    this.hasPlant = hasPlant;
    this.left = left;
    this.right = right;
  }

  Pot left() {
    if (left == null) {
      return new Pot(false, null, this);
    }

    return left;
  }

  Pot right() {
    if (right == null) {
      return new Pot(false, this, null);
    }

    return right;
  }

  void addRight(Pot pot) {
    right = pot;
  }

  void apply(Prospect prospect) {
    if (prospect.doesApplyTo(this)) {
      this.hasPlant = prospect.nextGeneration();
    }
  }

  boolean hasPlant() {
    return hasPlant;
  }
}
