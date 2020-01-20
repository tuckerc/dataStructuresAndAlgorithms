package code401Challenges.stacksandqueues;

public class Queue<T> {

  private Node<T> front;
  private Node<T> back;


  public Queue() {
    this.front = new Node<>();
    this.back = new Node<>();
    this.front.setNext(this.back);
  }


  public Node<T> getFront() {
    return this.front;
  }

  public void setFront(Node<T> front) {
    this.front = front;
  }

  public Node<T> getBack() {
    return this.back;
  }

  public void setBack(Node<T> back) {
    this.back = back;
  }

  public void enqueue(T val) {
    if (this.isEmpty()) {
      this.getFront().setValue(val);
    }
    else if (this.getBack().getValue() == null) {
      this.getBack().setValue(val);
    } else {
      Node<T> newNode = new Node<>(val);
      this.getBack().setNext(newNode);
      this.setBack(newNode);
    }
  }

  public T dequeue() {
    if (this.isEmpty()) {
      throw new NullPointerException("cannot dequeue. queue is empty");
    }
    else if (this.getFront().getNext() == this.getBack()) {
      Node<T> temp = new Node<>(this.getFront().getValue());
      this.setFront(this.getFront().getNext());
      Node<T> newBack = new Node<>();
      this.setBack(newBack);
      this.getFront().setNext(this.getBack());
      return temp.getValue();
    }
    else {
      Node<T> temp = new Node<>(this.getFront().getValue());
      this.setFront(this.getFront().getNext());
      return temp.getValue();
    }
  }

  public T peek() {
    return this.getFront().getValue();
  }

  public boolean isEmpty() {
    return this.getFront().getValue() == null;
  }
}
