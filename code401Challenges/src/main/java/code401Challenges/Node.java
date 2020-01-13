package code401Challenges;

public class Node<T> {

  private T value;
  private Node next;

  public Node() {
    this.next = null;
  }

  public Node(T nodeValue) {

    this.value = nodeValue;
    this.next = null;

  }

  public T getValue() {
    return (T) this.value;
  }

  public void setValue(T newValue) {
    this.value = newValue;
  }

  public Node getNext() {
    return this.next;
  }

  public void setNext(Node newNext) {
    this.next = newNext;
  }

}
