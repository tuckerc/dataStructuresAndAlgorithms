package code401Challenges.LinkedListTest;

import code401Challenges.LinkedList.LinkedList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {

  LinkedList<Integer> testLinkedList;
  int newValue;

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
    assertEquals(newValue, (int) testLinkedList.getHead().getValue());
  }

  @Test
  public void testLinkedListInsertMultiple() {
    newValue = 6;
    testLinkedList.insert(newValue);
    assertEquals(newValue, (int) testLinkedList.getHead().getValue());
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

}
