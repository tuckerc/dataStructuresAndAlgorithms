package code401Challenges.LinkedList;

public class LinkedList <T> {

  private Node<T> head;
  int size;

  public LinkedList() {
    this.head = null;
    this.size = 0;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
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
    this.setSize(this.getSize() + 1);
  }

  public void append(T val) {
    Node<T> newNode = new Node<T> (val);
    if ( this.getHead() == null) {
      this.setHead(newNode);
      return;
    }
    Node<T> currentNode = this.getHead();
    while( currentNode.getNext() != null ) {
      currentNode = currentNode.getNext();
    }
    currentNode.setNext(newNode);
    this.setSize(this.getSize() + 1);
  }

  public void insertBefore(T newVal, T refVal) {
    if( this.includes(refVal) ) {
      Node<T> currentNode = this.getHead();
      if ( currentNode.getValue() == refVal ) {
        this.insert(newVal);
      }
      while ( currentNode.getNext() != null ) {
        if ( currentNode.getNext().getValue() == refVal ) {
          Node<T> newNode = new Node<>(newVal, currentNode.getNext());
          currentNode.setNext(newNode);
          this.setSize(this.getSize() + 1);
          return;
        }
        currentNode = currentNode.getNext();
      }
    } else {
      throw new IllegalArgumentException("refVal not in the list");
    }
  }

  public void insertAfter(T newVal, T refVal) {
    if( this.includes(refVal) ) {
      Node<T> currentNode = this.getHead();
      while ( currentNode != null ) {
        if ( currentNode.getValue() == refVal ) {
          Node<T> newNode = new Node<>(newVal, currentNode.getNext());
          currentNode.setNext(newNode);
          this.setSize(this.getSize() + 1);
          return;
        }
        currentNode = currentNode.getNext();
      }
    } else {
      throw new IllegalArgumentException("refVal not in the list");
    }
  }

  public T kthFromEnd(int k) {
    if ( k > -1 && k > (this.getSize() - 1)) {
      throw new IndexOutOfBoundsException("k cannot be greater then linked list size - 1");
    }
    Node<T> currentNode = this.getHead();
    int iterations = this.getSize() - k - 1;
    while (iterations > 0) {
      currentNode = currentNode.getNext();
      iterations--;
    }
    return currentNode.getValue();
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

  public static LinkedList mergeLists(LinkedList firstList, LinkedList secondList) {
    // create new list to store zipped nodes from two lists
    LinkedList mergedList = new LinkedList();

    // zip merge the two lists

    // return the mergedList
    return mergedList;
  }
}
