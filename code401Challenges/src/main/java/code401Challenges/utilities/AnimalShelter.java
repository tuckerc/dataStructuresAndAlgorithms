package code401Challenges.utilities;

import code401Challenges.stacksandqueues.Queue;

import java.sql.Date;
import java.util.NoSuchElementException;

public class AnimalShelter {
  private Queue<ShelterDog> dogs;
  private Queue<ShelterCat> cats;

  public AnimalShelter() {
    this.dogs = new Queue<>();
    this.cats = new Queue<>();
  }

  public void enqueue(ShelterDog dog) {
    dogs.enqueue(dog);
  }

  public void enqueue(ShelterCat cat) {
    cats.enqueue(cat);
  }

  public ShelterAnimal dequeue(String animal) {
    if (dogs.isEmpty() && cats.isEmpty()) {
      throw new NoSuchElementException("sorry. the shelter is empty");
    }
    else if (animal.toLowerCase().equals("dog") && !dogs.isEmpty()) {
      return dogs.dequeue();
    }
    else if (animal.toLowerCase().equals("cat") && !cats.isEmpty()) {
      return cats.dequeue();
    }
    else {
      throw new IllegalArgumentException("you must provide either 'dog' or 'cat'");
    }
  }

  public ShelterAnimal dequeue() {
    if (dogs.isEmpty() && cats.isEmpty()) {
      throw new NoSuchElementException("sorry. the shelter is empty");
    }
    else if (dogs.isEmpty()) {
      return cats.dequeue();
    }
    else if (cats.isEmpty()) {
      return dogs.dequeue();
    } else {
      Date dogDate = dogs.peek().getArrivalDate();
      Date catDate = cats.peek().getArrivalDate();
      if (dogDate.before(catDate)) {
        return dogs.dequeue();
      }
    } return cats.dequeue();
  }
}
