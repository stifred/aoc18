package stifred.aoc18.fourth.a;

import stifred.aoc18.fourth.b.SleepyMinute;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

  public SleepyMinute findSleepiestMinute(int guardId, List<LogEntry> logEntries) {
    var filtered =
        logEntries.stream().filter(l -> l.getGuardId() == guardId).collect(Collectors.toList());

    Map<Integer, Integer> minCounts = new HashMap<>();
    LocalDateTime time = null;
    for (var log : filtered) {
      if (log.type() == 1) {
        time = log.getTimestamp();
      } else if (log.type() == 2 && time != null) {
        int startMinute = time.getMinute();
        int endMinute = log.getTimestamp().getMinute();

        if (startMinute > endMinute) {
          continue;
        }

        for (int i = startMinute; i < endMinute; i++) {
          minCounts.put(i, minCounts.getOrDefault(i, 0) + 1);
        }

        time = null;
      }
    }

    return minCounts
        .entrySet()
        .stream()
        .max(Comparator.comparing(Map.Entry::getValue))
        .map(e -> new SleepyMinute(guardId, e.getKey(), e.getValue()))
        .orElse(null);
  }

  public SleepyMinute findMostFrequentlySleptThroughMinute(List<LogEntry> logEntries) {
    SleepyMinute sm = new SleepyMinute();

    Set<Integer> guardIds =
        logEntries
            .stream()
            .map(LogEntry::getGuardId)
            .collect(Collectors.toSet());

    for (int guardId : guardIds) {
      sm.updateIfBetter(findSleepiestMinute(guardId, logEntries));
    }

    return sm;
  }

  public void countFor(List<LogEntry> logEntries) {
    Map<Integer, LocalDateTime> times = new HashMap<>();
    for (LogEntry log : logEntries) {
      if (log.type() == 1) {
        times.put(log.getGuardId(), log.getTimestamp());
      } else if (log.type() == 2 && times.containsKey(log.getGuardId())) {
        Duration period = Duration.between(times.get(log.getGuardId()), log.getTimestamp());
        counts.put(log.getGuardId(), counts.getOrDefault(log.getGuardId(), 0) + (int) period.toMinutes());

        times.remove(log.getGuardId());
      }
    }
  }
}
