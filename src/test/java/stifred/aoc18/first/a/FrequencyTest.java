package stifred.aoc18.first.a;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrequencyTest {
  @Test
  public void testApply() {
    Frequency frequency = new Frequency(10);
    FrequencyChange frequencyChange = new SimpleFrequencyChange(-15);

    Frequency newFrequency = frequency.apply(frequencyChange);

    assertEquals(-5, newFrequency.value());
  }
}