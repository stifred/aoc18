package stifred.aoc18.ninth;

class Player {
  private int score = 0;
  private Player next;

  Player() {
    this.next = this;
  }

  private Player(Player next) {
    this.next = next;
  }

  void addNext() {
    this.next = new Player(this.next);
  }

  Player next() {
    return this.next;
  }

  void addScore(int points) {
    this.score += points;
  }

  int findMaxScore() {
    Player player = this;
    int record = 0;

    do {
      if (player.score > record) {
        record = player.score;
      }
      player = player.next;
    } while (player != this);

    return record;
  }
}
