package stifred.aoc18.eighth.a;

import java.util.ArrayList;
import java.util.List;

public class Node {
  private final List<Node> children = new ArrayList<>();
  private final List<Integer> metadata = new ArrayList<>();
  private final int childCount;
  private final int metaCount;
  private Node parent;

  public Node(int childCount, int metaCount) {
    this.childCount = childCount;
    this.metaCount = metaCount;
  }

  public Node parent() {
    return parent;
  }

  public boolean acceptsChild() {
    return children.size() < childCount;
  }

  public boolean acceptsMeta() {
    return metadata.size() < metaCount;
  }

  public void addChild(Node child) {
    child.parent = this;
    children.add(child);
  }

  public void addMeta(int meta) {
    metadata.add(meta);
  }

  public int metadataSum() {
    int sum = 0;
    for (int metaValue : metadata) {
      sum += metaValue;
    }

    for (Node child : children) {
      sum += child.metadataSum();
    }

    return sum;
  }

  public int weirdMetadataSum() {
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
