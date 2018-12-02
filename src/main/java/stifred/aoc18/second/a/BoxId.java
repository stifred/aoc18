package stifred.aoc18.second.a;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BoxId {
  private String value;

  public BoxId(String value) {
    this.value = value;
  }

  public boolean hasDuplicates(int number) {
    return Arrays.stream(value.split(""))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .anyMatch(entry -> entry.getValue() == number);
  }

  public Optional<BoxId> findMatchIn(List<BoxId> others) {
    return others
        .stream()
        .filter(this::isCloseTo)
        .map(this::makeMatchWith)
        .findFirst();
  }

  private boolean isCloseTo(BoxId other) {
    return makeMatchWith(other).value.length() == this.value.length() - 1;
  }

  private BoxId makeMatchWith(BoxId other) {
    StringBuilder match = new StringBuilder();

    String[] thisAsArray = this.value.split("");
    String[] otherAsArray = other.value.split("");
    for (int i = 0; i < thisAsArray.length; i++) {
      if (!thisAsArray[i].equals("") && thisAsArray[i].equals(otherAsArray[i])) {
        match.append(thisAsArray[i]);
      }
    }

    return new BoxId(match.toString());
  }

  @Override
  public String toString() {
    return value;
  }
}
