import java.util.ArrayList;
import java.util.List;

class MyHashMap {

  private static final int SIZE = 1000;
  private List<int[]>[] map;

  public MyHashMap() {
    map = new ArrayList[SIZE];
    for (int i = 0; i < SIZE; i++) {
      map[i] = new ArrayList<>();
    }
  }

  public void put(int key, int value) {
    int index = key % SIZE;
    List<int[]> bucket = map[index];
    for (int[] pair : bucket) {
      if (pair[0] == key) {
        pair[1] = value;
        return;
      }
    }
    bucket.add(new int[] { key, value });
  }

  public int get(int key) {
    int index = key % SIZE;
    List<int[]> bucket = map[index];
    for (int[] pair : bucket) {
      if (pair[0] == key) {
        return pair[1];
      }
    }
    return -1;
  }

  public void remove(int key) {
    int index = key % SIZE;
    List<int[]> bucket = map[index];
    for (int i = 0; i < bucket.size(); i++) {
      int[] pair = bucket.get(i);
      if (pair[0] == key) {
        bucket.remove(i);
        return;
      }
    }
  }
}

// class MyHashMap {

// int[] map;

// public MyHashMap() {
// map = new int[1000001];
// for (int i = 0; i < map.length; i++) {
// map[i] = -1;
// }
// }

// public void put(int key, int value) {
// map[key] = value;
// }

// public int get(int key) {
// return map[key];
// }

// public void remove(int key) {
// map[key] = -1;
// }
// }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */