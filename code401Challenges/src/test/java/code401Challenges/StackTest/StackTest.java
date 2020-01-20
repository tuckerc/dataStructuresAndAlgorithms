package code401Challenges.StackTest;

import code401Challenges.stacksandqueues.Stack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

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

  @Test (expected = NoSuchElementException.class)
  public void testEmptyConstructor() {
    emptyStack.peek();
  }

  @Test
  public void testSinglePush() {
    Assert.assertEquals((Integer) 1, singleValueStack.peek());
  }

  @Test
  public void testMultiplePush() {
    Assert.assertEquals((Integer) 30, multipleValueStack.peek());
  }

  @Test
  public void testSinglePop() {
    Integer actual = actual = singleValueStack.pop();
    Assert.assertEquals((Integer) 1, actual);
  }

  @Test
  public void testMultiplePop() {
    multipleValueStack.pop();
    multipleValueStack.pop();
    multipleValueStack.pop();
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
