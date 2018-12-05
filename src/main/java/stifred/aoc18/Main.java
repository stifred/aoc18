package stifred.aoc18;

import stifred.aoc18.fifth.Fifth;
import stifred.aoc18.firstkt.KotlinFirst;
import stifred.aoc18.fourth.Fourth;
import stifred.aoc18.second.Second;
import stifred.aoc18.third.Third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  private static final Map<Integer, December> MAP =
      Map.of(
          1, new KotlinFirst(), 2, new Second(), 3, new Third(), 4, new Fourth(), 5, new Fifth());

  public static void main(String... args) {
    int dayOfMonth = LocalDate.now().getDayOfMonth();

    try {
      for (var suffix : List.of("a", "b")) {
        String fileName = String.format("/input-%d%s.txt", dayOfMonth, suffix);
        String input = readFile(fileName);

        December dec = MAP.get(dayOfMonth);

        Instant start = Instant.now();
        String output = "a".equals(suffix) ? dec.firstChallenge(input) : dec.secondChallenge(input);
        Duration duration = Duration.between(start, Instant.now());

        System.out.printf("%d%s\n------\n", dayOfMonth, suffix);
        System.out.printf("%s\n------\n", output);
        System.out.printf("%s ms\n\n", duration.toMillis());
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
