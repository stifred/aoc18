package stifred.aoc18.seventh;

import stifred.aoc18.December;
import stifred.aoc18.seventh.a.Instruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Seventh implements December {
  @Override
  public String firstChallenge(String input) {
    List<Instruction> instructions =
        Arrays.stream(input.split("\n")).map(Instruction::from).collect(Collectors.toList());

    Set<String> letters = new HashSet<>();
    instructions.stream().map(Instruction::getRequired).forEach(letters::add);
    instructions.stream().map(Instruction::getTheStep).forEach(letters::add);

    List<String> steps = new ArrayList<>();
    List<Instruction> remaining = new ArrayList<>(instructions);
    while (!remaining.isEmpty()) {
      Set<String> requires =
          remaining
              .stream()
              .map(Instruction::getRequired)
              .filter(s -> !s.isEmpty())
              .collect(Collectors.toSet());
      Set<String> mySteps =
          remaining.stream().map(Instruction::getTheStep).collect(Collectors.toSet());

      Set<String> available =
          requires.stream().filter(step -> !mySteps.contains(step)).collect(Collectors.toSet());

      boolean next = true;
      for (var step : available) {
        if (!next) {
          break;
        }
        next = false;

        steps.add(step);
        remaining =
            remaining
                .stream()
                .filter(s -> !s.getTheStep().equals(step))
                .collect(Collectors.toList());
      }
    }

    letters.stream().filter(letter -> !steps.contains(letter)).forEach(steps::add);

    return String.join("", steps);
  }

  @Override
  public String secondChallenge(String input) {
    return null;
  }
}
