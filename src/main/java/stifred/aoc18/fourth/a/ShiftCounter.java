package stifred.aoc18.fourth.a;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShiftCounter {
  private Map<Integer, Integer> counts = new HashMap<>();

  public int getSleepiestGuard() {
    return counts
        .entrySet()
        .stream()
        .filter(e -> e.getKey() != -1)
        .max(Comparator.comparing(Map.Entry::getValue))
        .map(Map.Entry::getKey)
        .orElse(-300);
  }

  public int findSleepiestMinute(int guardId, List<LogEntry> logEntries) {
    var filtered =
        logEntries.stream().filter(l -> l.getGuardId() == guardId).collect(Collectors.toList());

    Map<Integer, Integer> minCounts = new HashMap<>();
    LocalDateTime time = null;
    for (var log : filtered) {
      if (time == null) {
        time = log.getTimestamp();
      } else {
        int startMinute = time.getMinute();
        int endMinute = log.getTimestamp().getMinute();

        for (var i = startMinute; i < endMinute; i++) {
          minCounts.put(i, minCounts.getOrDefault(i, 0) + 1);
        }

        time = null;
      }
    }

    return minCounts
        .entrySet()
        .stream()
        .max(Comparator.comparing(Map.Entry::getValue))
        .map(Map.Entry::getValue)
        .orElse(-1);
  }

  public void countFor(List<LogEntry> logEntries) {
    int guardId = -1;
    LocalDateTime time = null;

    for (LogEntry log : logEntries) {
      if (log.getMessage().contains("falls")) {
        guardId = log.getGuardId();
        time = log.getTimestamp();
      } else if (time != null) {
        Duration period = Duration.between(time, log.getTimestamp());
        counts.put(guardId, counts.getOrDefault(guardId, 0) + (int) period.toMinutes());

        time = null;
        guardId = -1;
      }
    }
  }
}
