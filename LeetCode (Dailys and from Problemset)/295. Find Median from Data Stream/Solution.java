import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
  private final Queue<Integer> maxHeap;
  private final Queue<Integer> minHeap;

  public MedianFinder() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
  }

  public void addNum(int num) {
    if (maxHeap.size() == minHeap.size()) {
      if (!maxHeap.isEmpty() && maxHeap.peek() >= num) {
        maxHeap.add(num);
      } else {
        minHeap.add(num);
      }
    } else {
      if (!maxHeap.isEmpty() && maxHeap.peek() >= num) {
        maxHeap.add(num);
        if (maxHeap.size() > minHeap.size()) {
          minHeap.add(maxHeap.poll());
        }
      } else {
        minHeap.add(num);
        if (minHeap.size() > maxHeap.size()) {
          maxHeap.add(minHeap.poll());
        }
      }
    }
  }

  public double findMedian() {
    if (maxHeap.size() == minHeap.size()) {
      return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
    } else {
      if (maxHeap.size() > minHeap.size()) {
        return maxHeap.peek();
      }
      return minHeap.peek();
    }
  }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */