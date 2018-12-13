package stifred.aoc18.thirteenth;

import stifred.aoc18.December;

public class Thirteenth implements December {
  @Override
  public String firstChallenge(String input) {
    return "" + RailSet.fromString(input).findFirstCrash();
  }

  @Override
  public String secondChallenge(String input) {
    return null;
  }
}
