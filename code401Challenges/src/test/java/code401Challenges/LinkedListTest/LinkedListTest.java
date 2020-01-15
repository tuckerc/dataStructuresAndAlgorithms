package code401Challenges.LinkedListTest;

import code401Challenges.LinkedList.LinkedList;
import code401Challenges.LinkedList.Node;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {

  LinkedList<Integer> singleValueLinkedList;
  Integer newValue;

  LinkedList<Integer> emptyList;
  
  LinkedList<Integer> multipleValueList;

  @Before
  public void setup() {
    singleValueLinkedList = new LinkedList<>();
    newValue = 5;
    singleValueLinkedList.insert(newValue);
    
    emptyList = new LinkedList<>();
    
    multipleValueList = new LinkedList<>();
    newValue = 6;
    multipleValueList.insert(newValue);
    newValue = 8;
    multipleValueList.append(newValue);
    newValue = 12;
    multipleValueList.insertBefore(newValue, (Integer) 8);
    newValue = 5;
    multipleValueList.insertAfter(newValue, (Integer) 6);
  }

  @Test
  public void emptyLinkedListInstantiation() {
    assertNull(emptyList.getHead());
  }

  @Test
  public void singleValueLinkedListInsert() {
    assertEquals((Integer) 5, singleValueLinkedList.getHead().getValue());
  }

  @Test
  public void multipleValueLinkedListInsertMultiple() {
    newValue = 37;
    multipleValueList.insert(newValue);
    assertEquals(newValue, multipleValueList.getHead().getValue());
  }

  @Test
  public void multipleValueLinkedListIncludesTrue() {
    assertTrue(multipleValueList.includes(8));
  }

  @Test
  public void multipleValueLinkedListIncludesFalse() {
    assertFalse(multipleValueList.includes(120));
  }

  @Test
  public void multipleValueLinkedListToString() {
    String expected = "( 6 ) -> ( 5 ) -> ( 12 ) -> ( 8 ) -> NULL";
    assertEquals(expected, multipleValueList.toString());
  }

  @Test
  public void multipleValueLinkedListAppend() {
    assertEquals((Integer) 8, multipleValueList.kthFromEnd(0));
  }

  @Test
  public void multipleValueLinkedListInsertBefore() {
    assertEquals((Integer) 12, multipleValueList.kthFromEnd(1));
  }

  @Test
  public void multipleValueLinkedListInsertAfter() {
    assertEquals((Integer) 5, multipleValueList.kthFromEnd(2));
  }

  @Test
  public void multipleValueLinkedListKthFromEnd() {
    assertEquals((Integer) 8, multipleValueList.kthFromEnd(0));
    assertEquals((Integer) 12, multipleValueList.kthFromEnd(1));
    assertEquals((Integer) 6, multipleValueList.kthFromEnd(3));
  }

  @Test
  public void setSingleValueLinkedListKthFromEnd() {
    assertEquals((Integer) 5, singleValueLinkedList.kthFromEnd(0));
  }

  @Test (expected = Exception.class)
  public void singleValueLinkedListKthFromEndException() {
    singleValueLinkedList.kthFromEnd(99);
    singleValueLinkedList.kthFromEnd(1);
    singleValueLinkedList.kthFromEnd(-1);
  }

}
