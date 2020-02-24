package code401Challenges.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph<T, W> {
  private long size;
  private HashMap<T, LinkedList<Edge<T, W>>> nodes;

  public Graph() {
    nodes = new HashMap<>();
  }

  public T addNode(T value) {
    nodes.put(value, new LinkedList<>());
    size++;
    return value;
  }

  public void addEdge(T firstNode, T secondValue) throws IllegalArgumentException {
    // check to see if both nodes exist in graph
    if(!nodes.containsKey(firstNode) || !nodes.containsKey(secondValue))
      throw new IllegalArgumentException("One of the provided nodes is not included in the graph.");

    // add edge to both nodes
    nodes.get(firstNode).add(new Edge<T, W>(secondValue));
    nodes.get(secondValue).add(new Edge<T, W>(firstNode));
  }

  public void addEdge(T firstNode, T secondValue, W weight) throws IllegalArgumentException {
    // check to see if both nodes exist in graph
    if(!nodes.containsKey(firstNode) || !nodes.containsKey(secondValue))
      throw new IllegalArgumentException("One of the provided nodes is not included in the graph.");

    // add edge to both nodes
    nodes.get(firstNode).add(new Edge<T, W>(secondValue, weight));
    nodes.get(secondValue).add(new Edge<T, W>(firstNode, weight));
  }

  public HashSet<T> getNodes() {
    return new HashSet<>(nodes.keySet());
  }

  public LinkedList<Edge<T, W>> getNeighbors(T node) throws IllegalArgumentException {
    // check to see if node exists in graph
    if(!nodes.containsKey(node))
      throw new IllegalArgumentException("The provided node is not in the graph");

    // return the node's edges
    return nodes.get(node);
  }

  public long getSize() { return size; }
}
