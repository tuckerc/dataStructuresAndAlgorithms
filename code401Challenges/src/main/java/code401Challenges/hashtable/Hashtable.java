package code401Challenges.hashtable;

import java.util.Vector;

public class Hashtable<T> {
  private int size;
  private int load;
  private double loadFactor;
  private Vector<T> table;

  public Hashtable(int size, double loadFactor) {
    this.size = size;
    this.load = 0;
    this.loadFactor = loadFactor;
    this.table = new Vector<>(size);
  }

  public Hashtable(int size) {
    this.size = size;
    this.load = 0;
    this.loadFactor = 0.75;
    this.table = new Vector<>(size);
  }

  public Hashtable() {
    this.size = 16;
    this.load = 0;
    this.loadFactor = 0.75;
    this.table = new Vector<>(16);
  }

  private int hash(String key) {
    // character array to store each char in key
    char[] letters = key.toCharArray();

    // iterate through letters to generate ASC
    double sum = 0;
    for (int i = 0; i < letters.length; i++) {
      double power = Math.pow((int) letters[i], i);
      sum += power;
    }
    return (int) (sum * 599) % this.size;
  }

  private void resize() {
    this.size *= 2;
    Vector<T> tempVector = new Vector<>(this.size);
    tempVector.addAll(0, this.table);
    this.table = tempVector;
  }

  public void add(String key, T val) {
    // resize table if greater than load factor
    if(load > (table.size() * loadFactor)) {
      this.resize();
    }
    // add the value at the proper index
    table.add(this.hash(key), val);
    load++;
  }

  public T get(String key) {
    return this.table.get(this.hash(key));
  }

  public boolean contains(String key) {
    return this.get(key) != null;
  }

  public int getSize() {
    return size;
  }
}
