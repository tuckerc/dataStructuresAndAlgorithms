package code401Challenges.utilities;

import code401Challenges.tree.BinaryTree;
import code401Challenges.tree.Node;
import org.junit.Before;
import org.junit.Test;

import static code401Challenges.utilities.FizzBuzzTree.fizzBuzzTree;
import static org.junit.Assert.*;

public class FizzBuzzTreeTest {

  BinaryTree<Integer> emptyTree;
  BinaryTree<Integer> testTree;

  @Before
  public void setUp() throws Exception {
    emptyTree = new BinaryTree<>();
    testTree = new BinaryTree<>(new Node<Integer>(22,
        new Node<Integer>(10,
            new Node<Integer>(9,
                new Node<Integer>(12),
                new Node<Integer>(150)),
            new Node<Integer>(30)),
        new Node<Integer>(90,
            new Node<Integer>(25),
            new Node<Integer>(3,
                null,
                new Node<Integer>(88)))));
  }

  @Test
  public void testEmptyTree() {
    assertNull(fizzBuzzTree(emptyTree).getRoot().getValue());
  }

  @Test
  public void testNotEmptyTree() {
    assertNotNull(fizzBuzzTree(testTree).getRoot().getValue());
  }

  @Test
  public void testResultPreOrder() {
    assertEquals("22 => Buzz => Fizz => Fizz => FizzBuzz => FizzBuzz => FizzBuzz => Buzz => Fizz => 88", fizzBuzzTree(testTree).preOrder().toString());
  }
}