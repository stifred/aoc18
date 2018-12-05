package stifred.aoc18;

public interface December {
  /**
   * Run the first AOC challenge.
   *
   * @param input the string input
   * @return the string output
   */
  String firstChallenge(String input);

  /**
   * Run the second AOC challenge.
   *
   * @param input the string input
   * @return the string output
   */
  String secondChallenge(String input);

  /**
   * Fetch a file name.
   *
   * @param day The day
   * @param part (Ignored)
   * @return file name.
   */
  default String fileName(int day, String part) {
    return "/input-" + day + ".txt";
  }
}
