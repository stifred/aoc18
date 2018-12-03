package stifred.aoc18.third.a;

import java.util.ArrayList;
import java.util.List;

public class Claim {
  private final int id;
  private final List<Position> positions;

  private Claim(int id, List<Position> positions) {
    this.id = id;
    this.positions = positions;
  }

  public int getId() {
    return id;
  }

  public List<Position> getPositions() {
    return positions;
  }

  public boolean containsOnlyPositionWithin(List<Position> checkPositions) {
    for (Position position : positions) {
      if (!checkPositions.contains(position)) {
        return false;
      }
    }

    return true;
  }

  public static Claim from(String string) {
    String[] parts =
        string
            .replace("#", "")
            .replace(":", "")
            .replace(",", " ")
            .replace("@ ", "")
            .replace("x", " ")
            .split(" ");

    int id = Integer.parseInt(parts[0]);
    int left = Integer.parseInt(parts[1]);
    int top = Integer.parseInt(parts[2]);
    int width = Integer.parseInt(parts[3]);
    int height = Integer.parseInt(parts[4]);

    List<Position> positions = new ArrayList<>();
    for (int x = left; x < left + width; x++) {
      for (int y = top; y < top + height; y++) {
        positions.add(new Position(x, y));
      }
    }

    return new Claim(id, positions);
  }
}
