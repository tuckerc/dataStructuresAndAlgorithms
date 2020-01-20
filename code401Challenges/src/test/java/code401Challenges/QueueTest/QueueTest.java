package code401Challenges.QueueTest;

import code401Challenges.stacksandqueues.Queue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

  Queue<Integer> emptyQueue = new Queue<>();
  Queue<Integer> singleValQueue = new Queue<>();
  Queue<Integer> twoValQueue = new Queue<>();
  Queue<Integer> multipleValQueue = new Queue<>();
  
  @Before
  public void setup() {
    singleValQueue.enqueue(1);
    twoValQueue.enqueue(1);
    twoValQueue.enqueue(2);
    multipleValQueue.enqueue(1);
    multipleValQueue.enqueue(2);
    multipleValQueue.enqueue(3);
    multipleValQueue.enqueue(4);
  }

  @Test
  public void testConstructor() {
    Assert.assertNull(emptyQueue.getFront().getValue());
    Assert.assertNull(emptyQueue.getBack().getValue());
    Assert.assertTrue(emptyQueue.getFront().getNext() == emptyQueue.getBack());
  }

  @Test
  public void testEnqueueSingleValue() {
    Assert.assertEquals((Integer) 1, singleValQueue.getFront().getValue());
    Assert.assertNull(singleValQueue.getBack().getValue());
  }

  @Test
  public void testEnqueueTwoValues() {
    Assert.assertEquals((Integer) 1, twoValQueue.getFront().getValue());
    Assert.assertEquals((Integer) 2, twoValQueue.getBack().getValue());
  }

  @Test
  public void testEnqueueMultipleValues() {
    Assert.assertEquals((Integer) 1, multipleValQueue.getFront().getValue());
    Assert.assertEquals((Integer) 4, multipleValQueue.getBack().getValue());
  }

  @Test (expected = Exception.class)
  public void testDequeueEmpty() {
    emptyQueue.dequeue();
  }

  @Test
  public void testDequeueSingleValue() {
    Integer val = singleValQueue.dequeue();
    Assert.assertEquals((Integer) 1, val);
    Assert.assertNull(singleValQueue.getFront().getValue());
  }

  @Test
  public void testDequeueTwoValues() {
    Integer val = twoValQueue.dequeue();
    Assert.assertEquals((Integer) 1, val);
    Assert.assertNull(twoValQueue.getBack().getValue());
  }
  
  @Test
  public void testDequeueMultipleValues() {
    Integer val = multipleValQueue.dequeue();
    Assert.assertEquals((Integer) 1, val);
    Assert.assertEquals((Integer) 2, multipleValQueue.getFront().getValue());
    val = multipleValQueue.dequeue();
    Assert.assertEquals((Integer) 2, val);
    Assert.assertEquals((Integer) 3, multipleValQueue.getFront().getValue());
    val = multipleValQueue.dequeue();
    Assert.assertEquals((Integer) 3, val);
    Assert.assertEquals((Integer) 4, multipleValQueue.getFront().getValue());
    val = multipleValQueue.dequeue();
    Assert.assertEquals((Integer) 4, val);
    Assert.assertTrue(multipleValQueue.isEmpty());
  }

  @Test
  public void testPeek() {
    Assert.assertNull(emptyQueue.peek());
    Assert.assertEquals((Integer) 1, singleValQueue.peek());
  }

}
