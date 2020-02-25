package code401Challenges.treeintersection;

import code401Challenges.tree.BinarySearchTree;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static code401Challenges.treeintersection.TreeIntersection.treeIntersection;
import static org.junit.Assert.*;

public class TreeIntersectionTest {

  BinarySearchTree<Integer> intTree1;
  BinarySearchTree<Integer> intTree2;

  @Before
  public void setUp() throws Exception {
    intTree1 = new BinarySearchTree<>();
    intTree2 = new BinarySearchTree<>();
    intTree1.add(1);
    intTree1.add(2);
    intTree1.add(3);
    intTree1.add(4);
    intTree1.add(5);
    intTree2.add(1);
    intTree2.add(3);
    intTree2.add(5);
  }

  @Test
  public void treeIntersectionTest() {
    Set<Integer> intersections = treeIntersection(intTree1, intTree2);
    assertTrue(intersections.contains(1));
    assertTrue(intersections.contains(3));
    assertTrue(intersections.contains(5));
    assertFalse(intersections.contains(2));
    assertFalse(intersections.contains(4));
  }
}