import java.util.Deque;
import java.util.LinkedList;

class MyCircularDeque {

  static int size;
  static Deque<Integer> list;

  public MyCircularDeque(int k) {
    size = k;
    list = new LinkedList<>();
  }

  public boolean insertFront(int value) {
    if (list.size() < size) {
      list.addFirst(value);
      return true;
    }
    return false;
  }

  public boolean insertLast(int value) {
    if (list.size() < size) {
      list.addLast(value);
      return true;
    }
    return false;
  }

  public boolean deleteFront() {
    if (list.size() > 0) {
      list.removeFirst();
      return true;
    }
    return false;
  }

  public boolean deleteLast() {
    if (list.size() > 0) {
      list.removeLast();
      return true;
    }
    return false;
  }

  public int getFront() {
    if (isEmpty()) {
      return -1;
    }
    return list.getFirst();
  }

  public int getRear() {
    if (isEmpty()) {
      return -1;
    }
    return list.getLast();
  }

  public boolean isEmpty() {
    return list.size() == 0;
  }

  public boolean isFull() {
    return list.size() == size;
  }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */