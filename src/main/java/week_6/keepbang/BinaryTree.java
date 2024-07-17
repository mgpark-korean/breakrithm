package week_6.keepbang;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

  public int val;
  public BinaryTree left;
  public BinaryTree right;
  public BinaryTree parent;

  BinaryTree() {
  }

  BinaryTree(int val) {
    this.val = val;
  }

  BinaryTree(int val, BinaryTree left, BinaryTree right) {
    this.val = val;
    this.left = left;
    this.left.parent = this;
    this.right = right;
    this.right.parent = this;
  }

  public int move_to_left_child(int i) {
    return i * 2;
  }

  public int move_to_right_child(int i) {
    return i * 2 + 1;
  }

  public int move_to_parent(int i) {
    return i / 2;
  }

  public void print() {
    List<List<String>> levels = new ArrayList<>();
    traverse(this, 0, levels);

    for (int i = 0; i < levels.size() - 1; i++) {
      System.out.print((i + 1) + " : ");
      System.out.println(String.join("-", levels.get(i)));
    }
  }

  private void traverse(BinaryTree node, int level, List<List<String>> levels) {
    if (levels.size() == level) {
      levels.add(new ArrayList<>());
    }

    if (node == null) {

      if (levels.size() > level) {
        levels.get(level).add("null");
      }
      return;
    }


    levels.get(level).add(String.valueOf(node.val));
    traverse(node.left, level + 1, levels);
    traverse(node.right, level + 1, levels);
  }

  public void addLeft(int x) {
    this.left = new BinaryTree(x);
    this.left.parent = this;
  }

  public void addRight(int x) {
    this.right = new BinaryTree(x);
    this.right.parent = this;
  }
}
