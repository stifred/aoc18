package stifred.aoc18.ninth;

import stifred.aoc18.December;

public class Ninth implements December {
  @Override
  public String firstChallenge(String input) {
    String[] parts = input.split(" ");
    int playerCount = Integer.parseInt(parts[0]);
    int lastMarble = Integer.parseInt(parts[6]);

    MarbleGame game = new MarbleGame(playerCount, lastMarble);

    return Long.toString(game.play());
  }

  @Override
  public String secondChallenge(String input) {
    String[] parts = input.split(" ");
    int playerCount = Integer.parseInt(parts[0]);
    int lastMarble = Integer.parseInt(parts[6]);

    MarbleGame game = new MarbleGame(playerCount, lastMarble);

    return Long.toString(game.play(100));
  }
}
