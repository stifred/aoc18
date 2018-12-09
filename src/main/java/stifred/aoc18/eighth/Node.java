package stifred.aoc18.eighth;

import java.util.ArrayList;
import java.util.List;

class Node {
  private final List<Node> children = new ArrayList<>();
  private final List<Integer> metadata = new ArrayList<>();
  private final int childCount;
  private final int metaCount;
  private Node parent;

  Node(int childCount, int metaCount) {
    this.childCount = childCount;
    this.metaCount = metaCount;
  }

  Node parent() {
    return parent;
  }

  boolean acceptsChild() {
    return children.size() < childCount;
  }

  boolean acceptsMeta() {
    return metadata.size() < metaCount;
  }

  void addChild(Node child) {
    child.parent = this;
    children.add(child);
  }

  void addMeta(int meta) {
    metadata.add(meta);
  }

  int metadataSum() {
    int sum = 0;
    for (int metaValue : metadata) {
      sum += metaValue;
    }

    for (Node child : children) {
      sum += child.metadataSum();
    }

    return sum;
  }

  int weirdMetadataSum() {
    if (children.isEmpty()) {
      return metadataSum();
    }

    int sum = 0;
    for (int metaValue : metadata) {
      if (childCount >= metaValue)
      sum += children.get(metaValue - 1).weirdMetadataSum();
    }

    return sum;
  }
}
