package code401Challenges.tree;

import code401Challenges.stacksandqueues.Queue;

public class BinaryTree<T> {

  private Node<T> root;

  public BinaryTree() {
    this.root = new Node<T>();
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
    if(root.getLeft() != null) _preOrderRecurse(root.getLeft(), values);
    values.enqueue(root.getValue());
    if (root.getRight() != null) _preOrderRecurse(root.getRight(), values);
  }

  public Queue<T> postOrder() {
    Queue<T> values = new Queue<>();
    _postOrderRecurse(this.getRoot(), values);
    return values;
  }

  private void _postOrderRecurse(Node<T> root, Queue<T> values) {
    if(root.getLeft() != null) _preOrderRecurse(root.getLeft(), values);
    if (root.getRight() != null) _preOrderRecurse(root.getRight(), values);
    values.enqueue(root.getValue());
  }
}
