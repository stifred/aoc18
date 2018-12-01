package stifred.aoc18.first.a;

public class SimpleFrequencyChange implements FrequencyChange {
  private final int value;

  public SimpleFrequencyChange(int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }

  @Override
  public Frequency applyOn(Frequency frequency) {
    return new Frequency(frequency.value() + this.value());
  }

  public static SimpleFrequencyChange fromString(String string) {
    if (string.isEmpty()) {
      return new SimpleFrequencyChange(0);
    }

    return new SimpleFrequencyChange(Integer.parseInt(string));
  }
}
