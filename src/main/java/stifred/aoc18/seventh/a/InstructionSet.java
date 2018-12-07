package stifred.aoc18.seventh.a;

import java.util.HashSet;
import java.util.Set;

public class InstructionSet {
  private final String theStep;
  private final Set<String> dependencies = new HashSet<>();
  private boolean busy;

  public InstructionSet(String theStep) {
    this.theStep = theStep;
  }

  public String getTheStep() {
    return theStep;
  }

  public void addDependency(String dep) {
    dependencies.add(dep);
  }

  public void removeDependency(String dep) {
    dependencies.remove(dep);
  }

  public InstructionSet start() {
    busy = true;
    return this;
  }

  public boolean isReady() {
    return !busy && dependencies.isEmpty();
  }

  public int getTime(int offset) {
    char chara = theStep.toCharArray()[0];
    return offset + (chara + ((char)1) - 'A');
  }

  @Override
  public int hashCode() {
    return theStep.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof InstructionSet && ((InstructionSet) obj).theStep.equals(theStep);
  }
}
