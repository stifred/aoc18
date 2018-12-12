package stifred.aoc18;

import stifred.aoc18.eighth.Eighth;
import stifred.aoc18.eleventh.Eleventh;
import stifred.aoc18.fifth.Fifth;
import stifred.aoc18.firstkt.KotlinFirst;
import stifred.aoc18.fourth.Fourth;
import stifred.aoc18.ninth.Ninth;
import stifred.aoc18.second.Second;
import stifred.aoc18.seventh.Seventh;
import stifred.aoc18.sixth.Sixth;
import stifred.aoc18.tenth.Tenth;
import stifred.aoc18.third.Third;
import stifred.aoc18.twelft.Twelft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  private static final List<December> SOLUTIONS =
      List.of(
          new KotlinFirst(),
          new Second(),
          new Third(),
          new Fourth(),
          new Fifth(),
          new Sixth(),
          new Seventh(),
          new Eighth(),
          new Ninth(),
          new Tenth(),
          new Eleventh(),
          new Twelft());

  public static void main(String... args) {
    int dayOfMonth = LocalDate.now().getDayOfMonth();
    int repetitions = 1;

    try {
      for (var suffix : List.of("a", "b")) {
        December dec = SOLUTIONS.get(dayOfMonth - 1);

        String fileName = dec.fileName(dayOfMonth, suffix);
        String input = readFile(fileName);

        boolean isFirst = "a".equals(suffix);

        Instant start = Instant.now();
        String output = "";
        if (isFirst) {
          for (int i = 0; i < repetitions; i++) {
            output = dec.firstChallenge(input);
          }
        } else {
          for (int i = 0; i < repetitions; i++) {
            output = dec.secondChallenge(input);
          }
        }
        Duration duration = Duration.between(start, Instant.now());

        System.out.printf("%d%s\n------\n", dayOfMonth, suffix);
        System.out.printf("%s\n------\n", output);
        System.out.printf("%s\n\n", renderDuration(duration, repetitions));
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

  private static String renderDuration(Duration duration, int repetitions) {
    if (duration.toMillis() > repetitions * 10_000) {
      return (duration.toSeconds() / repetitions) + " s";
    } else if (duration.toMillis() > repetitions * 50) {
      return (duration.toMillis() / repetitions) + " ms";
    } else {
      return (duration.toNanos() / (repetitions * 1_000)) + " µs";
    }
  }
}
