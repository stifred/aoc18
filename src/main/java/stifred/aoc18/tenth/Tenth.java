package stifred.aoc18.tenth;

import stifred.aoc18.December;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Tenth implements December {
  private int second = 0;

  @Override
  public String firstChallenge(String input) {
    List<Light> lights = Arrays.stream(input.split("\n"))
        .map(Light::from)
        .collect(Collectors.toList());

    Board board = new Board(lights);

    String result = "";
    for (int seconds = 0; seconds < 100000; seconds++) {
      Optional<String> optStr = board.printAt(seconds);
      if (optStr.isPresent()) {
        result = optStr.get();
        second = seconds;
      }
    }

    return result;
  }

  @Override
  public String secondChallenge(String input) {
    return second + " seconds";
  }
}
