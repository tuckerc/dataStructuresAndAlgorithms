package code401Challenges.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {

  Graph<String, Double> cities;
  Graph<String, Integer> airports;
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

    airports = new Graph<>();
    airports.addNode("Seattle");
    airports.addNode("Spokane");
    airports.addEdge("Seattle", "Spokane", 228);
    airports.addNode("Tacoma");
    airports.addEdge("Seattle", "Tacoma", 33);
    airports.addNode("Vancouver");
    airports.addEdge("Tacoma", "Vancouver", 112);
    airports.addEdge("Vancouver", "Seattle", 165);
    airports.addNode("Ellensburg");
    airports.addEdge("Seattle", "Ellensburg", 107);
    airports.addEdge("Ellensburg", "Spokane", 172);
    airports.addNode("Kent");

    busStops = new Graph<>();
    busStops.addNode(1);
    busStops.addNode(2);
    busStops.addNode(3);
    busStops.addNode(4);
    busStops.addNode(5);
    busStops.addNode(6);
    busStops.addNode(44);
    busStops.addEdge(1, 2);
    busStops.addEdge(2, 3);
    busStops.addEdge(3, 4);
    busStops.addEdge(4, 5);
    busStops.addEdge(5, 1);
  }

  @Test
  public void sizeTest() {
    Assert.assertEquals(6, cities.getSize());
    Assert.assertEquals(7, busStops.getSize());
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

  @Test
  public void breadthFirstTest() {
    Assert.assertEquals("Seattle => Spokane => Tacoma => Vancouver => Ellensburg",
        cities.breadthFirstTraversal("Seattle").toString());
    Assert.assertEquals("Spokane => Seattle => Ellensburg => Tacoma => Vancouver",
        cities.breadthFirstTraversal("Spokane").toString());
    Assert.assertEquals("Tacoma => Seattle => Vancouver => Spokane => Ellensburg",
        cities.breadthFirstTraversal("Tacoma").toString());
    Assert.assertEquals("Vancouver => Tacoma => Seattle => Spokane => Ellensburg",
        cities.breadthFirstTraversal("Vancouver").toString());
    Assert.assertEquals("Ellensburg => Seattle => Spokane => Tacoma => Vancouver",
        cities.breadthFirstTraversal("Ellensburg").toString());
    Assert.assertEquals("Kent => null", cities.breadthFirstTraversal("Kent").toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void breadthFirstFailTest() {
    cities.breadthFirstTraversal("Marysville");
  }

  @Test
  public void depthFirstTest() {
    Assert.assertEquals("Seattle => Spokane => Tacoma => Vancouver => Ellensburg",
        cities.depthFirstTraversal("Seattle").toString());
    Assert.assertEquals("Spokane => Seattle => Ellensburg => Tacoma => Vancouver",
        cities.depthFirstTraversal("Spokane").toString());
    Assert.assertEquals("Tacoma => Seattle => Vancouver => Spokane => Ellensburg",
        cities.depthFirstTraversal("Tacoma").toString());
    Assert.assertEquals("Vancouver => Tacoma => Seattle => Spokane => Ellensburg",
        cities.depthFirstTraversal("Vancouver").toString());
    Assert.assertEquals("Ellensburg => Seattle => Spokane => Tacoma => Vancouver",
        cities.depthFirstTraversal("Ellensburg").toString());
    Assert.assertEquals("Kent => null",
        cities.depthFirstTraversal("Kent").toString());
  }
  
  @Test
  public void isPathTest() {
    Assert.assertEquals("True, $33", Graph.isPath(airports, new String[]{"Seattle", "Tacoma"}));
    Assert.assertEquals("True, $112", Graph.isPath(airports, new String[]{"Tacoma", "Vancouver"}));
    Assert.assertEquals("True, $172", Graph.isPath(airports, new String[]{"Spokane", "Ellensburg"}));
    Assert.assertEquals("True, $145", Graph.isPath(airports, new String[]{"Seattle", "Tacoma", "Vancouver"}));
    Assert.assertEquals("True, $393", Graph.isPath(airports, new String[]{"Spokane", "Seattle", "Vancouver"}));
    Assert.assertEquals("True, $279", Graph.isPath(airports, new String[]{"Seattle", "Ellensburg", "Spokane"}));
    Assert.assertEquals("True, $848", Graph.isPath(airports, new String[]{"Vancouver", "Tacoma", "Seattle", "Ellensburg", "Spokane",
        "Ellensburg", "Seattle", "Tacoma", "Vancouver"}));
    Assert.assertEquals("False", Graph.isPath(airports, new String[]{}));
    Assert.assertEquals("False", Graph.isPath(airports, new String[]{"Seattle"}));
    Assert.assertEquals("False", Graph.isPath(airports, new String[]{"Kent"}));
    Assert.assertEquals("False", Graph.isPath(airports, new String[]{"Kent", "Seattle"}));
    Assert.assertEquals("False", Graph.isPath(airports, new String[]{"Tacoma", "Spokane"}));
    Assert.assertEquals("False", Graph.isPath(airports, new String[]{"Austin", "Seattle"}));
  }
}