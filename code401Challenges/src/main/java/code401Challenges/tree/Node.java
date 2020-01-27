package code401Challenges.tree;

public class Node<T> {

  private T value;
  private Node<T> left;
  private Node<T> right;

  public Node() {
    this.value = null;
    this.left = null;
    this.right = null;
  }

  public Node(T value) {
    this.value = value;
  }

  public T getValue() {
    if(this.value == null) {
      return null;
    }
    return this.value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Node<T> getLeft() {
    if(this.left == null) {
      return null;
    }
    return this.left;
  }

  public void setLeft(Node<T> left) {
    this.left = left;
  }

  public Node<T> getRight() {
    if (this.right == null) {
      return null;
    }
    return this.right;
  }

  public void setRight(Node<T> right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return "{ " + this.value + " }";
  }
}
