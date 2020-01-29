package code401Challenges.tree;

import code401Challenges.stacksandqueues.Queue;

public class BinaryTree<T> {

  private Node<T> root;

  public BinaryTree() {
    this.root = new Node<T>();
  }

  public BinaryTree(Node<T> root) {
    this.root = root;
  }

  public Node<T> getRoot() {
    if(this.root == null) {
      return null;
    }
    return this.root;
  }

  public void setRoot(Node<T> root) {
    this.root = root;
  }

  public long getHeight() {
    return _getHeight(this.getRoot());
  }

  private long _getHeight(Node<T> root) {
    if (root == null) {
      return 0;
    } else {
      long leftHeight = _getHeight(root.getLeft());
      long rightHeight = _getHeight(root.getRight());

      if (leftHeight > rightHeight) {
        return leftHeight + 1;
      } else {
        return rightHeight + 1;
      }
    }
  }

  public Queue<T> breadthFirst() {
    Queue<T> values = new Queue<>();
    long height = getHeight();

    return values;
  }

  public Queue<T> preOrder() {
    Queue<T> values = new Queue<>();
    _preOrderRecurse(this.getRoot(), values);
    return values;
  }

  private void _preOrderRecurse(Node<T> root, Queue<T> values) {
    values.enqueue(root.getValue());
    if(root.getLeft() != null) _preOrderRecurse(root.getLeft(), values);
    if (root.getRight() != null) _preOrderRecurse(root.getRight(), values);
  }

  public Queue<T> inOrder() {
    Queue<T> values = new Queue<>();
    _inOrderRecurse(this.getRoot(), values);
    return values;
  }

  private void _inOrderRecurse(Node<T> root, Queue<T> values) {
    if(root.getLeft() != null) _inOrderRecurse(root.getLeft(), values);
    values.enqueue(root.getValue());

    if (root.getRight() != null) _inOrderRecurse(root.getRight(), values);
  }

  public Queue<T> postOrder() {
    Queue<T> values = new Queue<>();
    _postOrderRecurse(this.getRoot(), values);
    return values;
  }

  private void _postOrderRecurse(Node<T> root, Queue<T> values) {
    if(root.getLeft() != null) _postOrderRecurse(root.getLeft(), values);
    if (root.getRight() != null) _postOrderRecurse(root.getRight(), values);
    values.enqueue(root.getValue());
  }
}
