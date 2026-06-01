import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public int minimumCost(int[] cost) {
    Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < cost.length; i++) {
      pq.add(cost[i]);
    }
    int res = 0;
    while (!pq.isEmpty()) {
      int a = pq.poll();
      int b = !pq.isEmpty() ? pq.poll() : 0;
      res += a + b;
    }
    return res;

  }
}