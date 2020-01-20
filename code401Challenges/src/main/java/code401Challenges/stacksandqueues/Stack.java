package code401Challenges.stacksandqueues;

public class Stack<T> {

  private Node<T> top;

  public Stack() {
    this.top = null;
  }

  public Node<T> getTop() {
    return this.top;
  }

  public void setTop(Node<T> newTop) {
    this.top = newTop;
  }

  public void push(T val) {
    Node<T> newNode = new Node<>(val);
    Node<T> temp = this.getTop();
    this.setTop(newNode);
    this.getTop().setNext(temp);
  }

  public T pop() {
    if (this.isEmpty()) {
      throw new IndexOutOfBoundsException("unable to pop from an empty stack");
    }
    Node<T> temp = this.getTop();
    if (this.getTop().getNext() == null) {
      this.setTop(new Node<T>());
    } else {
      this.setTop(this.getTop().getNext());
    }
    return temp.getValue();
  }

  public T peek() {
    return this.getTop().getValue();
  }

  public boolean isEmpty() {
    return this.getTop() == null;
  }
}
