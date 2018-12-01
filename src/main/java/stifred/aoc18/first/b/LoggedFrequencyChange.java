package stifred.aoc18.first.b;

import stifred.aoc18.first.a.Frequency;
import stifred.aoc18.first.a.FrequencyChange;
import stifred.aoc18.first.a.SimpleFrequencyChange;

public class LoggedFrequencyChange implements FrequencyChange {
  private final SimpleFrequencyChange delegate;
  private FrequencyLogger logger;

  public LoggedFrequencyChange(SimpleFrequencyChange delegate, FrequencyLogger logger) {
    this.delegate = delegate;
    this.logger = logger;
  }

  @Override
  public Frequency applyOn(Frequency frequency) {
    Frequency newFrequency = delegate.applyOn(frequency);
    logger.logFrequency(newFrequency);
    return newFrequency;
  }
}
