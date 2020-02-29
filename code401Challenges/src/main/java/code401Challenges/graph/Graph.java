package code401Challenges.graph;

import code401Challenges.stacksandqueues.Queue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

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

  public Queue<T> breadthFirstTraversal (T node) throws IllegalArgumentException {
    // check to see if node exists in graph
    if(!nodes.containsKey(node))
      throw new IllegalArgumentException("The provided node is not in the graph");

    // queue to hold nodes still to process
    Queue<T> nodesToProcess = new Queue<>();
    // Set of nodes seen
    HashSet<T> nodesSeen = new HashSet<>();
    // Queue to hold search results
    Queue<T> searchResults = new Queue<>();

    nodesSeen.add(node);
    nodesToProcess.enqueue(node);
    searchResults.enqueue(node);

    // keep searching until there are no nodes to process
    while(!nodesToProcess.isEmpty()) {
      LinkedList<Edge<T, W>> edges = nodes.get(nodesToProcess.dequeue());
      for(Edge<T, W> edge : edges) {
        if(!nodesSeen.contains(edge.getValue())) {
          nodesToProcess.enqueue(edge.getValue());
          searchResults.enqueue(edge.getValue());
          nodesSeen.add(edge.getValue());
        }
      }
    }

    return searchResults;
  }

  public Queue<T> depthFirstTraversal (T node) throws IllegalArgumentException {
    // check to see if node exists in graph
    if(!nodes.containsKey(node))
      throw new IllegalArgumentException("The provided node is not in the graph");

    // queue to hold nodes still to process
    Stack<T> nodesToProcess = new Stack<>();
    // Set of nodes seen
    HashSet<T> nodesSeen = new HashSet<>();
    // Queue to hold search results
    Queue<T> searchResults = new Queue<>();

    nodesSeen.add(node);
    nodesToProcess.push(node);
    searchResults.enqueue(node);

    // keep searching until there are no nodes to process
    while(!nodesToProcess.isEmpty()) {
      LinkedList<Edge<T, W>> edges = nodes.get(nodesToProcess.pop());
      for(Edge<T, W> edge : edges) {
        if(!nodesSeen.contains(edge.getValue())) {
          nodesToProcess.push(edge.getValue());
          searchResults.enqueue(edge.getValue());
          nodesSeen.add(edge.getValue());
        }
      }
    }

    return searchResults;
  }

  public static String isPath(Graph<String, Integer> graph, String[] connections) {
    // string to be returned as the result
    String result = "";
    boolean pathExists = true;
    Integer cost = 0;

    // if only one city, no flight can exist
    if(connections.length <= 1) {
      pathExists = false;
    } else {
      // check to see if all nodes are in the graph
      for(String conn : connections) {
        if(!graph.getNodes().contains(conn))
          pathExists = false;
      }

      // loop through connections trying to make complete direct connections
      for(int i = 0; i < connections.length - 1 && pathExists; i++) {
        LinkedList<Edge<String, Integer>> links = graph.getNeighbors(connections[i]);
        pathExists = false;
        for(Edge<String, Integer> link : links) {
          if(link.getValue().equals(connections[i + 1])) {
            pathExists = true;
            cost += link.getWeight();
          }
        }
      }
    }

    if(pathExists) {
      result = "True, $" + cost;
    } else {
      result = "False";
    }

    return result;
  }

  public long getSize() { return size; }
}
