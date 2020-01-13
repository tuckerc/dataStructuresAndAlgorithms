package code401Challenges;

public class LinkedList <T> {

  private Node head;

  public LinkedList() {
    this.head = new Node <T> ();
  }

  public Node getHead() {
    return this.head;
  }

  public <T> void insert(T val) {
    Node newNode = new Node <T> (val);
    newNode.setNext(this.getHead().getNext());
    this.getHead().setNext(newNode);
  }

  public <T> boolean includes(T val) {
    Node currentNode = this.getHead();
    while(currentNode.getNext() != null) {
      if(currentNode.getValue() == val) return true;
      currentNode = currentNode.getNext();
    }
    return false;
  }

  public String toString() {
    String valueString = "";
    Node curentNode = this.getHead();
    while (curentNode.getNext() != null) {
      curentNode = (Node) curentNode.getNext();
      valueString = valueString + "( " + curentNode.getValue() + " ) -> ";
    }
    valueString = valueString + "NULL";
    return valueString;
  }
}
