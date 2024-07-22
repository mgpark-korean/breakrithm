package week_6.mgpark;

import org.w3c.dom.Node;

public class BinarySearchTree {

  public static void main(String[] args) {
    traverse();

  }

  public static void traverse() {
    int[] bst = {-1, 1, 2, 3, -1, 5, 6, 7, -1, -1, 4, -1, -1, 8, -1, -1};
    System.out.println("전위 탐색 시작..");
    preOrderTraversal(bst, 1);
    System.out.println("");
    System.out.println("전위 탐색 종료..");

    System.out.println("중위 탐색 시작....");
    inOrderTraversal(bst, 1);
    System.out.println("");
    System.out.println("중위 탐색 종료....");

    System.out.println("후위 탐색 시작....");
    postOrderTraversal(bst, 1);
    System.out.println("");
    System.out.println("후위 탐색 종료.....");
  }

  /**
   * 전위 탐색(루트 -> 왼 -> 오).
   */
  public static void preOrderTraversal(int[] tree, int currentCursor) {
    if(currentCursor <= tree.length - 1 && tree[currentCursor] > 0) {
      visit(tree[currentCursor]);
      preOrderTraversal(tree, getLeftCursor(currentCursor));
      preOrderTraversal(tree, getRightCursor(currentCursor));
    }
  }

  /**
   * 중위 탐색(왼 -> 루트 -> 오).
   */
  public static void inOrderTraversal(int[] tree, int currentCursor) {
    if(currentCursor <= tree.length - 1 && tree[currentCursor] > 0) {
      inOrderTraversal(tree, getLeftCursor(currentCursor));
      visit(tree[currentCursor]);
      inOrderTraversal(tree, getRightCursor(currentCursor));
    }
  }

  /**
   * 후위 탐색(왼 -> 오 -> 루트)
   */
  public static void postOrderTraversal(int[] tree, int currentCursor) {
    if(currentCursor <= tree.length - 1 && tree[currentCursor] > 0) {
      postOrderTraversal(tree, getLeftCursor(currentCursor));
      postOrderTraversal(tree, getRightCursor(currentCursor));
      visit(tree[currentCursor]);
    }
  }

  private static int getLeftCursor(int cursor) {
    return cursor * 2;
  }

  private static int getRightCursor(int cursor) {
    return cursor * 2 + 1;
  }

  private static void visit(int nodeValue) {
    System.out.print(nodeValue + " ");
  }

  private static class TreeNode<T> {

    T nodeValue;

    TreeNode<T> leftChild;
    TreeNode<T> rightChild;

    public TreeNode(T nodeValue) {
      this.nodeValue = nodeValue;
    }

    public T getNodeValue() {
      return nodeValue;
    }

    public TreeNode<T> getLeftChild() {
      return leftChild;
    }

    public TreeNode<T> getRightChild() {
      return rightChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
      this.leftChild = leftChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
      this.rightChild = rightChild;
    }


  }
}
