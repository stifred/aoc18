package stifred.aoc18.fourth.a;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogEntry {
  private static final DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  private int guardId;
  private final LocalDateTime timestamp;
  private final String message;

  public LogEntry(int guardId, LocalDateTime timestamp, String message) {
    this.guardId = guardId;
    this.timestamp = timestamp;
    this.message = message;
  }

  public int getGuardId() {
    return guardId;
  }

  public int type() {
    if (message.contains("begins")) {
      return 0;
    } else if (message.contains("falls")) {
      return 1;
    } else {
      return 2;
    }
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public String getMessage() {
    return message;
  }

  public LogEntry setGuardId(int guardId) {
    this.guardId = guardId;
    return this;
  }

  public static LogEntry fromString(String string) {
    String timeSubstring = string.substring(1, 17);
    String message = string.substring(19);
    int guardId = -1;

    if (message.contains("#")) {
      String afterHash = message.substring(message.indexOf("#") + 1);
      String idStr = afterHash.split(" ")[0];
      guardId = Integer.parseInt(idStr);
    }

    return new LogEntry(guardId, LocalDateTime.parse(timeSubstring, formatter), message);
  }
}
