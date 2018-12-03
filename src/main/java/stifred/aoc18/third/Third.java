package stifred.aoc18.third;

import stifred.aoc18.December;
import stifred.aoc18.third.a.Claim;
import stifred.aoc18.third.a.Position;
import stifred.aoc18.third.b.PosCounter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Third implements December {
  @Override
  public String firstChallenge(String input) {
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

  @Override
  public String secondChallenge(String input) {
    PosCounter posCounter = new PosCounter();

    List<Claim> claims =
        Arrays.stream(input.split("\n")).map(Claim::from).collect(Collectors.toList());

    claims.stream().flatMap(claim -> claim.getPositions().stream()).forEach(posCounter::count);

    List<Position> single = posCounter.findSingleClaimed();

    Optional<Claim> claim = claims.stream().filter(cl -> cl.containsOnlyPositionWithin(single)).findFirst();
    if (claim.isEmpty()) {
      return "claim not found";
    }

    return Integer.toString(claim.get().getId());
  }
}
