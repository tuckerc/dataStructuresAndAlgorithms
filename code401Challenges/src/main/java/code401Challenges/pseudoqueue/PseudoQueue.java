package code401Challenges.pseudoqueue;

import code401Challenges.stacksandqueues.Stack;

import java.util.NoSuchElementException;

public class PseudoQueue<T> {
  private Stack<T> mainStack;
  private Stack<T> helperStack;

  public PseudoQueue() {
    this.mainStack = new Stack<>();
    this.helperStack = new Stack<>();
  }

  public void enqueue(T val) {
    while ( !this.mainStack.isEmpty() ) {
      this.helperStack.push(this.mainStack.pop());
    }
    this.helperStack.push(val);
    while ( !this.helperStack.isEmpty()) {
      this.mainStack.push(this.helperStack.pop());
    }
  }

  public T dequeue() {
    if ( !this.mainStack.isEmpty() ) {
      return this.mainStack.pop();
    } else {
      throw new NoSuchElementException("you attempted to dequeue from an empty queue");
    }
  }

  public boolean isEmpty() {
    return this.mainStack.isEmpty();
  }

  public T peek() {
    return this.mainStack.peek();
  }
}
