package stifred.aoc18.ninth;

import java.util.HashMap;
import java.util.Map;

class MarbleGame {
  private final int playerCount;
  private int lastMarble;
  private Marble currentMarble = new Marble(0);

  MarbleGame(int playerCount, int lastMarble) {
    this.playerCount = playerCount;
    this.lastMarble = lastMarble;
  }

  long play() {
    return play(1);
  }

  long play(int multiplier) {
    Map<Integer, Long> scores = new HashMap<>();

    int playerIndex = 0;
    lastMarble = multiplier * lastMarble;
    for (int currentMarble = 1; currentMarble <= lastMarble; currentMarble++) {
      int returned = insertMarble(currentMarble);
      if (returned > 0) {
        scores.put(playerIndex, scores.getOrDefault(playerIndex, 0L) + returned);
      }

      playerIndex++;
      if (playerIndex >= playerCount) {
        playerIndex = 0;
      }
    }

    return scores.entrySet().stream().mapToLong(Map.Entry::getValue).max().orElse(0L);
  }

  private int insertMarble(Integer newMarble) {
    if (newMarble > 0 && newMarble % 23 == 0) {
      Marble otherMarble = currentMarble.left(7);
      currentMarble = otherMarble.right(1);
      return newMarble + otherMarble.pop();
    } else {
      currentMarble = currentMarble.right(1).addRight(newMarble);
    }

    return 0;
  }
}
