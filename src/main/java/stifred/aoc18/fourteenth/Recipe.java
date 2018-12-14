package stifred.aoc18.fourteenth;

import java.util.List;

class Recipe {
  private final int score;
  private final Recipe first;
  private final Recipe previous;
  private Recipe next;

  Recipe(int score) {
    this.score = score;
    this.first = this;
    this.previous = null;
    this.next = null;
  }

  private Recipe(int score, Recipe first, Recipe previous, Recipe next) {
    this.score = score;
    this.first = first;
    this.previous = previous;
    this.next = next;
  }

  boolean isFirst() {
    return previous == null;
  }

  boolean isLast() {
    return next == null;
  }

  Recipe previous() {
    return previous != null ? previous : first;
  }

  Recipe next() {
    return next != null ? next : first;
  }

  Recipe backToStart() {
    return first;
  }

  Recipe addNext(int number) {
    Recipe newRecipe = new Recipe(number, first, this, null);
    this.next = newRecipe;
    return newRecipe;
  }

  int score() {
    return this.score;
  }

  int length() {
    Recipe current = first;
    int count = 1;
    while (!current.isLast()) {
      count++;
      current = current.next();
    }
    return count;
  }

  int combineWith(Recipe other) {
    int sum = score + other.score();
    String[] sumStr = Integer.toString(sum).split("");

    Recipe last = this;
    while (!last.isLast()) {
      last = last.next();
    }

    int count = 0;
    for (String digit : sumStr) {
      last.addNext(Integer.parseInt(digit));
      last = last.next();
      count++;
    }
    return count;
  }

  String combineWithStr(Recipe other) {
    int sum = score + other.score();
    String whole = Integer.toString(sum);
    String[] sumStr = whole.split("");

    Recipe last = this;
    while (!last.isLast()) {
      last = last.next();
    }

    for (String digit : sumStr) {
      last.addNext(Integer.parseInt(digit));
      last = last.next();
    }

    return whole;
  }
}
