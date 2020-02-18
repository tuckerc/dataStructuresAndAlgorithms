package code401Challenges.hashtable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashtableTest {

  Hashtable<Integer> ages;
  Hashtable<String> favoriteFoods;
  Hashtable<Integer> emptyHashtable;

  @Before
  public void setUp() {
    ages = new Hashtable<>(5);
    ages.add("Chase", 34);
    ages.add("Danae", 36);
    ages.add("Wyatt", 5);
    ages.add("Easton", 3);
    ages.add("Caden", 2);

    favoriteFoods = new Hashtable<>(100, 20);
    favoriteFoods.add("Chase", "King Ranch chicken casserole");
    favoriteFoods.add("Danae", "chicken picatta");
    favoriteFoods.add("Wyatt", "chicken nuggets");
    favoriteFoods.add("Easton", "mac and cheese");
    favoriteFoods.add("Caden", "cheese");

    emptyHashtable = new Hashtable<>();
  }

  @Test
  public void intHashtableTestSize() {
    Assert.assertEquals(10, ages.getSize());
  }

  @Test
  public void strHashtableTestSize() {
    Assert.assertEquals(100, favoriteFoods.getSize());
  }

  @Test
  public void emptyHashtableTestSize() {
    Assert.assertEquals(16, emptyHashtable.getSize());
  }

  @Test
  public void intHashtableTestGet() {
    Assert.assertEquals(Integer.valueOf(34), ages.get("Chase"));
    Assert.assertEquals(Integer.valueOf(36), ages.get("Danae"));
    Assert.assertEquals(Integer.valueOf(5), ages.get("Wyatt"));
    Assert.assertEquals(Integer.valueOf(3), ages.get("Easton"));
    Assert.assertEquals(Integer.valueOf(2), ages.get("Caden"));
  }

  @Test
  public void strHashtableTestGet() {
    Assert.assertEquals("King Ranch chicken casserole", favoriteFoods.get("Chase"));
    Assert.assertEquals("chicken picatta", favoriteFoods.get("Danae"));
    Assert.assertEquals("chicken nuggets", favoriteFoods.get("Wyatt"));
    Assert.assertEquals("mac and cheese", favoriteFoods.get("Easton"));
    Assert.assertEquals("cheese", favoriteFoods.get("Caden"));
  }

  @Test
  public void emptyHastableTestGet() {
    Assert.assertNull(emptyHashtable.get("Chase"));
  }

  @Test
  public void intHashtableTestContains() {
    Assert.assertTrue(ages.contains("Chase"));
    Assert.assertTrue(ages.contains("Danae"));
    Assert.assertTrue(ages.contains("Wyatt"));
    Assert.assertTrue(ages.contains("Easton"));
    Assert.assertTrue(ages.contains("Caden"));
  }

  @Test
  public void strHashtableTestContains() {
    Assert.assertTrue(favoriteFoods.contains("Chase"));
    Assert.assertTrue(favoriteFoods.contains("Danae"));
    Assert.assertTrue(favoriteFoods.contains("Wyatt"));
    Assert.assertTrue(favoriteFoods.contains("Easton"));
    Assert.assertTrue(favoriteFoods.contains("Caden"));
  }

  @Test
  public void emptyHashtableContains() {
    Assert.assertFalse(emptyHashtable.contains("Chase"));
  }
}