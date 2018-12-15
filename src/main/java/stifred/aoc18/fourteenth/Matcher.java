package stifred.aoc18.fourteenth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Matcher {
  private int index = -1;
  private int maxStage;
  private boolean isDone = false;
  private final List<Integer> combination;
  private Map<Integer, Integer> stages = new HashMap<>();

  Matcher(List<Integer> combination) {
    this.combination = combination;
    this.maxStage = combination.size();
  }

  void apply(int index, int number) {
    if (isDone) {
      return;
    }

    Map<Integer, Integer> nextStages = new HashMap<>();
    stages.forEach(
        (key, value) -> {
          int nextValue = value + 1;
          if (number == combination.get(value)) {
            if (nextValue == maxStage) {
              updateIndex(key);
              isDone = true;
              return;
            }

            nextStages.put(key, nextValue);
          }
        });

    if (number == combination.get(0)) {
      nextStages.put(index, 1);
    }

    stages = nextStages;
  }

  private void updateIndex(int newIndex) {
    index = newIndex;
  }

  int index() {
    return index;
  }

  boolean hasMatch() {
    return isDone;
  }
}
