package code401Challenges.tree;

import code401Challenges.stacksandqueues.Queue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

  BinarySearchTree<Integer> emptyBST = new BinarySearchTree<>();
  BinarySearchTree<Integer> intBST = new BinarySearchTree<>();
  BinarySearchTree<String> stringBST = new BinarySearchTree<>();

  @Before
  public void setUp() throws Exception {
    intBST.add(5);
    intBST.add(6);
    intBST.add(3);
    intBST.add(1);
    intBST.add(9);
    intBST.add(7);
    intBST.add(2);

    stringBST.add("carrot");
    stringBST.add("apple");
    stringBST.add("banana");
    stringBST.add("potato");
    stringBST.add("porcupine");
    stringBST.add("food");
    stringBST.add("tomato");
    stringBST.add("adam");
    stringBST.add("dog");
  }

  @Test
  public void testConstructor() {
    assertNull(emptyBST.getRoot().getValue());
  }

  @Test
  public void testMaxValue() {
    assertEquals((Integer) 9, intBST.findMaxValue());
    assertEquals("tomato", stringBST.findMaxValue());
  }

  @Test
  public void testDepthFrist() {
    assertEquals("5 => 3 => 6 => 1 => 9 => 2 => 7", intBST.breadthFirst().toString());
    assertEquals("carrot => apple => potato => adam => banana => porcupine => tomato => food => dog",
        stringBST.breadthFirst().toString());
  }

  @Test
  public void testPreOrder() {
    assertEquals("5 => 3 => 1 => 2 => 6 => 9 => 7", intBST.preOrder().toString());
    assertEquals("carrot => apple => adam => banana => potato => porcupine => food => dog => tomato",
        stringBST.preOrder().toString());
  }

  @Test
  public void testInOrder() {
    assertEquals("1 => 2 => 3 => 5 => 6 => 7 => 9", intBST.inOrder().toString());
    assertEquals("adam => apple => banana => carrot => dog => food => porcupine => potato => tomato",
        stringBST.inOrder().toString());
  }

  @Test
  public void testPostOrder() {
    assertEquals("2 => 1 => 3 => 7 => 9 => 6 => 5", intBST.postOrder().toString());
    assertEquals("adam => banana => apple => dog => food => porcupine => tomato => potato => carrot",
        stringBST.postOrder().toString());
  }

  @Test
  public void testContains() {
    assertTrue(intBST.contains(9));
    assertTrue(stringBST.contains("food"));
    assertFalse(intBST.contains(900));
    assertFalse(stringBST.contains("oreo"));
  }
}