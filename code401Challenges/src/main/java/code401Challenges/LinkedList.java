package code401Challenges;

public class LinkedList <T> {

  private Node<T> head;

  public LinkedList() {
    this.head = null;
  }

  public Node<T> getHead() {
    return this.head;
  }

  public void setHead(Node<T> newHead) {
    this.head = newHead;
  }

  public void insert(T val) {
    Node<T> newNode = new Node <T> (val);
    newNode.setNext(this.getHead());
    this.setHead(newNode);
  }

  public boolean includes(T val) {
    Node<T> currentNode = this.getHead();
    while(currentNode != null) {
      if(currentNode.getValue() == val) return true;
      currentNode = currentNode.getNext();
    }
    return false;
  }

  public String toString() {
    String valueString = "";
    Node<T> currentNode = this.getHead();
    while (currentNode != null) {
      valueString = valueString + "( " + currentNode.getValue() + " ) -> ";
      currentNode = currentNode.getNext();
    }
    valueString = valueString + "NULL";
    return valueString;
  }
}
