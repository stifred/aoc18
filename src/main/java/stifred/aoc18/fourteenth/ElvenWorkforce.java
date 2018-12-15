package stifred.aoc18.fourteenth;

import java.util.Arrays;
import java.util.stream.Collectors;

class ElvenWorkforce {
  private Recipe first;
  private Recipe second;

  ElvenWorkforce() {
    first = new Recipe(3);
    second = first.addNext(7);
  }

  String doWork(int numberOfRecipes) {
    int count = 2;
    do {
      int moveFirst = 1 + first.score();
      int moveSecond = 1 + second.score();

      count += first.combineWith(second);

      for (int i = 0; i < moveFirst; i++) {
        first = first.next();
      }

      for (int i = 0; i < moveSecond; i++) {
        second = second.next();
      }
    } while (count <= numberOfRecipes + 10);

    Recipe current = first.backToStart();
    for (int i = 0; i < numberOfRecipes; i++) {
      current = current.next();
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      builder.append(current.score());
      current = current.next();
    }

    return builder.toString();
  }

  String doOtherWork(String searchOf) {
    Matcher matcher =
        new Matcher(
            Arrays.stream(searchOf.split("")).map(Integer::parseInt).collect(Collectors.toList()));
    int index = 2;
    while (!matcher.hasMatch()) {
      int moveFirst = 1 + first.score();
      int moveSecond = 1 + second.score();

      for (int next : first.combineWithList(second)) {
        matcher.apply(index, next);
        index++;
      }

      for (int i = 0; i < moveFirst; i++) {
        first = first.next();
      }

      for (int i = 0; i < moveSecond; i++) {
        second = second.next();
      }
    }

    return Integer.toString(matcher.index());
  }
}
