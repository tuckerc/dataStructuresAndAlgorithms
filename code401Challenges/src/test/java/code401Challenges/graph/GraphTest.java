package code401Challenges.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {

  Graph<String, Double> cities;
  Graph<Integer, Double> busStops;

  @Before
  public void setUp() throws Exception {
    cities = new Graph<>();
    cities.addNode("Seattle");
    cities.addNode("Spokane");
    cities.addEdge("Seattle", "Spokane", 228.41);
    cities.addNode("Tacoma");
    cities.addEdge("Seattle", "Tacoma", 33.6);
    cities.addNode("Vancouver");
    cities.addEdge("Tacoma", "Vancouver", 112.0);
    cities.addEdge("Vancouver", "Seattle", 165.3);
    cities.addNode("Ellensburg");
    cities.addEdge("Seattle", "Ellensburg", 107.2);
    cities.addEdge("Ellensburg", "Spokane", 172.4);
    cities.addNode("Kent");

    busStops = new Graph<>();
    busStops.addNode(1);
    busStops.addNode(2);
    busStops.addNode(3);
    busStops.addNode(4);
    busStops.addNode(5);
    busStops.addNode(6);
    busStops.addEdge(1, 2);
    busStops.addEdge(2, 3);
    busStops.addEdge(3, 4);
    busStops.addEdge(4, 5);
    busStops.addEdge(5, 1);
  }

  @Test
  public void sizeTest() {
    Assert.assertEquals(6, cities.getSize());
    Assert.assertNotEquals(-43, cities.getSize());
    Assert.assertEquals(6, busStops.getSize());
    Assert.assertNotEquals(-109, busStops.getSize());
  }

  @Test
  public void getNodesTest() {
    Assert.assertTrue(cities.getNodes().contains("Seattle"));
    Assert.assertFalse(cities.getNodes().contains("----"));
    Assert.assertTrue(busStops.getNodes().contains(2));
    Assert.assertFalse(busStops.getNodes().contains(-100));
  }

  @Test
  public void getNeighborsTest() {
    Assert.assertEquals("Spokane",
        cities.getNeighbors("Seattle").get(0).getValue());
    Assert.assertEquals(0,
        cities.getNeighbors("Kent").size());
    Assert.assertEquals((Integer) 2,
        busStops.getNeighbors(1).get(0).getValue());
    Assert.assertEquals(0,
        busStops.getNeighbors(6).size());
  }
}