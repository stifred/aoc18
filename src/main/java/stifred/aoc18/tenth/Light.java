package stifred.aoc18.tenth;

class Light {
  private final Point position;
  private final Point velocity;

  Light(Point position, Point velocity) {
    this.position = position;
    this.velocity = velocity;
  }

  Point positionAt(int seconds) {
    return new Point(
        position.getX() + (seconds * velocity.getX()),
        position.getY() + (seconds * velocity.getY()));
  }

  static Light from(String string) {
    int index1a = string.indexOf("<") + 1;
    int index1b = string.indexOf(">");
    String subStr1 = string.substring(index1a, index1b);

    int index2a = string.lastIndexOf("<") + 1;
    int index2b = string.lastIndexOf(">");
    String subStr2 = string.substring(index2a, index2b);

    return new Light(Point.from(subStr1), Point.from(subStr2));
  }
}
