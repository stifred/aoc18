package stifred.aoc18.twelft;

import stifred.aoc18.December;

public class Twelft implements December {
  @Override
  public String firstChallenge(String input) {
    return "" + Plantation.from(input).applyGenerations(20);
  }

  @Override
  public String secondChallenge(String input) {
    return null;
  }
}
