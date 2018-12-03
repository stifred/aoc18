package stifred.aoc18.third.b;

import stifred.aoc18.third.a.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PosCounter {
  private Map<Position, Integer> counts = new HashMap<>();

  public void count(Position position) {
    if (counts.containsKey(position)) {
      counts.put(position, counts.get(position) + 1);
    } else {
      counts.put(position, 1);
    }
  }

  public List<Position> findSingleClaimed() {
    return counts
        .entrySet()
        .stream()
        .filter(e -> e.getValue() == 1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }
}
