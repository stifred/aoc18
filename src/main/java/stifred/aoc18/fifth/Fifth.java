package stifred.aoc18.fifth;

import stifred.aoc18.December;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Fifth implements December {
  @Override
  public String firstChallenge(String input) {
    String[] polymer = input.split("");

    return Integer.toString(splitPolymers(polymer).size());
  }

  @Override
  public String secondChallenge(String input) {
    String[] polymer = input.split("");
    String[] badBois = "abcdefghijklmnopqrstuvwxyz".split("");

    Deque<String> poly2 = splitPolymers(polymer);
    String[] poly2arr = String.join("", poly2).split("");

    int record = 10000000;
    for (var badBoi : badBois) {
      String[] testPolymer = removeFromPolymer(poly2arr, badBoi);

      int newLength = splitPolymers(testPolymer).size();
      if (newLength < record) {
        record = newLength;
      }
    }

    return Integer.toString(record);
  }

  private String[] removeFromPolymer(String[] polymer, String badBoi) {
    return Arrays.stream(polymer)
            .filter(chara -> !chara.equalsIgnoreCase(badBoi))
            .collect(Collectors.joining(""))
            .split("");
  }

  private Deque<String> splitPolymers(String[] input) {
    Deque<String> output = new ArrayDeque<>(input.length);

    for (var chara : input) {
      String prev = output.peekLast();

      if (prev != null) {
        if (chara.equalsIgnoreCase(prev) && !chara.equals(prev)) {
          output.removeLast();
        } else {
          output.addLast(chara);
        }
      } else {
        output.addLast(chara);
      }
    }

    return output;
  }
}
