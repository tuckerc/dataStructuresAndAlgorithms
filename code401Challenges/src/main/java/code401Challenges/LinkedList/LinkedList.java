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

  public void reverse() {
    if(this.getHead() != null && this.getHead().getNext() != null) {
      Node<T> previous = null;
      Node<T> current = this.getHead();
      Node<T> next = current.getNext();
      while(current != null) {
        current.setNext(previous);
        previous = current;
        current = next;
        if(next != null) {
          next = next.getNext();
        }
      }
      this.setHead(previous);
    }
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
    if(firstList.getHead() != null && secondList.getHead() != null) {
      // set the head of the first list to the result of _mergeNodes
      firstList.setHead(_mergeNodes(firstList.getHead(), secondList.getHead()));
      return firstList;
    } else {
      throw new IllegalArgumentException("You can't merge two empty lists");
    }
  }

  private static Node _mergeNodes(Node firstNode, Node secondNode) {
    if ( firstNode == null ) {
      return secondNode;
    }
    else if (secondNode == null) {
      return firstNode;
    } else {
      Node remainingNods = _mergeNodes(firstNode.getNext(), secondNode.getNext());
      secondNode.setNext(remainingNods);
      firstNode.setNext(secondNode);
      return firstNode;
    }
  }
}
