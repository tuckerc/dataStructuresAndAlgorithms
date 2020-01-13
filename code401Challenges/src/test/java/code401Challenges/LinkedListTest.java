package code401Challenges;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {

  @Test
  public void testLinkedListInstantiation() {

    LinkedList <Integer> testLinkedList = new LinkedList<>();
    assertNull(testLinkedList.getHead().getNext());

  }

  @Test
  public void testLinkedListInsert() {
    LinkedList <Integer> testLinkedList = new LinkedList <>();
    int newValue = 5;
    testLinkedList.insert(newValue);
    assertEquals(newValue, testLinkedList.getHead().getNext().getValue());
  }

  @Test
  public void testLinkedListInsertMultiple() {
    LinkedList <Integer> testLinkedList = new LinkedList<>();
    int newValue = 5;
    testLinkedList.insert(newValue);
    double doubleValue = 6.6;
    testLinkedList.insert(doubleValue);
    assertEquals(doubleValue, testLinkedList.getHead().getNext().getValue());
  }

  @Test
  public void testLinkedListIncludesTrue() {
    LinkedList <Integer> testLinkedList = new LinkedList<>();
    int newValue = 5;
    testLinkedList.insert(newValue);
    newValue = 6;
    testLinkedList.insert(newValue);
    assertTrue(testLinkedList.includes(newValue));
  }

  @Test
  public void testLinkedListIncludesFalse() {
    LinkedList <Integer> testLinkedList = new LinkedList<>();
    int newValue = 5;
    testLinkedList.insert(newValue);
    newValue = 6;
    testLinkedList.insert(newValue);
    assertFalse(testLinkedList.includes(12));
  }

  @Test
  public void testLinkedListToString() {
    LinkedList <Integer> testLinkedList = new LinkedList<>();
    int newValue = 5;
    testLinkedList.insert(newValue);
    newValue = 6;
    testLinkedList.insert(newValue);
    String expected = "( 6 ) -> ( 5 ) -> NULL";
    assertEquals(expected, testLinkedList.toString());
  }


}
