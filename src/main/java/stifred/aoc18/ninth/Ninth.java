package stifred.aoc18.ninth;

import stifred.aoc18.December;

public class Ninth implements December {
  @Override
  public String firstChallenge(String input) {
    return Long.toString(setupGame(input, 1).play());
  }

  @Override
  public String secondChallenge(String input) {
    return Long.toString(setupGame(input, 100).play());
  }

  private MarbleGame setupGame(String input, int multiplier) {
    String[] parts = input.split(" ");
    int playerCount = Integer.parseInt(parts[0]);
    int lastMarble = Integer.parseInt(parts[6]);

    return new MarbleGame(playerCount, lastMarble, multiplier);
  }
}
