package stifred.aoc18.first.a;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleFrequencyChangeTest {
  @Test
  public void testApplyOn() {
    Frequency frequency = new Frequency(10);
    FrequencyChange frequencyChange = new SimpleFrequencyChange(15);

    Frequency newFrequency = frequencyChange.applyOn(frequency);

    assertEquals(25, newFrequency.value());
  }
}
