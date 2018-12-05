package stifred.aoc18.fifth;

import stifred.aoc18.December;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Fifth implements December {
  @Override
  public String firstChallenge(String input) {
    List<String> polymer = Arrays.asList(input.split(""));

    int prevLength;
    do {
      prevLength = polymer.size();
      polymer = splitPolymers(polymer);
    } while (polymer.size() < prevLength);

    return Integer.toString(polymer.size());
  }

  @Override
  public String secondChallenge(String input) {
    List<String> polymer = Arrays.asList(input.split(""));
    String[] badBois = "abcdefghijklmnopqrstuvwxyz".split("");

    int record = 10000000;
    for (var badBoi : badBois) {
      List<String> testPolymer = removeFromPolymer(polymer, badBoi);

      int prevLength;
      do {
        prevLength = testPolymer.size();
        testPolymer = splitPolymers(testPolymer);
      } while (testPolymer.size() < prevLength);

      if (testPolymer.size() < record) {
        record = testPolymer.size();
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

  private List<String> splitPolymers(List<String> input) {
    List<String> output = new ArrayList<>();
    String prev = null;

    for (var chara : input) {
      if (prev != null) {
        if (chara.equalsIgnoreCase(prev) && !chara.equals(prev)) {
          prev = null;
        } else {
          output.add(prev);
          prev = chara;
        }
      } else {
        prev = chara;
      }
    }

    if (prev != null) {
      output.add(prev);
    }

    return output;
  }
}
