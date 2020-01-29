package code401Challenges.utilities;

import code401Challenges.tree.BinarySearchTree;
import code401Challenges.tree.BinaryTree;
import code401Challenges.tree.Node;

public class FizzBuzzTree {

  public static BinaryTree<String> fizzBuzzTree(BinaryTree<Integer> originalTree) {
    BinaryTree<String> newTree = new BinaryTree<>();
    if (originalTree.getRoot().getValue() != null) {
      _fizzBuzzTree(originalTree.getRoot(), newTree.getRoot());
    }
    return newTree;
  }

  private static void _fizzBuzzTree(Node<Integer> originalRoot, Node<String> newRoot) {

    if (originalRoot.getValue() % 15 == 0) {
      newRoot.setValue("FizzBuzz");
    }
    else if (originalRoot.getValue() % 3 == 0) {
      newRoot.setValue("Fizz");
    }
    else if (originalRoot.getValue() % 5 == 0) {
      newRoot.setValue("Buzz");
    }
    else {
      newRoot.setValue(originalRoot.getValue().toString());
    }
    if (originalRoot.getLeft() != null) {
      newRoot.setLeft(new Node<String>());
      _fizzBuzzTree(originalRoot.getLeft(), newRoot.getLeft());
    }
    if (originalRoot.getRight() != null) {
      newRoot.setRight(new Node<String>());
      _fizzBuzzTree(originalRoot.getRight(), newRoot.getRight());
    }
  }
}
