package stifred.aoc18.twelft;

import stifred.aoc18.December;

public class Twelft implements December {
  @Override
  public String firstChallenge(String input) {
    return "" + Plantation.from(input).applyGenerations(20);
  }

  @Override
  public String secondChallenge(String input) {
    long sum = Plantation.from(input).applyGenerations(3000);
    for (long i = 3000; i < 50_000_000_000L; i++) {
      sum += 52;
    }

    return "" + sum;
  }
}
