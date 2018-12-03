package stifred.aoc18.third;

import stifred.aoc18.December;
import stifred.aoc18.third.a.Claim;
import stifred.aoc18.third.a.Position;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Third implements December {
  @Override public String firstChallenge(String input) {
    Set<Position> positions = new HashSet<>();

    Set<String> overlaps =
        Arrays.stream(input.split("\n"))
            .map(Claim::from)
            .flatMap(claim -> claim.getPositions().stream())
            .filter(position -> !positions.add(position))
            .map(Position::toString)
            .collect(Collectors.toSet());

    return Integer.toString(overlaps.size());
  }

  @Override public String secondChallenge(String input) {
    return null;
  }
}
