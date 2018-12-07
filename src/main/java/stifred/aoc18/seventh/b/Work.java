package stifred.aoc18.seventh.b;

import stifred.aoc18.seventh.a.InstructionSet;

public class Work {
  private final InstructionSet set;
  private final int expiresAt;

  public Work(InstructionSet set, int start, int offset) {
    this.set = set;
    this.expiresAt = start + set.getTime(offset);
  }

  public InstructionSet getSet() {
    return set;
  }

  public int getExpiresAt() {
    return expiresAt;
  }
}
