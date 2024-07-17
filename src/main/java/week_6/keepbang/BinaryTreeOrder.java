package week_6.keepbang;

public class BinaryTreeOrder {

  public static void main(String[] args) {
    BinaryTree root = new BinaryTree(1);
    root.left = new BinaryTree(2, new BinaryTree(4), new BinaryTree(5));
    root.right = new BinaryTree(3, new BinaryTree(6), new BinaryTree(7));

    BinaryTreeOrder order = new BinaryTreeOrder();

    System.out.println("preorder");
    order.preorder(root);
    System.out.println();

    System.out.println("inorder");
    order.inorder(root);
    System.out.println();

    System.out.println("postorder");
    order.postorder(root);

  }

  public void preorder(BinaryTree n) {
    if (n == null) {
      return;
    }
    visit(n);
    preorder(n.left);
    preorder(n.right);
  }

  public void inorder(BinaryTree n) {
    if (n == null) {
      return;
    }
    inorder(n.left);
    visit(n);
    inorder(n.right);
  }

  public void postorder(BinaryTree n) {
    if (n == null) {
      return;
    }
    postorder(n.left);
    postorder(n.right);
    visit(n);
  }

  void visit(BinaryTree n) {
    if (n == null) {return;}
    System.out.print(" " + n.val);
  }
}
