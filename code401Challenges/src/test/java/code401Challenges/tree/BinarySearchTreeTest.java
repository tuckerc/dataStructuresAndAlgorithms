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
  public void testPreOrder() {
    System.out.println(intBST.preOrder());
  }

  @Test
  public void testInOrder() {
    System.out.println(intBST.inOrder());
  }
}