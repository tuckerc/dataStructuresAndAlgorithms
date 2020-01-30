package code401Challenges.tree;

import code401Challenges.stacksandqueues.Queue;

public class BinaryTree<T extends Comparable<T>> {

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

  public T findMaxValue() {
    T maxValue = this.getRoot().getValue();
    Queue<Node<T>> nodesToProcess = new Queue<>();
    nodesToProcess.enqueue(this.getRoot());
    Node<T> currentNode;
    if (this.getRoot() != null) {
      currentNode = this.getRoot();
      nodesToProcess.enqueue(currentNode);
    }
    while (!nodesToProcess.isEmpty()) {
      currentNode = nodesToProcess.dequeue();
      if(currentNode.getValue().compareTo(maxValue) > 0) {
        maxValue = currentNode.getValue();
      }
      if (currentNode.getLeft() != null) {
        nodesToProcess.enqueue(currentNode.getLeft());
      }
      if (currentNode.getRight() != null) {
        nodesToProcess.enqueue(currentNode.getRight());
      }
    }
    return maxValue;
  }

  public Queue<T> breadthFirst() {
    Queue<Node<T>> nodesToProcess = new Queue<>();
    Queue<T> values = new Queue<>();
    Node<T> currentNode = this.getRoot();
    if (currentNode != null) {
      nodesToProcess.enqueue(this.getRoot());
    }
    while (!nodesToProcess.isEmpty()) {
      currentNode = nodesToProcess.dequeue();
      values.enqueue(currentNode.getValue());
      if (currentNode.getLeft() != null) {
        nodesToProcess.enqueue(currentNode.getLeft());
      }
      if (currentNode.getRight() != null) {
        nodesToProcess.enqueue(currentNode.getRight());
      }
    }
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
