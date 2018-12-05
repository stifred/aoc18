package stifred.aoc18.fifth;

import stifred.aoc18.December;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Fifth implements December {
  @Override
  public String firstChallenge(String input) {
    List<String> polymer = Arrays.asList(input.split(""));

    return Integer.toString(splitPolymers(polymer).size());
  }

  @Override
  public String secondChallenge(String input) {
    List<String> polymer = Arrays.asList(input.split(""));
    String[] badBois = "abcdefghijklmnopqrstuvwxyz".split("");

    int record = 10000000;
    for (var badBoi : badBois) {
      List<String> testPolymer = removeFromPolymer(polymer, badBoi);

      int newLength = splitPolymers(testPolymer).size();
      if (newLength < record) {
        record = newLength;
      }
    }

    return Integer.toString(record);
  }

  private List<String> removeFromPolymer(List<String> polymer, String badBoi) {
    return polymer
        .stream()
        .filter(chara -> !chara.equalsIgnoreCase(badBoi))
        .collect(Collectors.toList());
  }

  private Deque<String> splitPolymers(List<String> input) {
    Deque<String> output = new ArrayDeque<>(input.size());

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
