package stifred.aoc18.first;

import stifred.aoc18.December;
import stifred.aoc18.first.a.Frequency;
import stifred.aoc18.first.a.FrequencyChange;
import stifred.aoc18.first.a.SimpleFrequencyChange;
import stifred.aoc18.first.b.FrequencyLogger;
import stifred.aoc18.first.b.LoggedFrequencyChange;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class First implements December {
  @Override
  public String firstChallenge(String input) {
    return Arrays.stream(input.split("\n"))
        .map(SimpleFrequencyChange::fromString)
        .reduce(new Frequency(0), Frequency::apply, Frequency::apply)
        .toString();
  }

  @Override
  public String secondChallenge(String input) {
    FrequencyLogger logger = new FrequencyLogger();

    List<FrequencyChange> changes =
        Arrays.stream(input.split("\n"))
            .map(SimpleFrequencyChange::fromString)
            .map(sfc -> new LoggedFrequencyChange(sfc, logger))
            .collect(Collectors.toList());

    Frequency frequency = new Frequency(0);

    while (!logger.hasDuplicate()) {
      for (var frequencyChange : changes) {
        frequency = frequency.apply(frequencyChange);
      }
    }

    return logger.firstDuplicate().toString();
  }
}
