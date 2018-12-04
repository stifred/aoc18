package stifred.aoc18.fourth.a;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static stifred.aoc18.fourth.Fourth.fixList;

public class ShiftCounterTest {
  private final ShiftCounter sc = new ShiftCounter();

  @Test
  public void testAll() {
    String str =
        "[1518-11-01 00:00] Guard #10 begins shift\n"
            + "[1518-11-01 00:05] falls asleep\n"
            + "[1518-11-01 00:25] wakes up\n"
            + "[1518-11-01 00:30] falls asleep\n"
            + "[1518-11-01 00:55] wakes up\n"
            + "[1518-11-01 23:58] Guard #99 begins shift\n"
            + "[1518-11-02 00:40] falls asleep\n"
            + "[1518-11-02 00:50] wakes up\n"
            + "[1518-11-03 00:05] Guard #10 begins shift\n"
            + "[1518-11-03 00:24] falls asleep\n"
            + "[1518-11-03 00:29] wakes up\n"
            + "[1518-11-04 00:02] Guard #99 begins shift\n"
            + "[1518-11-04 00:36] falls asleep\n"
            + "[1518-11-04 00:46] wakes up\n"
            + "[1518-11-05 00:03] Guard #99 begins shift\n"
            + "[1518-11-05 00:45] falls asleep\n"
            + "[1518-11-05 00:55] wakes up";
    String[] strs = str.split("\n");
    var list = Arrays.stream(strs).map(LogEntry::fromString).collect(Collectors.toList());

    fixList(list);
    sc.countFor(list);

    assertEquals(10, sc.getSleepiestGuard());
    assertEquals(240, sc.findSleepiestMinute(10, list).product());
  }
}
