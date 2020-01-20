package code401Challenges.StackTest;

import code401Challenges.stacksandqueues.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

  Stack<Integer> emptyStack = new Stack<>();
  Stack<Integer> singleValueStack = new Stack<>();
  Stack<Integer> multipleValueStack = new Stack<>();

  @Before
  public void setup() {
    singleValueStack.push(1);
    multipleValueStack.push(10);
    multipleValueStack.push(20);
    multipleValueStack.push(30);
  }

  @Test
  public void testConstructor() {
    Assert.assertNull(emptyStack.getTop());
  }

  @Test
  public void testSinglePush() {
    Assert.assertEquals((Integer) 1, singleValueStack.getTop().getValue());
  }

  @Test
  public void testMultiplePush() {
    Assert.assertEquals((Integer) 30, multipleValueStack.getTop().getValue());
  }

  @Test
  public void testSinglePop() {
    Integer actual = null;
    try {
      actual = singleValueStack.pop();
    } catch (IndexOutOfBoundsException e) {
      System.out.println("you can't pop from an empty stack " + e);
      e.printStackTrace();
    }
    Assert.assertEquals((Integer) 1, actual);
  }

  @Test
  public void testMultiplePop() {
    try {
      multipleValueStack.pop();
      multipleValueStack.pop();
      multipleValueStack.pop();
    } catch (IndexOutOfBoundsException e) {
      System.out.println("you can't pop from an empty stack " + e);
      e.printStackTrace();
    }
    Assert.assertFalse(multipleValueStack.isEmpty());
  }

  @Test (expected = Exception.class)
  public void testEmptyPop() {
    emptyStack.pop();
  }

  @Test
  public void testIsEmpty() {
    Assert.assertTrue(emptyStack.isEmpty());
  }

  @Test
  public void testPeek() {
    Assert.assertEquals((Integer) 1, singleValueStack.peek());
  }

}
