package code401Challenges.stacksandqueues;

import java.util.NoSuchElementException;

public class Stack<T> {

  private Node<T> top;

  public Stack() {
    this.top = null;
  }

  public void push(T val) {
    Node<T> newNode = new Node<>(val);
    Node<T> temp = this.top;
    this.top = newNode;
    this.top.setNext(temp);
  }

  public T pop() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("unable to pop from an empty stack");
    }
    Node<T> temp = this.top;
    if (this.top.getNext() == null) {
      this.top = new Node<T>();
    } else {
      this.top = this.top.getNext();
    }
    return temp.getValue();
  }

  public T peek() {
    if (this.isEmpty()) {
      throw new NoSuchElementException("cannot peek on an empty stack");
    } else {
      return this.top.getValue();
    }
  }

  public boolean isEmpty() {
    return this.top == null;
  }
}
