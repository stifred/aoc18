package stifred.aoc18.first.a;

public class Frequency implements FrequencyChange {
  private final int value;

  public Frequency(int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }

  public Frequency apply(FrequencyChange frequencyChange) {
    return frequencyChange.applyOn(this);
  }

  @Override
  public int hashCode() {
    return Integer.hashCode(value);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Frequency && ((Frequency) obj).value() == this.value;
  }

  @Override
  public String toString() {
    return Integer.toString(value);
  }

  @Override
  public Frequency applyOn(Frequency frequency) {
    return new Frequency(frequency.value() + this.value);
  }
}
