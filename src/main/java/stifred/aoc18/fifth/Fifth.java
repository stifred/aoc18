package stifred.aoc18.fifth;

import stifred.aoc18.December;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class Fifth implements December {
  @Override
  public String firstChallenge(String input) {
    char[] polymer = input.toCharArray();

    return Integer.toString(splitPolymers(polymer).size());
  }

  @Override
  public String secondChallenge(String input) {
    char[] polymer = input.toCharArray();
    Deque<Character> poly2 = splitPolymers(polymer);
    char[] poly2arr =
        poly2
            .stream()
            .map(String::valueOf)
            .collect(Collectors.joining(""))
            .toCharArray();

    int record = 10000000;
    for (int i = 0; i < 26; i++) {
      char[] testPolymer = removeFromPolymer(poly2arr, i);

      int newLength = splitPolymers(testPolymer).size();
      if (newLength < record) {
        record = newLength;
      }
    }

    return Integer.toString(record);
  }

  private char[] removeFromPolymer(char[] polymer, int index) {
    return new String(polymer)
        .replaceAll("[" + (char) ('a' + index) + (char) ('A' + index) + "]", "")
        .toCharArray();
  }

  private Deque<Character> splitPolymers(char[] input) {
    Deque<Character> output = new ArrayDeque<>(input.length);

    for (var chara : input) {
      Character prev = output.peekLast();

      if (prev != null) {
        if (Math.abs(chara - prev) == 32) {
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
