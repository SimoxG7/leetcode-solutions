import java.util.HashMap;
import java.util.Map;

class LRUCache {

  class Node {
    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
      next = null;
      prev = null;
    }
  }

  private Map<Integer, Node> m;
  private Node head;
  private Node tail;
  private int size;

  public LRUCache(int capacity) {
    size = capacity;
    m = new HashMap<>();
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  private void deleteNode(Node p) {
    Node pre = p.prev;
    Node nex = p.next;
    pre.next = nex;
    nex.prev = pre;
  }

  private void addNode(Node newnode) {
    Node temp = head.next;
    head.next = newnode;
    newnode.prev = head;
    newnode.next = temp;
    temp.prev = newnode;
  }

  public int get(int key) {
    if (!m.containsKey(key))
      return -1;

    Node p = m.get(key);
    deleteNode(p);
    addNode(p);
    m.put(key, head.next);
    return head.next.val;
  }

  public void put(int key, int value) {
    if (m.containsKey(key)) {
      Node c = m.get(key);
      deleteNode(c);
      c.val = value;
      addNode(c);
      m.put(key, head.next);
    } else {
      if (m.size() == size) {
        Node prev = tail.prev;
        deleteNode(prev);
        Node l = new Node(key, value);
        addNode(l);
        m.remove(prev.key);
        m.put(key, head.next);
      } else {
        Node l = new Node(key, value);
        addNode(l);
        m.put(key, head.next);
      }
    }
  }
}

// Example usage:
// LRUCache cache = new LRUCache(capacity);
// int value = cache.get(key);
// cache.put(key, value);

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// import java.util.HashMap;
// import java.util.LinkedList;

// public class LRUCache {

// private final int capacity;
// private final HashMap<Integer, Node> map;
// private final LinkedList<Node> list;

// public LRUCache(int capacity) {
// this.capacity = capacity;
// this.map = new HashMap<>();
// this.list = new LinkedList<>();
// }

// public int get(int key) {
// if (!map.containsKey(key)) {
// return -1;
// }

// Node node = map.get(key);
// list.remove(node);
// list.addFirst(node);
// return node.value;
// }

// public void put(int key, int value) {
// if (map.containsKey(key)) {
// Node node = map.get(key);
// node.value = value;
// list.remove(node);
// list.addFirst(node);
// return;
// }

// if (map.size() == capacity) {
// Node node = list.removeLast();
// map.remove(node.key);
// }

// Node newNode = new Node(key, value);
// list.addFirst(newNode);
// map.put(key, newNode);
// }

// private static class Node {
// private int key;
// private int value;

// public Node(int key, int value) {
// this.key = key;
// this.value = value;
// }
// }
// }
