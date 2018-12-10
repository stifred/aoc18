package stifred.aoc18.ninth;

class MarbleGame {
  private final int playerCount;
  private int lastMarble;
  private Marble currentMarble = new Marble(0);

  MarbleGame(int playerCount, int lastMarble) {
    this(playerCount, lastMarble, 1);
  }

  MarbleGame(int playerCount, int lastMarble, int multiplier) {
    this.playerCount = playerCount;
    this.lastMarble = lastMarble * multiplier;
  }

  long play() {
    Player first = new Player();
    for (int i = 1; i < playerCount; i++) {
      first.addNext();
    }

    Player currentPlayer = first;
    for (int currentMarble = 1; currentMarble <= lastMarble; currentMarble++) {
      int returned = insertMarble(currentMarble);
      if (returned > 0) {
        currentPlayer.addScore(returned);
      }

      currentPlayer = currentPlayer.next();
    }

    return currentPlayer.findMaxScore();
  }

  private int insertMarble(Integer newMarble) {
    if (newMarble % 23 == 0) {
      Marble otherMarble = currentMarble.left(7);
      currentMarble = otherMarble.right(1);
      return newMarble + otherMarble.pop();
    } else {
      currentMarble = currentMarble.right(1).addRight(newMarble);
    }

    return 0;
  }
}
