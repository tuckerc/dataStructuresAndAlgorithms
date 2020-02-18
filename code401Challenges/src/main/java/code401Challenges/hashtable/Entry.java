package code401Challenges.hashtable;

public class Entry<T> {
    private String key;
    private T val;

    public Entry(String key, T val) {
        this.key = key;
        this.val = val;
    }

    public String getKey() {
        return key;
    }

    public T getVal() {
        return val;
    }
}
