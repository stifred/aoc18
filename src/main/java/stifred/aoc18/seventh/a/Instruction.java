package stifred.aoc18.seventh.a;

public class Instruction {
  private String required;
  private final String theStep;

  public Instruction(String required, String theStep) {
    this.required = required;
    this.theStep = theStep;
  }

  public String getRequired() {
    return required;
  }

  public String getTheStep() {
    return theStep;
  }

  public void voidRequirement() {
    required = "";
  }

  public static Instruction from(String string) {
    return new Instruction(string.substring(5, 6), string.substring(36, 37));
  }
}
