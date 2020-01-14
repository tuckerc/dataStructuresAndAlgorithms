package code401Challenges;

public class Node<T> {

  private T value;
  private Node<T> next;

  public Node() {
    this.next = null;
  }

  public Node(T nodeValue) {

    this.value = nodeValue;
    this.next = null;

  }

  public Node(T nodeValue, Node<T> nextNode) {

    this.value = nodeValue;
    this.next = nextNode;

  }

  public T getValue() {
    return (T) this.value;
  }

  public void setValue(T newValue) {
    this.value = newValue;
  }

  public Node<T> getNext() {
    return this.next;
  }

  public void setNext(Node<T> newNext) {
    this.next = newNext;
  }

}
