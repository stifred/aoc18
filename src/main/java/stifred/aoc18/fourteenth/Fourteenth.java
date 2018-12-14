package stifred.aoc18.fourteenth;

import stifred.aoc18.December;

public class Fourteenth implements December {
  @Override
  public String firstChallenge(String input) {
    return null;
    //return new ElvenWorkforce().doWork(Integer.parseInt(input));
  }

  @Override
  public String secondChallenge(String input) {
    return new ElvenWorkforce().doOtherWork(input);
  }
}
