package stifred.aoc18.fourteenth;

import java.util.ArrayList;
import java.util.List;

class Recipe {
  private static Recipe last;
  private final int score;
  private final Recipe first;
  private Recipe next;

  Recipe(int score) {
    this.score = score;
    this.first = this;
    this.next = null;
    last = this;
  }

  private Recipe(int score, Recipe first, Recipe next) {
    this.score = score;
    this.first = first;
    this.next = next;
  }

  Recipe next() {
    return next != null ? next : first;
  }

  Recipe backToStart() {
    return first;
  }

  Recipe addNext(int number) {
    Recipe newRecipe = new Recipe(number, first, null);
    this.next = newRecipe;
    last = last.next;
    return newRecipe;
  }

  int score() {
    return this.score;
  }

  int combineWith(Recipe other) {
    int sum = score + other.score();

    int count = 0;
    if (sum >= 10) {
      last.addNext(1);
      count++;
    }

    last.addNext(sum % 10);
    count++;

    return count;
  }

  List<Integer> combineWithList(Recipe other) {
    int sum = score + other.score();

    List<Integer> output = new ArrayList<>();
    if (sum >= 10) {
      last.addNext(1);
      output.add(1);
    }

    int digit = sum % 10;
    last.addNext(digit);
    output.add(digit);

    return output;
  }
}
