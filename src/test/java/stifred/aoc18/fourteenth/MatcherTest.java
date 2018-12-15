package stifred.aoc18.fourteenth;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MatcherTest {
  @Test
  public void testFirst() {
    List<Integer> numbers = List.of(3, 7, 1, 0, 1, 0, 1, 2, 4, 5, 1, 5, 8, 9, 1, 6, 7, 7, 9, 2);
    Matcher matcher = new Matcher(List.of(5, 1, 5, 8, 9));

    int index = 0;
    while (!matcher.hasMatch()) {
      matcher.apply(index, numbers.get(index));
      index++;
    }

    assertEquals(9, matcher.index());
  }
}
