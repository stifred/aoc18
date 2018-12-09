package stifred.aoc18.ninth;

class Marble {
  private final int value;
  private Marble left;
  private Marble right;

  Marble(int value) {
    this.value = value;
    this.left = this;
    this.right = this;
  }

  private Marble(int value, Marble left, Marble right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  Marble addRight(int newValue) {
    Marble newMarble = new Marble(newValue, this, this.right);

    this.right.left = newMarble;
    this.right = newMarble;
    return newMarble;
  }

  Marble left(int steps) {
    Marble next = this;
    for (int i = 0; i < steps; i++) {
      next = next.left;
    }
    return next;
  }

  Marble right(int steps) {
    Marble next = this;
    for (int i = 0; i < steps; i++) {
      next = next.right;
    }
    return next;
  }

  int pop() {
    this.left.right = this.right;
    this.right.left = this.left;
    return this.value;
  }
}
