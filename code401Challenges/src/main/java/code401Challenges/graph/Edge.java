package code401Challenges.graph;

public class Edge<T, W> {
  private T value;
  private W weight;

  public Edge() {}

  public Edge(T value) {
    this.value = value;
  }

  public Edge(T value, W weight) {
    this.value = value;
    this.weight = weight;
  }

  public T getValue() {
    return value;
  }

  public W getWeight() {
    return weight;
  }

  @Override
  public String toString() {
    return "Edge{" +
        "value=" + value +
        ", weight=" + weight +
        '}';
  }
}
