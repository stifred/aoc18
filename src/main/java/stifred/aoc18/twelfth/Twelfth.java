package stifred.aoc18.twelfth;

import stifred.aoc18.December;

public class Twelfth implements December {
  @Override
  public String firstChallenge(String input) {
    return "" + Plantation.from(input).applyGenerations(20);
  }

  @Override
  public String secondChallenge(String input) {
    return "" + Plantation.from(input).applyGenerations(50_000_000_000L);
  }
}
