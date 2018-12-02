package stifred.aoc18.second;

import stifred.aoc18.December;
import stifred.aoc18.second.a.BoxId;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Second implements December {
  @Override
  public String firstChallenge(String input) {
    List<BoxId> boxIds =
        Arrays.stream(input.split("\n")).map(BoxId::new).collect(Collectors.toList());

    long twoCount = boxIds.stream().filter(boxId -> boxId.hasDuplicates(2)).count();
    long threeCount = boxIds.stream().filter(boxId -> boxId.hasDuplicates(3)).count();

    return Long.toString(twoCount * threeCount);
  }

  @Override
  public String secondChallenge(String input) {
    List<BoxId> boxIds =
        Arrays.stream(input.split("\n")).map(BoxId::new).collect(Collectors.toList());

    Optional<BoxId> theMatch =
        boxIds
            .stream()
            .map(boxId -> boxId.findMatchIn(boxIds))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .findFirst();

    if (theMatch.isEmpty()) {
      return "";
    }

    return theMatch.get().toString();
  }
}
