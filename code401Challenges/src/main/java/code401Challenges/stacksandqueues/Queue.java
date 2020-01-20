package code401Challenges.stacksandqueues;

import java.util.NoSuchElementException;

public class Queue<T> {

  private Node<T> front;
  private Node<T> back;


  public Queue() {
    this.front = new Node<>();
    this.back = new Node<>();
    this.front.setNext(this.back);
  }

  public void enqueue(T val) {
    if (this.isEmpty()) {
      this.front.setValue(val);
    }
    else if (this.back.getValue() == null) {
      this.back.setValue(val);
    } else {
      Node<T> newNode = new Node<>(val);
      this.back.setNext(newNode);
      this.back = newNode;
    }
  }

  public T dequeue() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("cannot dequeue. queue is empty");
    }
    else if (this.front.getNext() == this.back) {
      Node<T> temp = new Node<>(this.front.getValue());
      this.front = this.front.getNext();
      Node<T> newBack = new Node<>();
      this.back = newBack;
      this.front.setNext(this.back);
      return temp.getValue();
    }
    else {
      Node<T> temp = new Node<>(this.front.getValue());
      this.front = this.front.getNext();
      return temp.getValue();
    }
  }

  public T peek() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("you can't peek an empty queue");
    } else {
      return this.front.getValue();
    }
  }

  public boolean isEmpty() {
    return this.front.getValue() == null;
  }
}
