package stifred.aoc18.fourteenth;

import java.util.HashMap;
import java.util.Map;

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
    StringBuilder str = new StringBuilder("37");
    int index = -1;
    do {
      int moveFirst = 1 + first.score();
      int moveSecond = 1 + second.score();

      str.append(first.combineWithStr(second));

      for (int i = 0; i < moveFirst; i++) {
        first = first.next();
      }

      for (int i = 0; i < moveSecond; i++) {
        second = second.next();
      }

      index = str.indexOf(searchOf);
    } while (index < 0);

    return Integer.toString(index);
  }
}
