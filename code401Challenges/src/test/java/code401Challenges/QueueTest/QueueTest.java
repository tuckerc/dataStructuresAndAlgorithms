package code401Challenges.QueueTest;

import code401Challenges.stacksandqueues.Queue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

  Queue<Integer> emptyQueue = new Queue<>();
  Queue<Integer> singleValQueue;
  Queue<Integer> twoValQueue;
  Queue<Integer> multipleValQueue;
  
  @Before
  public void setup() {
    singleValQueue = new Queue<>();
    singleValQueue.enqueue(1);
    twoValQueue = new Queue<>();
    twoValQueue.enqueue(1);
    twoValQueue.enqueue(2);
    multipleValQueue = new Queue<>();
    multipleValQueue.enqueue(1);
    multipleValQueue.enqueue(2);
    multipleValQueue.enqueue(3);
    multipleValQueue.enqueue(4);
  }

  @Test (expected = Exception.class)
  public void testConstructor() {
    emptyQueue.peek();
  }

  @Test
  public void testEnqueueSingleValue() {
    Assert.assertEquals((Integer) 1, singleValQueue.peek());
  }

  @Test
  public void testEnqueueTwoValues() {
    Assert.assertEquals((Integer) 1, twoValQueue.peek());
  }

  @Test
  public void testEnqueueMultipleValues() {
    Assert.assertEquals((Integer) 1, multipleValQueue.peek());
  }

  @Test (expected = Exception.class)
  public void testDequeueEmpty() {
    emptyQueue.dequeue();
  }

  @Test
  public void testDequeueSingleValue() {
    Integer val = singleValQueue.dequeue();
    Assert.assertEquals((Integer) 1, val);
  }

  @Test
  public void testDequeueTwoValues() {
    Integer val = twoValQueue.dequeue();
    Assert.assertEquals((Integer) 1, val);
  }
  
  @Test
  public void testDequeueMultipleValues() {
    Integer val = multipleValQueue.dequeue();
    Assert.assertEquals((Integer) 1, val);
    Assert.assertEquals((Integer) 2, multipleValQueue.peek());
    val = multipleValQueue.dequeue();
    Assert.assertEquals((Integer) 2, val);
    Assert.assertEquals((Integer) 3, multipleValQueue.peek());
    val = multipleValQueue.dequeue();
    Assert.assertEquals((Integer) 3, val);
    Assert.assertEquals((Integer) 4, multipleValQueue.peek());
    val = multipleValQueue.dequeue();
    Assert.assertEquals((Integer) 4, val);
    Assert.assertTrue(multipleValQueue.isEmpty());
  }

  @Test
  public void testPeek() {
    Assert.assertEquals((Integer) 1, singleValQueue.peek());
  }

}
