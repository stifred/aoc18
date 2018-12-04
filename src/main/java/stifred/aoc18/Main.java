package stifred.aoc18;

import stifred.aoc18.firstkt.KotlinFirst;
import stifred.aoc18.fourth.Fourth;
import stifred.aoc18.second.Second;
import stifred.aoc18.third.Third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  private static final int dayOfMonth = LocalDate.now().getDayOfMonth();

  private static final Map<Integer, December> map =
      Map.of(1, new KotlinFirst(), 2, new Second(), 3, new Third(), 4, new Fourth());

  public static void main(String... args) {
    try {
      for (var suffix : List.of("a", "b")) {
        String fileName = String.format("/input-%d%s.txt", dayOfMonth, suffix);
        String input = readFile(fileName);

        December dec = map.get(dayOfMonth);

        String output = "a".equals(suffix) ? dec.firstChallenge(input) : dec.secondChallenge(input);

        System.out.printf("%d%s\n------%n", dayOfMonth, suffix);
        System.out.printf("%s\n------\n\n%n", output);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static String readFile(String fileName) throws NullPointerException, IOException {
    try (var is =
        new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream(fileName)))) {
      return is.lines().collect(Collectors.joining("\n"));
    }
  }
}
