package stifred.aoc18.fourth;

import stifred.aoc18.December;
import stifred.aoc18.fourth.a.LogEntry;
import stifred.aoc18.fourth.a.ShiftCounter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fourth implements December {

  @Override
  public String firstChallenge(String input) {
    List<LogEntry> logs =
        Arrays.stream(input.split("\n"))
            .map(LogEntry::fromString)
            .sorted(Comparator.comparing(LogEntry::getTimestamp).thenComparing(LogEntry::type))
            .collect(Collectors.toList());

    int guardId = -1;
    for (var log : logs) {
      if (log.getGuardId() != -1) {
        guardId = log.getGuardId();
      } else {
        log.setGuardId(guardId);
      }
    }

    ShiftCounter shiftCounter = new ShiftCounter();
    shiftCounter.countFor(logs);
    int lazyId = shiftCounter.getSleepiestGuard();
    int lazyMinute = shiftCounter.findSleepiestMinute(lazyId, logs);

    return Integer.toString(lazyId * lazyMinute);
  }

  @Override
  public String secondChallenge(String input) {
    return null;
  }
}
