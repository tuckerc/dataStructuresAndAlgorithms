# Graph
Java implementation of a graph data structure.

## Challenge
Implement a hash table data structure with a constructor, getters and the following methods: addNode, addEdge, getNodes, getNeighbors, breadthFirstTraversal size.

## Approach & Efficiency
1. Develop tests for each of the following:
2. Define a generic Edge class with a weight and value of same type as graph node type.
2. Define instance variables (size, HashMap of nodes and their neighbors with corresponding edges).
3. Define constructors.
4. Define getters.
5. Define addNode method that adds the given Node to the HashMap of the graph Nodes with a LinkedList for its neighbors and returns the added Node.
6. Define addEdge method that takes in two nodes and an optional weight. Both nodes should already be in the graph.
7. Define getNodes method that returns a HashSet of all the nodes in the graph.
8. Define getNeighbors method for a given Node and returns the LinkedList of its neighbors. The Node should be in the graph. If the Node is an island, return null.
9. Define breadthFirstTraversal method that takes in a node, performs a breadth first traversal, and returns a collection of nodes.
9. Test

## Link to Code
[Graph.java](../src/main/java/code401Challenges/graph/Graph.java)

## Link to Tests
[GraphTest](../src/test/java/code401Challenges/graph/GraphTest.java)
