package code401Challenges.hashtable;

import java.util.LinkedList;
import java.util.Vector;

public class Hashtable<T> {
  private int size;
  private int load;
  private double loadFactor;
  private Vector<LinkedList<Entry<T>>> table;

  public Hashtable(int size, double loadFactor) {
    this.size = size;
    this.load = 0;
    this.loadFactor = loadFactor;
    this.table = new Vector<>(size);
    this.table.setSize(size);
  }

  public Hashtable(int size) {
    this.size = size;
    this.load = 0;
    this.loadFactor = 0.75;
    this.table = new Vector<>(size);
    this.table.setSize(size);
  }

  public Hashtable() {
    this.size = 16;
    this.load = 0;
    this.loadFactor = 0.75;
    this.table = new Vector<>(16);
    this.table.setSize(16);
  }

  private int hash(String key) {
    // character array to store each char in key
    char[] letters = key.toCharArray();

    // iterate through letters to generate ASC
    double sum = 0;
    for (int i = 0; i < letters.length; i++) {
      double power = Math.pow((int) letters[i], i + 1);
      sum += power;
    }
    sum = (sum * 599) % this.size;
    return (int) sum;
  }

  private void resize() {
    this.size *= 2;
    LinkedList<Entry<T>> entries = new LinkedList<>();
    for(LinkedList<Entry<T>> list : this.table) {
      if(list != null) {
        entries.addAll(0,list);
      }
    }
    this.table.clear();
    this.table.setSize(this.size);
    for(Entry<T> entry : entries) {
      this.add(entry.getKey(), entry.getVal());
    }
  }

  public void add(String key, T val) {
    // resize table if greater than load factor
    if(load > (table.capacity() * loadFactor)) {
      this.resize();
    }

    // get the linked list at given index
    LinkedList<Entry<T>> ll = table.get(this.hash(key));
    if(ll == null) {
      ll = new LinkedList<>();
    }
    ll.add(new Entry<T>(key, val));

    // add the value at the proper index
    table.set(this.hash(key), ll);
    load++;
  }

  public T get(String key) {
    LinkedList<Entry<T>> ll = this.table.get(this.hash(key));
    if (ll != null) {
      for(Entry<T> entry : ll) {
        if(entry.getKey() == key) {
          return entry.getVal();
        }
      }
    }
    return null;
  }

  public boolean contains(String key) {
    LinkedList<Entry<T>> ll = this.table.get(this.hash(key));
    return ll != null;
  }

  public int getSize() {
    return size;
  }
}
