package stifred.aoc18.first.b;

import stifred.aoc18.first.a.Frequency;

import java.util.HashSet;
import java.util.Set;

public class FrequencyLogger {
  private Frequency firstDuplicate = null;
  private final Set<Frequency> frequencies = new HashSet<>();

  public void logFrequency(Frequency newFrequency) {
    if (!frequencies.add(newFrequency) && !hasDuplicate()) {
      firstDuplicate = newFrequency;
    }
  }

  public boolean hasDuplicate() {
    return firstDuplicate != null;
  }

  public Frequency firstDuplicate() {
    return firstDuplicate;
  }
}
