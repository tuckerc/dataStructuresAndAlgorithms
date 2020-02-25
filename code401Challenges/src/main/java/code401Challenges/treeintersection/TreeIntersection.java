package code401Challenges.treeintersection;

import code401Challenges.stacksandqueues.Queue;
import code401Challenges.tree.BinarySearchTree;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TreeIntersection {
  public static Set<Integer> treeIntersection(BinarySearchTree<Integer> tree1, BinarySearchTree<Integer> tree2) {
    Queue<Integer> tree1Values = tree1.breadthFirst();
    Queue<Integer> tree2Values = tree2.breadthFirst();

    HashSet<Integer> tree1Set = new HashSet<>();
    while(!tree1Values.isEmpty()) {
      tree1Set.add(tree1Values.dequeue());
    }
    HashSet<Integer> tree2Set = new HashSet<>();
    while(!tree2Values.isEmpty()) {
      tree2Set.add(tree2Values.dequeue());
    }
    HashSet<Integer> intersections = new HashSet<>();
    for(Integer i : tree1Set) {
      if(tree2Set.contains(i))
        intersections.add(i);
    }
    return intersections;
  }
}
