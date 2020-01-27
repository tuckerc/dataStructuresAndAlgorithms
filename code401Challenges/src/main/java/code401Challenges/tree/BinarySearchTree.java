package code401Challenges.tree;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {



  public void add(T val) {
    add(val, this.getRoot());
  }

  private void add(T val, Node<T> root) {
    if (root.getValue() == null) {
      root.setValue(val);
    }
    else if(val.compareTo(root.getValue()) < 0) {
      if(root.getLeft() != null) {
        add(val, root.getLeft());
      }
      else root.setLeft(new Node<T>(val));
    }
    else if(val.compareTo(root.getValue()) > 0) {
      if(root.getRight() != null) {
        add(val, root.getRight());
      }
      else root.setRight(new Node<T>(val));
    }
  }

  public boolean contains(T val) {
    T foundVal = contains(val, this.getRoot());
    if(foundVal != null) return true;
    return false;
  }

  private T contains(T val, Node<T> root) {
    if(val.compareTo(root.getValue()) < 0) {
      contains(val, root.getLeft());
    }
    else if(val.compareTo(root.getValue()) > 0) {
      contains(val, root.getRight());
    }
    return root.getValue();
  }
}
