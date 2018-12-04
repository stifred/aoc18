package stifred.aoc18.fourth.b;

public class SleepyMinute {
  private int guardId = -100;
  private int minute = -100;
  private int count = 0;

  public SleepyMinute() {}

  public SleepyMinute(int guardId, int minute, int count) {
    this.guardId = guardId;
    this.minute = minute;
    this.count = count;
  }

  public void updateIfBetter(SleepyMinute other) {
    if (other == null) {
      return;
    }

    if (other.count > count) {
      guardId = other.guardId;
      minute = other.minute;
      count = other.count;
    }
  }

  public int product() {
    return guardId * minute;
  }
}
