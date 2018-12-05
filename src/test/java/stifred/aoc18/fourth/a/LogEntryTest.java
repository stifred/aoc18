package stifred.aoc18.fourth.a;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class LogEntryTest {
  @Test
  public void testFromString() {
    String input1 = "[1518-11-02 00:50] wakes up";
    LogEntry logEntry1 = LogEntry.fromString(input1);
    assertEquals(-1, logEntry1.getGuardId());
    assertEquals(
        LocalDateTime.of(LocalDate.of(1518, 11, 2), LocalTime.of(0, 50, 0)),
        logEntry1.getTimestamp());
    assertEquals("wakes up", logEntry1.getMessage());

    String input2 = "[1518-11-02 00:50] Guard #643 begins shift";
    LogEntry logEntry2 = LogEntry.fromString(input2);
    assertEquals(643, logEntry2.getGuardId());
  }
}
