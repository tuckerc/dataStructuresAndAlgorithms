package code401Challenges;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {

  @Test
  public void testLinkedListInstantiation() {

    LinkedList <Integer> testLinkedList = new LinkedList <Integer> ();
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
    LinkedList <Integer> testLinkedList = new LinkedList <Integer> ();
    int newValue = 5;
    testLinkedList.insert(newValue);
    double doubleValue = 6.6;
    testLinkedList.insert(doubleValue);
    assertEquals(doubleValue, testLinkedList.getHead().getNext().getValue());
  }

  @Test
  public void testLinkedListIncludesTrue() {
    LinkedList <Integer> testLinkedList = new LinkedList <Integer> ();
    int newValue = 5;
    testLinkedList.insert(newValue);
    double doubleValue = 6.6;
    testLinkedList.insert(doubleValue);
    assertTrue(testLinkedList.includes(doubleValue));
  }


}
