package stifred.aoc18.eighth;

import stifred.aoc18.December;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Eighth implements December {
  private int searchIndex;
  private List<Integer> numbers;

  @Override
  public String firstChallenge(String input) {
    return Integer.toString(findMainNode(input).metadataSum());
  }

  @Override
  public String secondChallenge(String input) {
    return Integer.toString(findMainNode(input).weirdMetadataSum());
  }

  private Node findMainNode(String input) {
    reset(Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList()));

    Node main = new Node(readNext(), readNext());
    Node current = main;
    while (true) {
      if (current.acceptsChild()) {
        Node child = new Node(readNext(), readNext());
        current.addChild(child);
        current = child;
      } else {
        while (current.acceptsMeta()) {
          current.addMeta(readNext());
        }

        // Move up
        if (current == main) {
          return main;
        }
        current = current.parent();
      }
    }
  }

  private int readNext() {
    int val = numbers.get(searchIndex);
    searchIndex++;
    return val;
  }

  private void reset(List<Integer> numbers) {
    this.numbers = numbers;
    this.searchIndex = 0;
  }
}
