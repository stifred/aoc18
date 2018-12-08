package stifred.aoc18.seventh;

import stifred.aoc18.December;
import stifred.aoc18.seventh.a.Instruction;
import stifred.aoc18.seventh.a.InstructionSet;
import stifred.aoc18.seventh.b.Work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Seventh implements December {
  int offset = 60;
  int workerCount = 5;

  @Override
  public String firstChallenge(String input) {
    List<InstructionSet> sets = inputToSet(input);

    List<String> steps = new ArrayList<>();
    while (!sets.isEmpty()) {
      InstructionSet found = null;

      for (var iSet : sets) {
        if (iSet.isReady()) {
          found = iSet;
          break;
        }
      }

      if (found != null) {
        String step = found.getTheStep();
        steps.add(step);
        sets.remove(found);
        sets.forEach(iSet -> iSet.removeDependency(step));
      }
    }

    return String.join("", steps);
  }

  @Override
  public String secondChallenge(String input) {
    List<InstructionSet> sets = inputToSet(input);

    int timePassed = 0;
    List<Work> works = new ArrayList<>();
    while (!sets.isEmpty()) {
      timePassed = works.stream().mapToInt(Work::getExpiresAt).min().orElse(timePassed);

      final int currentTime = timePassed;
      works.stream().filter(w -> w.getExpiresAt() <= currentTime).collect(Collectors.toList())
          .forEach(done -> {
            {
              InstructionSet doneSet = done.getSet();
              String step = doneSet.getTheStep();
              sets.remove(doneSet);
              sets.forEach(iSet -> iSet.removeDependency(step));
              works.remove(done);
            }
          });

      if (works.size() < workerCount) {
        for (var iSet : sets) {
          if (iSet.isReady()) {
            works.add(new Work(iSet.start(), timePassed, offset));

            if (works.size() == workerCount) {
              break;
            }
          }
        }
      }
    }

    return Integer.toString(timePassed);
  }

  private List<InstructionSet> inputToSet(String input) {
    List<Instruction> instructions =
        Arrays.stream(input.split("\n")).map(Instruction::from).collect(Collectors.toList());

    Set<String> letters = new HashSet<>();
    instructions.stream().map(Instruction::getRequired).forEach(letters::add);
    instructions.stream().map(Instruction::getTheStep).forEach(letters::add);

    List<InstructionSet> sets = new ArrayList<>();
    for (String letter : letters) {
      InstructionSet iSet = new InstructionSet(letter);
      instructions
          .stream()
          .filter(i -> i.getTheStep().equals(letter))
          .map(Instruction::getRequired)
          .forEach(iSet::addDependency);

      sets.add(iSet);
    }

    return sets;
  }
}
