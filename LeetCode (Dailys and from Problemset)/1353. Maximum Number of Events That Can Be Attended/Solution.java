import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public int maxEvents(int[][] events) {
    Arrays.sort(events, (a, b) -> a[0] - b[0]);
    Queue<Integer> minHeap = new PriorityQueue<>();
    int day = 1, i = 0, n = events.length, count = 0;
    int maxDay = 0;
    for (int[] e : events) {
      maxDay = Math.max(maxDay, e[1]);
    }
    while (day <= maxDay) {
      while (i < n && events[i][0] == day) {
        minHeap.offer(events[i][1]);
        i++;
      }
      while (!minHeap.isEmpty() && minHeap.peek() < day) {
        minHeap.poll();
      }
      if (!minHeap.isEmpty()) {
        minHeap.poll();
        count++;
      }
      day++;
    }
    return count;
  }
}