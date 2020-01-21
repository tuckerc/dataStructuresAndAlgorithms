package code401Challenges.pseudoqueuetest;

import code401Challenges.pseudoqueue.PseudoQueue;
import code401Challenges.stacksandqueues.Stack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PseudoQueueTest {
  PseudoQueue<Integer> emptyQueue;
  PseudoQueue<String> singleValQueue;
  PseudoQueue<Stack> multipleValQueue;
  Stack<Integer> intStack;
  Stack<Double> doubleStack;
  Stack<String> stringStack;

  @Before
  public void setup() {
    emptyQueue = new PseudoQueue<>();
    singleValQueue = new PseudoQueue<>();
    singleValQueue.enqueue("Awesome queue of strings");
    multipleValQueue = new PseudoQueue<>();
    intStack = new Stack<>();
    intStack.push(34);
    intStack.push(88);
    intStack.push(45);
    multipleValQueue.enqueue(intStack);
    doubleStack = new Stack<>();
    doubleStack.push(44.7);
    doubleStack.push(66.987);
    multipleValQueue.enqueue(doubleStack);
    stringStack = new Stack<>();
    stringStack.push("foo");
    stringStack.push("bar");
    multipleValQueue.enqueue(stringStack);
  }

  @Test
  public void testConstructor() {
    assertTrue(emptyQueue.isEmpty());
  }

  @Test
  public void testEnqueue() {
    assertEquals("Awesome queue of strings", singleValQueue.peek());
    assertEquals(intStack.peek(), multipleValQueue.peek().peek());
  }

  @Test
  public void testDequeue() {
    singleValQueue.dequeue();
    assertTrue(singleValQueue.isEmpty());
    multipleValQueue.dequeue();
    assertEquals(doubleStack.peek(), multipleValQueue.peek().peek());
  }
}
