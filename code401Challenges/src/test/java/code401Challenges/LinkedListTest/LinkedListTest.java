package code401Challenges.LinkedListTest;

import code401Challenges.LinkedList.LinkedList;
import code401Challenges.LinkedList.Node;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {

  LinkedList<Integer> singleValueLinkedList;
  LinkedList<Integer> singleValueLinkedList2;

  Integer newValue;

  LinkedList<Integer> emptyList;
  LinkedList<Integer> emptyList2;
  
  LinkedList<Integer> multipleValueList;
  LinkedList<Integer> multipleValueList2;

  @Before
  public void setup() {
    singleValueLinkedList = new LinkedList<>();
    newValue = 5;
    singleValueLinkedList.insert(newValue);

    singleValueLinkedList2 = new LinkedList<>();
    newValue = 58;
    singleValueLinkedList2.insert(newValue);
    
    emptyList = new LinkedList<>();
    emptyList2 = new LinkedList<>();
    
    multipleValueList = new LinkedList<>();
    newValue = 6;
    multipleValueList.insert(newValue);
    newValue = 8;
    multipleValueList.append(newValue);
    newValue = 12;
    multipleValueList.insertBefore(newValue, 8);
    newValue = 5;
    multipleValueList.insertAfter(newValue, 6);

    multipleValueList2 = new LinkedList<>();
    newValue = 67;
    multipleValueList2.insert(newValue);
    newValue = 48;
    multipleValueList2.append(newValue);
    newValue = 1642;
    multipleValueList2.insertBefore(newValue, 48);
    newValue = 598;
    multipleValueList2.insertAfter(newValue, 67);
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

  @Test
  public void singleValueLinkedListReverse() {
    String original = singleValueLinkedList.toString();
    singleValueLinkedList.reverse();
    String expected = singleValueLinkedList.toString();
    assertEquals(original, expected);
  }

  @Test
  public void multipleValueLinkedListReverse() {
    String original = multipleValueList.toString();
    multipleValueList.reverse();
    String expected = multipleValueList.toString();
    assertNotEquals(original, expected);
  }

  @Test
  public void emptyListReverse() {
    String original = emptyList.toString();
    emptyList.reverse();
    String expected = emptyList.toString();
    assertEquals(original, expected);
  }

  @Test ( expected = Exception.class)
  public void testEmptyListsMerge() {
    LinkedList.mergeLists(emptyList, emptyList2);
  }

  @Test
  public void testMultipleValueListMerge() {
    LinkedList.mergeLists(multipleValueList, multipleValueList2);
    String expected = "( 6 ) -> ( 67 ) -> ( 5 ) -> ( 598 ) -> ( 12 ) -> ( 1642 ) -> ( 8 ) -> ( 48 ) -> NULL";
    String actual = multipleValueList.toString();
    assertEquals(expected, actual);
  }

  @Test
  public void testSingleValueListMerge() {
    String expected = "( 5 ) -> ( 58 ) -> NULL";
    LinkedList.mergeLists(singleValueLinkedList, singleValueLinkedList2);
    String actual = singleValueLinkedList.toString();
    assertEquals(expected, actual);
  }

  @Test
  public void testDifferentLengthListMerge() {
    String expected = "( 6 ) -> ( 5 ) -> ( 5 ) -> ( 12 ) -> ( 8 ) -> NULL";
    LinkedList.mergeLists(multipleValueList, singleValueLinkedList);
    String actual = multipleValueList.toString();
    assertEquals(expected, actual);
  }

}
