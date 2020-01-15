package code401Challenges.LinkedListTest;

import code401Challenges.LinkedList.LinkedList;
import code401Challenges.LinkedList.Node;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {

  LinkedList<Integer> testLinkedList;
  Integer newValue;

  @Before
  public void setup() {
    testLinkedList = new LinkedList<>();
    newValue = 5;
    testLinkedList.insert(newValue);
  }

  @Test
  public void testLinkedListInstantiation() {
    assertNull(testLinkedList.getHead().getNext());
  }

  @Test
  public void testLinkedListInsert() {
    assertEquals(newValue, testLinkedList.getHead().getValue());
  }

  @Test
  public void testLinkedListInsertMultiple() {
    newValue = 6;
    testLinkedList.insert(newValue);
    assertEquals(newValue, testLinkedList.getHead().getValue());
  }

  @Test
  public void testLinkedListIncludesTrue() {
    assertTrue(testLinkedList.includes(newValue));
  }

  @Test
  public void testLinkedListIncludesFalse() {
    assertFalse(testLinkedList.includes(12));
  }

  @Test
  public void testLinkedListToString() {
    newValue = 6;
    testLinkedList.insert(newValue);
    String expected = "( 6 ) -> ( 5 ) -> NULL";
    assertEquals(expected, testLinkedList.toString());
  }

  @Test
  public void testLinkedListAppend() {
    newValue = 8;
    testLinkedList.append(newValue);
    Node<Integer> currentNode = testLinkedList.getHead();
    while ( currentNode.getNext() != null) {
      currentNode = currentNode.getNext();
    }
    assertEquals(newValue, currentNode.getValue());
  }

  @Test
  public void testLinkedListInsertBefore() {
    newValue = 6;
    testLinkedList.insert(newValue);
    newValue = 8;
    testLinkedList.append(newValue);
    newValue = 12;
    testLinkedList.insertBefore(newValue, 5);
    String expected = "( 6 ) -> ( 12 ) -> ( 5 ) -> ( 8 ) -> NULL";
    assertEquals(expected, testLinkedList.toString());
  }

  @Test
  public void testLinkedListInsertAfter() {
    newValue = 6;
    testLinkedList.insert(newValue);
    newValue = 8;
    testLinkedList.append(newValue);
    newValue = 12;
    testLinkedList.insertAfter(newValue, 5);
    String expected = "( 6 ) -> ( 5 ) -> ( 12 ) -> ( 8 ) -> NULL";
    assertEquals(expected, testLinkedList.toString());
  }

}
