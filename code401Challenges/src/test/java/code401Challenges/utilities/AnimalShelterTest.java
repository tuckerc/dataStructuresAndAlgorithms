package code401Challenges.utilities;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class AnimalShelterTest {

  AnimalShelter emptyShelter;
  AnimalShelter singleAnimalShelter;
  AnimalShelter multipleAnimalShelter;

  @Before
  public void setUp() throws Exception {
    emptyShelter = new AnimalShelter();
    singleAnimalShelter = new AnimalShelter();
    singleAnimalShelter.enqueue(
        new ShelterCat( "Dexter", 9,
            new Date(2020, 1, 1)));
    multipleAnimalShelter = new AnimalShelter();
    multipleAnimalShelter.enqueue(
        new ShelterCat("Buster", 1,
            new Date(2019, 01, 12)));
    multipleAnimalShelter.enqueue(
        new ShelterDog("Indie", 11,
            new Date(2018, 1, 13)));
    multipleAnimalShelter.enqueue(
        new ShelterCat("Mr. Miagi", 5,
            new Date(2019, 2, 23)));
    multipleAnimalShelter.enqueue(
        new ShelterDog("Chloe", 14,
            new Date(2019, 6, 13)));
  }

  @Test
  public void testConstructor() {
    assertNotNull(emptyShelter);
  }

  @Test (expected = NoSuchElementException.class)
  public void testEmptyShelterDequeue() {
    emptyShelter.dequeue();
  }

  @Test
  public void testSingleShelterDequeue() {
    assertNotNull(singleAnimalShelter);
    assertEquals("Dexter", singleAnimalShelter.dequeue().getName());
  }

  @Test
  public void testMultipleShelterDequeueNotSpecified() {
    assertNotNull(multipleAnimalShelter);
    assertEquals("Indie", multipleAnimalShelter.dequeue().getName());
    assertEquals("Buster", multipleAnimalShelter.dequeue().getName());
  }

  @Test
  public void testMultipleShelterDequeueSpecified() {
    assertNotNull(multipleAnimalShelter);
    assertEquals("Indie", multipleAnimalShelter.dequeue("dog").getName());
    assertEquals("Buster", multipleAnimalShelter.dequeue("cat").getName());
  }
}