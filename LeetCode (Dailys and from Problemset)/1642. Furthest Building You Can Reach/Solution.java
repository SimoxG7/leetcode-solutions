import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public int furthestBuilding(int[] heights, int bricks, int ladders) {
    int remBricks = bricks;
    int remLad = ladders;
    Queue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
    for (int i = 1; i < heights.length; i++) {
      if (heights[i] <= heights[i - 1]) {
        continue;
      }
      int diff = heights[i] - heights[i - 1];
      if (remLad > 0) {
        pq.add(diff);
        remLad--;
      } else if (!pq.isEmpty() && pq.peek() < diff) {
        pq.add(diff);
        remBricks -= pq.poll();
      } else {
        remBricks -= diff;
      }
      if (remBricks < 0) {
        return i - 1;
      }
    }
    return heights.length - 1;
  }
}